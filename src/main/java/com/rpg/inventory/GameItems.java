package com.rpg.inventory;

import java.util.HashMap;
import java.util.Map;

import com.rpg.enemies.Enemy;
import com.rpg.enemies.EnemyData;

public class GameItems {
    private static final Map<String, Weapon> WEAPON_DATA = new HashMap<>();
    private static final Map<String, Potion> POTION_DATA = new HashMap<>();
    private static final Map<String, Enemy> ENEMY_DATA = new HashMap<>();

    public static void initialize(ItemData itemData, EnemyData enemyData) {
        if (itemData == null) {
            System.err.println("Cannot initialize GameItems with null data!");
            return;
        }
        // HashMap of Weapons (key-value pairs of String - Weapon)
        for (Weapon weapon : itemData.getWeapons()) {
            WEAPON_DATA.put(weapon.getName().toLowerCase(), weapon);
        }
        // HashMap of Potions (key-value pairs of String - Potion)
        for (Potion potion : itemData.getPotions()) {
            POTION_DATA.put(potion.getName().toLowerCase(), potion);
        }
        // HashMap of Potions (key-value pairs of String - Enemy)
        for (Enemy enemy : enemyData.getEnemies()) {
            ENEMY_DATA.put(enemy.getType().toLowerCase(), enemy);
        }
        
        System.out.println("Game asset registry built successfully.");
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

    // Static method to retrieve an Enemy by name
    public static Enemy getEnemy(String type) {
        // Return the object from the static Map
        return ENEMY_DATA.get(type.toLowerCase());
    }
}