package org.example.model;

import org.example.model.plants.Plant;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Deck {
    private List<Plant> plants;
    private int size;

    public Deck() {
        this.plants = new ArrayList<Plant>();
        this.size = 10;
    }

    public void addPlant(Plant plant) {
        this.plants.add(plant);
    }

    public void discard(int index, Inventory inventory) {
        inventory.returnPlant(this.plants.get(index));
        this.plants.remove(index);
    }

    public void print() {
        if (this.plants.isEmpty()) {
            System.out.println("Deck is empty.");
        } else {
            ListIterator<Plant> it = this.plants.listIterator();
            System.out.println("Deck:");
            while (it.hasNext()) {
                System.out.println(it.nextIndex() + ". " + it.next());
            }
        }
    }
}