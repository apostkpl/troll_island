package com.rpg.inventory;

public class Weapon extends Item {
    // Weapon specific properties
    private int damage;

    // Weapon Constructor
    public Weapon (String name, String type, int damage) {
        super(name, type);
        this.damage = damage;
    }

    // Getter method for damage
    public int getDamage() {
        return this.damage;
    }

    @Override
    public int use() {
        System.out.printf("\nUsed %s, %dhp damage was inflicted.\n", this.getName(), this.getDamage());
        return this.getDamage();
    }
}