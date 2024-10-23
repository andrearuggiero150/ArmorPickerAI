package org.example.ArmorPickerAI;

import java.util.Objects;

public class ArmorSet {
    private ArmorPiece helmet;
    private ArmorPiece gloves;
    private ArmorPiece chestplate;
    private ArmorPiece leggings;
    private ArmorPiece cloack;

    public ArmorSet() {
    }

    public ArmorPiece getHelmet() {
        return helmet;
    }

    public void setHelmet(ArmorPiece helmet) {
        this.helmet = helmet;
    }

    public ArmorPiece getGloves() {
        return gloves;
    }

    public void setGloves(ArmorPiece gloves) {
        this.gloves = gloves;
    }

    public ArmorPiece getChestplate() {
        return chestplate;
    }

    public void setChestplate(ArmorPiece chestplate) {
        this.chestplate = chestplate;
    }

    public ArmorPiece getLeggings() {
        return leggings;
    }

    public void setLeggings(ArmorPiece leggings) {
        this.leggings = leggings;
    }

    public ArmorPiece getCloack() {
        return cloack;
    }

    public void setCloack(ArmorPiece cloack) {
        this.cloack = cloack;
    }

    @Override
    public String toString() {
        return "Helmet: " + helmet.toString() + "Gloves: " + gloves.toString() + "Chestplate: " + chestplate.toString() + "Leggings: " + leggings.toString() + "Cloack: " + cloack + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArmorSet armorSet)) return false;
        return Objects.equals(helmet, armorSet.helmet) && Objects.equals(gloves, armorSet.gloves) && Objects.equals(chestplate, armorSet.chestplate) && Objects.equals(leggings, armorSet.leggings) && Objects.equals(cloack, armorSet.cloack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(helmet, gloves, chestplate, leggings, cloack);
    }
}
