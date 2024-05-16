package src.object.zombie;

import src.Entity.Entity;
import src.main.GamePanel;

public abstract class Zombie extends Entity {

    private int health;
    private int attack_damage;
    private int attack_speed;
    private boolean isAquatic = false;

    public Zombie(GamePanel gp, String name, int health, int speed, int attack_damage, int attack_speed) {
        super(gp);
        this.name = name;
        this.maxHealth = health;
        this.speed = speed;
        Health = maxHealth;
        this.attack_damage = attack_damage;
        this.attack_speed = attack_speed;
    }

    public String getName() {
        return this.name;
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

    public boolean getIsAquatic(){
        return isAquatic;
    }

    public void setIsAquatic(boolean isAquatic){
        this.isAquatic = isAquatic;
    }

    public void die() {
    }

    public String toString() {
        return this.name;
    }

    public void getImage(){}
    public void setAction(){}
}

