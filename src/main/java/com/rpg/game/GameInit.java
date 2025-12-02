package com.rpg.game;

import java.util.Scanner;
import com.rpg.enemies.EnemyData;
import com.rpg.enemies.EnemyLoader;
import com.rpg.inventory.ItemData;
import com.rpg.inventory.GameItems;
import com.rpg.inventory.Inventory;
import com.rpg.characters.Player;
import com.rpg.characters.Warrior;
import com.rpg.characters.Ranger;
import com.rpg.characters.Sorcerer;

public class GameInit {

    public static Player initializeGame() {
        System.out.println("--- Game Initialization Started ---");
        
        // Load Items (Weapons and Potions) and Enemies
        ItemData itemData = Inventory.loadItems(); 
        EnemyData enemyData = EnemyLoader.loadEnemies();
        
        // Populate the static registries
        GameItems.initialize(itemData, enemyData);
        
        System.out.println("--- Game Initialization Complete! ---");
        // Immediatly create new player after data initialization
        // This may be changed in case we add save states later
        return createStartingPlayer();
    }
    
    // Create a new player
    private static Player createStartingPlayer() {
        String playerName = "";
        String playerClass = "";
        Player newPlayer = null;
        
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\n--- Create a New Character below: ---\n");

            // Get the player's Name from the user
            while (playerName.trim().isEmpty()) {
                System.out.print("Enter your character's name: ");
                playerName = scanner.nextLine().trim();

                // Reject empty names
                if (playerName.trim().isEmpty()) {
                    System.out.println("\nPlayer Name can't be empty. Please provide a valid name.");
                }
            }

            // Get the player's Class from the user
            while (newPlayer == null) {
                System.out.println("\nSelect your class:");
                System.out.println("[W]arrior (Uses strength to defeat opponents).");
                System.out.println("[R]anger (Is a master of Bows and Arrows. Utilises dexterity).");
                System.out.println("[S]orcerer (Has the ability to cast Magic).");
                System.out.println("Type your choice below (W / R / S):\n>>>");

                playerClass = scanner.nextLine().toUpperCase().trim();

                switch (playerClass) {
                    case "W":
                        newPlayer = new Warrior(playerName);
                        System.out.printf("\nNew Character created successfully. Class: %s, Name: %s\n",
                            playerName, playerClass
                        );
                        break;
                    case "R":
                        newPlayer = new Ranger(playerName);
                        System.out.printf("\nNew Character created successfully. Class: %s, Name: %s\n",
                            playerName, playerClass
                        );
                        break;
                    case "S":
                        newPlayer = new Sorcerer(playerName);
                        System.out.printf("\nNew Character created successfully. Class: %s, Name: %s\n",
                            playerName, playerClass
                        );
                        break;
                    default:
                        System.out.println("Invalid selection. Please make a valid choice between W, R, or S.\n");
                }
            }
        }
        return newPlayer;
    }
}