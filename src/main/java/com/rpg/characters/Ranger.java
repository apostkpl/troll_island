package com.rpg.characters;

public class Ranger extends Player {
    // Ranger specific stats
    private double dexterity; // Will increase the attack effectiveness for specific weapons (Bows for Ranger)

    // Warrior constructor
    public Ranger(String name) {
        super(name, 50, 100);
        // Standard Ranger initial dexterity (aka Bow bonus)
        this.dexterity = 1.5;
    }

    // Getter for dexterity (Ranger unique feature)
    public double getDexterity() {
        return this.dexterity;
    }

    // Increase dexterity (Ranger unique feature)
    public boolean increaseDexterity(double percentage) {
        if (percentage < 0) {
            throw new IllegalArgumentException("Can't increase dexterity using the given percentage.");
        }
        if (percentage == 0) {
            return false;
        }
        this.dexterity = this.getDexterity() + this.getDexterity() * percentage;
        return true;
    }

    @Override
    public int attack() {
        return (int) Math.ceil(10 * this.getDexterity()); // "10" to be replaced by a getDamage() method of class Weapon
    }
}