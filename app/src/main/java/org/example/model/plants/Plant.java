package org.example.model.plants;

public class Plant {
    private String name;
    private int cost, health, attack_damage, attack_speed, range, cooldown;

    public Plant(String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown) {
        this.name = name;
        this.cost = cost;
        this.health = health;
        this.attack_damage = attack_damage;
        this.attack_speed = attack_speed;
        this.range = range;
        this.cooldown = cooldown;
    }

    public String toString() {
        return this.name;
    }
}