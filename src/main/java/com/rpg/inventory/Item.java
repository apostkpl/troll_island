package com.rpg.inventory;

public abstract class Item {
    // Properties that every item has in common and can be abstracted
    protected String name;
    protected String type;

    // Constructor for the abstract class
    public Item(String name, String type) {
        this.name = name;
        this.type = type;
    }

    // Getters for the abstract Item class
    public String getName() {
        return this.name;
    }
    public String getType() {
        return this.type;
    }

    // Will be overridden by the child classes. It will return the damage or healing value
    public abstract int use();
}