package org.example.model;

import org.example.model.plants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Inventory {
    private List<Plant> plants;

    public Inventory() {
        this.plants = new ArrayList<Plant>();
        this.plants.add(new Sunflower());
        this.plants.add(new Peashooter());
        this.plants.add(new Wallnut());
        this.plants.add(new Squash());
        this.plants.add(new Snowpea());
        this.plants.add(new Lilypad());
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