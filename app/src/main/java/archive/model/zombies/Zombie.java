package org.example.model.zombies;



public class Zombie {
    private final String name;
    private final int speed, health, attack_damage, attack_speed;
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

    /*
     * Getter Zombie, setter ga perlu karena seharusnya final
     */
    public String getName() {
        return name;
    }

    public int getSpeed(){
        return speed;
    }

    public int getHealth(){
        return health;
    }

    public int getAttack_Damage(){
        return attack_damage;
    }

    public boolean IsAquatic(){
        return is_aquatic;
    }

    /*
     * Untuk mengembalikan nama zombie
     */

     public String toString(){
        return name;
     }

}