package com.rpg.characters;

import com.rpg.inventory.Weapon;

public class Ranger extends Player {
    // Ranger specific stats
    private double dexterity; // Will increase the attack effectiveness for specific weapons (Bows for Ranger)

    // Warrior constructor
    public Ranger(String name) {
        super(name, 50, 100, "short bow");
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
        Weapon weapon = this.getCurrentWeapon();
        String weaponName = this.getCurrentWeaponName();
        if (weaponName.toLowerCase().equals("bow")) {
            return (int) Math.ceil(weapon.use() * this.getDexterity());
        } else {return weapon.use();}
    }
}