package com.rpg.enemies;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;

public class EnemyLoader {
    public static final String JSON_PATH = "src/main/resources/enemies.json";

    public static EnemyData loadEnemies() {
        Gson gson = new Gson();

        try(FileReader reader = new FileReader(JSON_PATH)) { // reader is inside the try block for efficiency,
                                                            // No need to close reader after work is done
            EnemyData data = gson.fromJson(reader, EnemyData.class);
            System.out.println("\nEnemy Data successfully loaded!");
            return data;
        } catch (IOException e) {
            System.err.println("ERROR: Could not load enemy data");
            e.printStackTrace();
            return null;
        }
    }
}