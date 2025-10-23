package com.rpg.inventory;

import java.util.List;

public class ItemData {
    // The json file's two main keys to be used by Gson
    private List<Weapon> weapons;
    private List<Potion> potions;

    // This class only needs two getter methods, which will be accessed in Inventory.java
    public List<Weapon> getWeapons() {
        return this.weapons;
    }
    public List<Potion> getPotions() {
        return this.potions;
    }
}