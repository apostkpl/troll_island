package com.rpg.characters;

import com.rpg.inventory.Weapon;

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
        Weapon weapon = this.getCurrentWeapon();
        String weaponName = this.getCurrentWeaponName();
        if (weaponName.toLowerCase().equals("sword") || weaponName.toLowerCase().equals("axe")) {
            return (int) Math.ceil(weapon.use() * this.getStrength());
        } else {return weapon.use();}
    }
}