package org.example.ArmorPickerAI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArmorPieceDAO {
    ArrayList<ArmorPiece> helmets;
    ArrayList<ArmorPiece> gloves;
    ArrayList<ArmorPiece> chestplates;
    ArrayList<ArmorPiece> leggings;
    ArrayList<ArmorPiece> cloaks;

    public ArmorPieceDAO() {
        helmets = new ArrayList<>();
        gloves = new ArrayList<>();
        chestplates = new ArrayList<>();
        leggings = new ArrayList<>();
        cloaks = new ArrayList<>();
    }

    public void loadArmorPiece(String txtName) {
        try {
            File file = new File(txtName);
            Scanner myReader = new Scanner(file);
            String data = myReader.nextLine();
            String[] spittedData = data.split("_");
            for (int i = 0; i < spittedData.length; i++) {
                String[] temp = spittedData[i].split("\\.");
                ArmorPiece armorPiece = new ArmorPiece(temp[0], temp[1], temp[2], Integer.parseInt(temp[3]), Integer.parseInt(temp[4]), Integer.parseInt(temp[5]), Integer.parseInt(temp[6]), Integer.parseInt(temp[7]), Integer.parseInt(temp[8]));
                armorPiece.setTot(armorPiece.getMobility()+ armorPiece.getResilience()+ armorPiece.getRecovery()+ armorPiece.getDiscipline()+ armorPiece.getIntellect()+ armorPiece.getStrength());
                if(armorPiece.getType().equals("helmet"))
                    helmets.add(armorPiece);
                else if(armorPiece.getType().equals("gloves"))
                    gloves.add(armorPiece);
                if(armorPiece.getType().equals("chestplate"))
                    chestplates.add(armorPiece);
                if(armorPiece.getType().equals("leggings"))
                    leggings.add(armorPiece);
                if(armorPiece.getType().equals("cloack"))
                    cloaks.add(armorPiece);
            }
            ArmorPieceMergeSort apms = new ArmorPieceMergeSort();
            apms.mergeSort(helmets, 0, helmets.size() - 1);
            apms.mergeSort(gloves, 0, gloves.size() - 1);
            apms.mergeSort(chestplates, 0, chestplates.size() - 1);
            apms.mergeSort(leggings, 0, leggings.size() - 1);
            apms.mergeSort(cloaks, 0, cloaks.size() - 1);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato");
        }
    }
}
