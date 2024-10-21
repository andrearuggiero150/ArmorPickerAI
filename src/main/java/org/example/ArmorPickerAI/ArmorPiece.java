package org.example.ArmorPickerAI;

public class ArmorPiece {
    private String name;
    private String type;
    private String rarity;
    private int mobility;
    private int resilience;
    private int recovery;
    private int discipline;
    private int intellect;
    private int strength;
    private int tot;

    public ArmorPiece() {
    }

    public ArmorPiece(String name, String type, String rarity, int mobility, int resilience, int recovery, int discipline, int intellect, int strength) {
        this.name = name;
        this.type = type;
        this.rarity = rarity;
        this.mobility = mobility;
        this.resilience = resilience;
        this.recovery = recovery;
        this.discipline = discipline;
        this.intellect = intellect;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public int getMobility() {
        return mobility;
    }

    public void setMobility(int mobility) {
        this.mobility = mobility;
    }

    public int getResilience() {
        return resilience;
    }

    public void setResilience(int resilience) {
        this.resilience = resilience;
    }

    public int getRecovery() {
        return recovery;
    }

    public void setRecovery(int recovery) {
        this.recovery = recovery;
    }

    public int getDiscipline() {
        return discipline;
    }

    public void setDiscipline(int discipline) {
        this.discipline = discipline;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getTot() {
        return tot;
    }

    public void setTot(int tot) {
        this.tot = tot;
    }

    @Override
    public String toString() {
        return name + ", " + type + ", " + rarity + ", " + mobility + ", " + resilience + ", " + recovery + ", " + discipline + ", " + intellect + ", " + strength + "\n";
    }
}
