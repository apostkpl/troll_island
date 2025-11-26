package com.rpg.enemies;

import java.util.List;

public class EnemyData {
    // The json file's main key to be used by Gson
    private List<Enemy> enemies;

    // Getter method that helps us built the enemy class. Returns a list of all the enemies as objects
    public List<Enemy> getEnemies() {
        return this.enemies;
    }
}