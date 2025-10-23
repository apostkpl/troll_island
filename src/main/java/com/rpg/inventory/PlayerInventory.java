package com.rpg.inventory;

import java.util.Map;
import java.util.HashMap;

public class PlayerInventory {
    private Map<String, Item> items;
    private int MAX_SIZE;

    // PlayerInventory Constructor
    public PlayerInventory(int MAX_SIZE) {
        this.items = new HashMap<>();
        this.MAX_SIZE = MAX_SIZE;
    }

    // Add an item to the inventory
    public boolean addItem(Item item) {
        if (items.size() == this.MAX_SIZE) {
            System.out.printf("\nYour inventory is already full. Please drop an item if you want to acquire %s\n", item.getName());
            return false;
        }
        items.put(item.getName().toLowerCase(), item);
        System.out.printf("\n%s added to inventory.", item.getName());
        return true;
    }

    // Drop items from inventory
    public boolean removeItem(String itemName) {
        Item removedItem = items.remove(itemName.toLowerCase());

        if (removedItem != null) {
            System.out.printf("\nDropped item: %s\n", itemName);
            return true;
        }

        System.out.printf("\nERROR: Item [%s] not in inventory.\n", itemName);
        return false;
    }

    // Check if a player has a specific item to their inventory
    public boolean hasItem(String itemName) {
        return items.containsKey(itemName.toLowerCase());
    }

    // Item Getter method
    public Item getItem(String itemName) {
        return items.get(itemName.toLowerCase());
    }
}