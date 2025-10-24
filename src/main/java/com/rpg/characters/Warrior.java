package com.rpg.characters;

public class Warrior extends Player {
    // Warrior specific stats
    private double strength; // Will increase the attack effectiveness for specific weapons

    // Warrior constructor
    public Warrior(String name) {
        super(name, 50, 100, "short sword");
        // Standard Warrior initial strengh
        this.strength = 1.5;
    }

    // Getter for strength (Warrior unique feature)
    public double getStrength() {
        return this.strength;
    }

    // Increase strength (Warrior unique feature)
    public boolean increaseStrength(double percentage) {
        if (percentage < 0) {
            throw new IllegalArgumentException("Can't increase strength using the given percentage.");
        }
        if (percentage == 0) {
            return false;
        }
        this.strength = this.getStrength() + this.getStrength() * percentage;
        return true;
    }

    @Override
    public int attack() {
        return (int) Math.ceil(10 * this.getStrength()); // "10" to be replaced by a getDamage() method of class Weapon
    }
}