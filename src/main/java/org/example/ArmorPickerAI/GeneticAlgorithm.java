package org.example.ArmorPickerAI;

import java.util.ArrayList;
import java.util.Random;

public class GeneticAlgorithm {
    private ArmorPieceDAO armorPieceDAO;
    private int min;
    public ArrayList<ArmorSet> populationInizializer(String account) {
        armorPieceDAO = new ArmorPieceDAO();
        armorPieceDAO.loadArmorPiece(account);
        ArrayList<ArmorSet> population = new ArrayList<>();
        Random random = new Random();

        int numeroElmi = armorPieceDAO.helmets.size();
        int numeroGuanti = armorPieceDAO.gloves.size();
        int numeroPetto = armorPieceDAO.chestplates.size();
        int numeroGambe = armorPieceDAO.leggings.size();
        int numeroMantelli = armorPieceDAO.cloaks.size();

        min = numeroElmi;
        if(numeroGuanti < min)
            min = numeroGuanti;
        if(numeroPetto < min)
            min = numeroPetto;
        if(numeroGambe < min)
            min = numeroGambe;
        if(numeroMantelli < min)
            min = numeroMantelli;

        int numeroPopolazione = min * min;

        for (int i = 0; i < numeroPopolazione; i++) {
            ArmorSet armorSet = new ArmorSet();
            if(random.nextBoolean())
                armorSet.setHelmet(armorPieceDAO.helmets.get(random.nextInt(0, min)));
            else
                armorSet.setHelmet(armorPieceDAO.helmets.get(random.nextInt(0, numeroElmi)));
            if(random.nextBoolean())
                armorSet.setGloves(armorPieceDAO.gloves.get(random.nextInt(0, min)));
            else
                armorSet.setGloves(armorPieceDAO.gloves.get(random.nextInt(0, numeroGuanti)));
            if(random.nextBoolean())
                armorSet.setChestplate(armorPieceDAO.chestplates.get(random.nextInt(0, min)));
            else
                armorSet.setChestplate(armorPieceDAO.chestplates.get(random.nextInt(0, numeroPetto)));
            if(random.nextBoolean())
                armorSet.setLeggings(armorPieceDAO.leggings.get(random.nextInt(0, min)));
            else
                armorSet.setLeggings(armorPieceDAO.leggings.get(random.nextInt(0, numeroGambe)));
            if(random.nextBoolean())
                armorSet.setCloack(armorPieceDAO.cloaks.get(random.nextInt(0, min)));
            else
                armorSet.setCloack(armorPieceDAO.cloaks.get(random.nextInt(0, numeroMantelli)));
            population.add(armorSet);
        }
        return population;
    }

    public double fitnessCalculator(ArmorSet armorSet, ArrayList<Integer> pesi) {
        ArrayList<Integer> statistiche = new ArrayList<>();
        statistiche.add(armorSet.getHelmet().getMobility() + armorSet.getGloves().getMobility() + armorSet.getChestplate().getMobility() + armorSet.getLeggings().getMobility() + armorSet.getCloack().getMobility());
        statistiche.add(armorSet.getHelmet().getResilience() + armorSet.getGloves().getResilience() + armorSet.getChestplate().getResilience() + armorSet.getLeggings().getResilience() + armorSet.getCloack().getResilience());
        statistiche.add(armorSet.getHelmet().getRecovery() + armorSet.getGloves().getRecovery() + armorSet.getChestplate().getRecovery() + armorSet.getLeggings().getRecovery() + armorSet.getCloack().getRecovery());
        statistiche.add(armorSet.getHelmet().getDiscipline() + armorSet.getGloves().getDiscipline() + armorSet.getChestplate().getDiscipline() + armorSet.getLeggings().getDiscipline() + armorSet.getCloack().getDiscipline());
        statistiche.add(armorSet.getHelmet().getIntellect() + armorSet.getGloves().getIntellect() + armorSet.getChestplate().getIntellect() + armorSet.getLeggings().getIntellect() + armorSet.getCloack().getIntellect());
        statistiche.add(armorSet.getHelmet().getStrength() + armorSet.getGloves().getStrength() + armorSet.getChestplate().getStrength() + armorSet.getLeggings().getStrength() + armorSet.getCloack().getStrength());

        double sommaPonderata = 0;
        int sommaPesi = 0;

        for (int i = 0; i < statistiche.size(); i++) {
            if (statistiche.get(i) > 100) {
                int valorePenalizzato = statistiche.get(i) - 100;
                statistiche.set(i, valorePenalizzato);
            }
            sommaPonderata += statistiche.get(i) * pesi.get(i);
            sommaPesi += pesi.get(i);
        }
        System.out.println(sommaPonderata / sommaPesi);
        return sommaPonderata / sommaPesi;
    }

