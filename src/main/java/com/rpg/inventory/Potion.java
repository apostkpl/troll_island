package com.rpg.inventory;

public class Potion extends Item {
    // Potion specific properties
    private int healthPoints;

    // Potion Constructor
    public Potion (String name, String type, int healthPoints) {
        super(name, type);
        this.healthPoints = healthPoints;
    }

    // Getter method for damage
    public int getHealthPoints() {
        return this.healthPoints;
    }

    @Override
    public int use() {
        System.out.printf("\nUsed %s, %dhp of health was added.\n", this.getName(), this.getHealthPoints());
        return this.getHealthPoints();
    }
}