package org.example.model;

import org.example.model.card.Plant;
import org.example.util.CSVReader;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Inventory {
    private List<Plant> plants;
    private static final String PLANT_CSV_FILE_PATH = "../plants.csv";

    public Inventory() {
        try {
            this.loadPlants();
        } catch (Exception e) {
            System.out.println("Failed to load plants: " + e);
        }
    }

    public void loadPlants() throws IOException, URISyntaxException {
        File plantsCSVFile = new File(getClass().getResource(PLANT_CSV_FILE_PATH).toURI());
        CSVReader plantReader = new CSVReader(plantsCSVFile, ",");
        plantReader.setSkipHeader(true);

        List<String[]> plantRows = plantReader.read();

        this.plants = new ArrayList<Plant>();

        for (String[] row: plantRows) {
            this.plants.add(new Plant(row[1],
                    Integer.parseInt(row[2]),
                    Integer.parseInt(row[3]),
                    Integer.parseInt(row[4]),
                    Integer.parseInt(row[5]),
                    Integer.parseInt(row[6]),
                    Integer.parseInt(row[7])));
        }
    }

    public void returnPlant(Plant plant) {
        this.plants.add(plant);
    }

    public void pick(int index, Deck deck) {
        deck.addPlant(this.plants.get(index));
        this.plants.remove(index);
    }

    public void print() {
        if (this.plants.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            ListIterator<Plant> it = this.plants.listIterator();
            System.out.println("Inventory:");
            while (it.hasNext()) {
                System.out.println(it.nextIndex() + ". " + it.next());
            }
        }
    }
}