package org.example.ArmorPickerAI;

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
}
