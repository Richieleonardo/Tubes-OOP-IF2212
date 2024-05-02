package org.example.model.zombies;

public class Zombie {
    private String name;
    private int speed, health, attack_damage, attack_speed;
    private boolean is_aquatic;

    /*
     * Constructor zombie
     */
    public Zombie(String name, int health, int attack_damage, int attack_speed, boolean is_aquatic) {
        this.name = name;
        this.speed = 5;
        this.health = health;
        this.attack_damage = attack_damage;
        this.attack_speed = attack_speed;
        this.is_aquatic = is_aquatic;
    }

    public String getName() {
        return this.name;
    }
}