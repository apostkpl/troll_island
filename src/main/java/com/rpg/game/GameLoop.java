package com.rpg.game;

import com.rpg.characters.Player;
import java.util.Scanner;

public class GameLoop {
    private static final Scanner scanner = new Scanner(System.in);
    private Player user;

    public GameLoop(Player user) {
        this.user = user;
    }

    public void start() {
        System.out.printf("\nWelcome %s, the adventure is about to start...\n");
        while (user.isAlive()) {
            displayStatusBar();
            //promptUser();
        }
        System.out.println("\n--- GAME OVER ---\n");
    }

    private void displayStatusBar() {
        System.out.printf("\n[Player: %s] ||||| Status: [ HP: %d/%d || Gold: %d || Weapon: %s]",
            user.getName(), user.getHealth(), user.getMaxHealth(), user.getGold(), user.getCurrentWeaponName()
        );
    }

    public void promptUser() {
    String input;
    boolean validInput = false;

    // Loop until we get valid input
    while (!validInput) {
        System.out.println("What would you like to do? (A: Attack, I: Open Inventory, R: Run, Q: Quit)\n>>> ");
        input = scanner.nextLine().toUpperCase().trim();

        // Check user input
        switch (input) {
            case "Q":
                user.takeDamage(user.getHealth()); // Exit loop
                validInput = true;
                break;
            case "I":
                System.out.println("\nUser inventory:\n");
                // Implement Display Inventory
                validInput = true;
                break;
            case "R":
                // Implement Run logic
                validInput = true;
                break;
            case "A":
                // Implement Attack logic
                validInput = true;
                break;
            default:
                System.out.println("Input not recognized. Please try again.");
                // validInput stays false, Loop runs once more
        }
    }
}
}