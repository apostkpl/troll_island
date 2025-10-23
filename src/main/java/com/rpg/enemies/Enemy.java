package com.rpg.enemies;

public abstract class Enemy {
    // Basic enemy info and stats
    protected String type; // Orc, Goblin, Troll, etc
    protected int MAX_HEALTH;
    protected int health;
    protected int damage; // How much damage does one attack of this enemy cause to the Player

    // Constructor for the abstract class
    public Enemy(String type, int MAX_HEALTH, int damage) {
        this.type = type;
        this.MAX_HEALTH = MAX_HEALTH;
        this.health = MAX_HEALTH; // Initialized with full health
        this.damage = damage;
    }

    // Some universal getter methods for the Enemy class
    public String getType() {
        return this.type;
    }
    public int getHealth() {
        return this.health;
    }
    public int getMaxHealth() {
        return this.MAX_HEALTH;
    }
    public int getDamage() {
        return this.damage;
    }

    // Check if an Enemy has died, to be called inside gameplay
    public boolean isAlive() {
        return this.health > 0;
    }
}