    public ArrayList<ArmorSet> populationSelection(ArrayList<Integer> pesi, ArrayList<ArmorSet> popolazione) {
        ArrayList<ArmorSet> popolazioneValutata = new ArrayList<>();
        ArrayList<ArmorSetFitness> armorSetFitnesses = new ArrayList<>();
        for(int i=0; i<popolazione.size(); i++) {
            ArmorSetFitness temp = new ArmorSetFitness(popolazione.get(i), fitnessCalculator(popolazione.get(i), pesi));
            armorSetFitnesses.add(temp);
        }
        ArmorSetFitnessMergeSort asfms = new ArmorSetFitnessMergeSort();
        asfms.mergeSort(armorSetFitnesses, 0, armorSetFitnesses.size() - 1);
        int postiTorneo = (3 * popolazione.size()) / 4;
        for(int i=0; i<postiTorneo; i++) {
            popolazioneValutata.add(armorSetFitnesses.get(i).getArmorSet());
        }
        return popolazioneValutata;
    }

    public ArmorSet crossoverParents(ArmorSet primo, ArmorSet secondo) {
        Random random = new Random();
        ArmorSet figlio = new ArmorSet();
        if(random.nextBoolean())
            figlio.setHelmet(primo.getHelmet());
        else
            figlio.setHelmet(secondo.getHelmet());
        if(random.nextBoolean())
            figlio.setGloves(primo.getGloves());
        else
            figlio.setGloves(secondo.getGloves());
        if(random.nextBoolean())
            figlio.setChestplate(primo.getChestplate());
        else
            figlio.setChestplate(secondo.getChestplate());
        if(random.nextBoolean())
            figlio.setLeggings(primo.getLeggings());
        else
            figlio.setLeggings(secondo.getLeggings());
        if(random.nextBoolean())
            figlio.setCloack(primo.getCloack());
        else
            figlio.setCloack(secondo.getCloack());
        return figlio;
    }

    public ArmorSet mutationSon(ArmorSet figlio, int percentualeMutazione) {
        Random random = new Random();
        if(random.nextInt(0, 100) <= percentualeMutazione) {
            int pezzo = random.nextInt(0, 5);
            if(pezzo == 0) {
                figlio.setHelmet(armorPieceDAO.helmets.get(random.nextInt(0, min)));
            }
            if(pezzo == 1) {
                figlio.setHelmet(armorPieceDAO.gloves.get(random.nextInt(0, min)));
            }
            if(pezzo == 2) {
                figlio.setHelmet(armorPieceDAO.chestplates.get(random.nextInt(0, min)));
            }
            if(pezzo == 3) {
                figlio.setHelmet(armorPieceDAO.leggings.get(random.nextInt(0, min)));
            }
            if(pezzo == 4) {
                figlio.setHelmet(armorPieceDAO.cloaks.get(random.nextInt(0, min)));
            }
        }
        return figlio;
    }

    public ArrayList<ArmorSet> populationEvolution(int percentualeMutazione, String account, ArrayList<Integer>pesi) {
        ArrayList<ArmorSet> popolazione = populationInizializer(account);
        Random random = new Random();
        while(popolazione.size() > 10) {
            ArrayList<ArmorSet> popolazioneSelezionata = populationSelection(pesi, popolazione);
            ArrayList<ArmorSet> nuovaGenerazione = new ArrayList<>();
            while (nuovaGenerazione.size() < popolazioneSelezionata.size()) {
                ArmorSet genitore1 = popolazioneSelezionata.get(random.nextInt(0, popolazioneSelezionata.size()));
                ArmorSet genitore2 = popolazioneSelezionata.get(random.nextInt(0, popolazioneSelezionata.size()));
                ArmorSet figlio = crossoverParents(genitore1, genitore2);
                nuovaGenerazione.add(mutationSon(figlio, percentualeMutazione));
            }
            popolazione = nuovaGenerazione;
        }
        return popolazione;
    }
}