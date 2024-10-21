package org.example.ArmorPickerAI;

public class ArmorSetFitness {
    private ArmorSet armorSet;
    private double fitness;

    public ArmorSetFitness(ArmorSet armorSet, Double fitness) {
        this.armorSet = armorSet;
        this.fitness = fitness;
    }

    public ArmorSet getArmorSet() {
        return armorSet;
    }

    public void setArmorSet(ArmorSet armorSet) {
        this.armorSet = armorSet;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }
}
