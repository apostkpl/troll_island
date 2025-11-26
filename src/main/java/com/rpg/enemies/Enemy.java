package com.rpg.enemies;

public abstract class Enemy {
    // Basic enemy info and stats
    protected String name; // Orc, Goblin, Troll, etc
    protected int maxHealth;
    protected int health;
    protected int damage; // How much damage does one attack of this enemy cause to the Player
    protected int goldDrop;

    // Constructor for the abstract class
    public Enemy(String name, int maxHealth, int damage, int goldDrop) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth; // Initialized with full health
        this.damage = damage;
        this.goldDrop = goldDrop;
    }

    // Some universal getter methods for the Enemy class
    public String getType() {
        return this.name;
    }
    public int getHealth() {
        return this.health;
    }
    public int getMaxHealth() {
        return this.maxHealth;
    }
    public int getDamage() {
        return this.damage;
    }
    public int getGoldDrop() {
        return this.goldDrop;
    }

    // Check if an Enemy has died, to be called inside gameplay
    public boolean isAlive() {
        return this.health > 0;
    }

    // Inside com.rpg.enemies.Enemy
    public void takeDamage(int damage) {
        if (damage < 0) {return;};
        this.health -= damage;

        // Make sure health never gets negative when taking damage
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public int attack() {
        return this.getDamage();
    }
}