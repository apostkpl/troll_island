package com.rpg.characters;

import com.rpg.inventory.GameItems;
//import com.rpg.inventory.Inventory;
// Import necessary packages for the inventory
import com.rpg.inventory.PlayerInventory;
//import com.rpg.inventory.Weapon;
//import com.rpg.inventory.Potion;


public abstract class Player {
    // Basic character info and stats
    protected String name;
    protected int health;
    protected final int MAX_HEALTH;
    protected int gold;
    // The players inventory and current weapon
    protected PlayerInventory inventory;
    protected static int MAX_SIZE_INV = 10;
    protected String currentWeaponName;
    
    // Generic constructor for the abstract class
    // Extra class-unique features will be added using the class-specific constructors
    public Player(String name, int MAX_HEALTH, int gold, String currentWeaponName) {
        this.name = name;
        this.MAX_HEALTH = MAX_HEALTH;
        this.health = MAX_HEALTH; // New players will always get the maximum amount of health when created
        this.gold = gold;
        this.currentWeaponName = currentWeaponName;
        this.inventory = new PlayerInventory(MAX_SIZE_INV);
        inventory.addItem(GameItems.getWeapon((currentWeaponName)));
    }

    // Attack method. To be implemented by each class
    public abstract int attack();


    // Universal Getters
    public String getName() {
        return this.name;
    }
    public int getHealth() {
        return this.health;
    }
    public int getMaxHealth() {
        return this.MAX_HEALTH;
    }
    public int getGold() {
        return this.gold;
    }

    // Check if the player is alive. Will be useful during gameplay
    public boolean isAlive() {
        return this.getHealth() > 0;
    }

    // Universal adjustment of basic stats
    public boolean heal(int amount) {
        // Check if healing amount is a positive integer
        if (amount <= 0) {
            throw new IllegalArgumentException("Healing amount must be a positive integer.");
        }
        this.health = Math.min(this.MAX_HEALTH, this.getHealth() + amount);
        return true;
    }

    public boolean acquireGold(int amount) {
        // Check if the amount of gold is indeed positive
        if (amount <= 0) {
            throw new IllegalArgumentException("Can't acquire negative amount of gold.");
        }

        this.gold += amount;
        return true;
    }

    public boolean payGold(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Can't pay a negative amount of gold.");
        }

        if (amount > this.getGold()) {
            System.out.println("\nYou don't have enough gold for this purchase.");
            System.out.printf("\nYour current gold amount: %d, Item cost: %d\n", this.getGold(), amount);
            return false;
        }

        this.gold -= amount;
        return true;
    }

        public void takeDamage(int damage) {
        int damageTaken = Math.max(0, this.getHealth() - damage);
        this.health -= damageTaken;

        // Make sure health never gets negative when taking damage
        if (this.health < 0) {
            this.health = 0;
        }
    }
}