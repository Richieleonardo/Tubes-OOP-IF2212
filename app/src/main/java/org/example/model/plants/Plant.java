package org.example.model.plants;

public class Plant {
    private final String name;
    private final int cost, health, attack_damage, attack_speed, range, cooldown;

    public Plant(String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown) {
        this.name = name;
        this.cost = cost;
        this.health = health;
        this.attack_damage = attack_damage;
        this.attack_speed = attack_speed;
        this.range = range;
        this.cooldown = cooldown;
    }

    /*
     * 
     */
    // public String toString() {
    //     return this.name;
    // }

    /*
     * Getter setter untuk Plant
     */
    public String getName(){
        return name;
    }

    public int getCost(){
        return cost;
    }

    public int getHealth(){
        return health;
    }

    public int getAttackDamage(){
        return attack_damage;
    }

    public int getAttack_Speed(){
        return attack_speed;
    }

    public int getRange(){
        return range;
    }

    public int getCooldown(){
        return cooldown;
    }

    /*
     * Method yang dimiliki plant
     */
    public void die(){

    }

    @Override
    public String toString(){
        return name;
    }
}