package src.object.plant;

import src.Entity.Entity;
import src.main.GamePanel;

public abstract class Plant extends Entity {
    private int cost;
    private int health;
    private int attack_damage;
    private int attack_speed;
    private int range;
    private int cooldown;
    private boolean isAquatic;

    public Plant(GamePanel gp, String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown, boolean isAquatic) {
        super(gp);
        this.name = name;
        this.cost = cost;
        this.maxHealth = health;
        Health = maxHealth;
        this.attack_damage = attack_damage;
        this.attack_speed = attack_speed;
        this.range = range;
        this.cooldown = cooldown;
        this.isAquatic = isAquatic;
    }

    public String getName() {
        return this.name;
    }

    public int getCost() {
        return this.cost;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getAttackDamage() {
        return this.attack_damage;
    }

    public int getAttack_Speed() {
        return this.attack_speed;
    }

    public int getRange() {
        return this.range;
    }

    public int getCooldown() {
        return this.cooldown;
    }

    public boolean getIsAquatic(){
        return isAquatic;
    }

    public void setIsAquatic(boolean isAquatic){
        this.isAquatic = isAquatic;
    }

    public void die() {
    }

    public void update(){
        System.out.println(name + "Health : " + Health);
    }

    public void contactZombie(int i){
        if(i != 999){
            Health -= 1;
        }
    }


    public String toString() {
        return this.name;
    }
}
