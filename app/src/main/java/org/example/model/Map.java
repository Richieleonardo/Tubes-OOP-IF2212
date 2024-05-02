package org.example.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.example.model.zombies.Zombie;

public class Map {
    private int width;
    private int height;
    private String[][] map;
    private List<Zombie> zombies;
    Random random;

    /*
     * Constructor Map
     */

     public Map(){
        width = 8;
        height = 16;
        this.map = new String[width][height];
        this.zombies = new ArrayList<>();
     }

}
