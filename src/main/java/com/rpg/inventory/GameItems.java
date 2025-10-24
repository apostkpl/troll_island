package com.rpg.inventory;

import java.util.HashMap;
import java.util.Map;

public class GameItems {
    private static Map<String, Weapon> WEAPON_DATA = new HashMap<>();
    private static Map<String, Potion> POTION_DATA = new HashMap<>();

    public static void initialize(ItemData data) {
        if (data == null) {
            System.err.println("Cannot initialize GameItems with null data!");
            return;
        }
        // HashMap of Weapons (key-value pairs of String - Weapon)
        for (Weapon weapon : data.getWeapons()) {
            WEAPON_DATA.put(weapon.getName().toLowerCase(), weapon);
        }
        // HashMap of Potions (key-value pairs of String Potion)
        for (Potion potion : data.getPotions()) {
            POTION_DATA.put(potion.getName().toLowerCase(), potion);
        }
        
        System.out.println("Item registry built successfully.");
    }
    
    // Static method to retrieve a Weapon by name
    public static Weapon getWeapon(String name) {
        // Return the object from the static Map
        return WEAPON_DATA.get(name.toLowerCase());
    }

    // Static method to retrieve a Potion by name
    public static Potion getPotion(String name) {
        // Return the object from the static Map
        return POTION_DATA.get(name.toLowerCase());
    }
}