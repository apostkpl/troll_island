package com.rpg.inventory;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;

public class Inventory {
    public static final String JSON_PATH = "src/main/resources/inventory.json";

    public static ItemData loadItems() {
        Gson gson = new Gson();

        try(FileReader reader = new FileReader(JSON_PATH)) { // reader is inside the try block for efficiency,
                                                            // No need to close reader after work is done
            ItemData data = gson.fromJson(reader, ItemData.class);
            System.out.println("Item Data successfully loaded!");
            return data;
        } catch (IOException e) {
            System.err.println("ERROR: Could not load item data");
            e.printStackTrace();
            return null;
        }
    }
}