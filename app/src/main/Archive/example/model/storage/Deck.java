package org.example.model.storage;

import org.example.model.plants.Plant;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Deck {
    private List<Plant> plants;
    private int size;

    /*
     * Constructor Deck
     */
    public Deck() {
        this.plants = new ArrayList<>();
        this.size = 10;
    }

    /*
     * Menambahkan plant ke dalam deck
     */
    public void addPlant(Plant plant) {
        this.plants.add(plant);
    }

    /*
     * Menghapus plant ke dalam deck
     */
    public void discard(int index, Inventory inventory) {
        inventory.returnPlant(this.plants.get(index));
        this.plants.remove(index);
    }

    /*
     * Mengeluarkan isi deck ke terminal
     */
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