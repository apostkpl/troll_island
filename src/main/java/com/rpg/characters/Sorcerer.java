package com.rpg.characters;

public class Sorcerer extends Player {
    // Sorcerer specific stats
    private double charisma; // To be used for spell damage

    // Sorcerer constructor
    public Sorcerer(String name) {
        super(name, 50, 100, "short sword");
        // Standard Sorcerer initial charisma
        this.charisma = 1.5;
    }

    // Getter for charisma (Sorcerer unique feature)
    public double getCharisma() {
        return this.charisma;
    }

    // Increase charisma (Sorcerer unique feature)
    public boolean increaseCharisma(double percentage) {
        if (percentage < 0) {
            throw new IllegalArgumentException("Can't increase charisma using the given percentage.");
        }
        if (percentage == 0) {
            return false;
        }
        this.charisma = this.getCharisma() + this.getCharisma() * percentage;
        return true;
    }

    @Override
    public int attack() {
        return 10; // "10" to be replaced by a getDamage() method of class Weapon
                   // No weapon bonus for sorcerer, because they have spells
    }
}