package org.object.zombie;

import org.Entity.Entity;
import org.main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Zombie extends Entity {

    private int attack_damage;
    private int attack_speed;
    private boolean isAquatic = false;

    //COLLISION FOR TILE
    public boolean collisionTile = false;

    //Check if zombie can attack or not
    public boolean canAttack = true;
    public int attack_counter = 0;

    private boolean isSlowed = false;
    private int slowCounter = 0;
    private double originalSpeed;

    public Zombie(GamePanel gp, String name, int health, double speed, int attack_damage, int attack_speed) {
        super(gp);
        this.name = name;
        this.maxHealth = health;
        this.speed = speed;
        Health = maxHealth;
        this.attack_damage = attack_damage;
        this.attack_speed = attack_speed;
        solidArea = new Rectangle();
        solidArea.x = 9;
        solidArea.y = 0;
        solidArea.width = 9;
        solidArea.height = 40;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.Health;
    }

    public void setHealth(int health){
        this.Health = health;
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

    public void attackPlant(int i){
        if(i != 999 && canAttack){
            gp.plant.get(i).Health -= attack_damage;
            canAttack = false;
            if(gp.plant.get(i).Health <= 0){
                gp.plant.remove(i);
                canAttack = true;
            }
        }
    }

    static int frameCounter = 0;
    @Override
    public void update(){

//        System.out.println("Zombie health : " + this.Health);
        collisionOn = false;
        gp.collisionChecker.checkTile(this);

        //Implement collision with plant
        int Index = gp.collisionChecker.checkEntity(this, gp.plant);
        if(canAttack){
            attackPlant(Index);
        }
        else{
            attack_counter++;
            if(attack_counter > (60*attack_speed)){
                canAttack = true;
                attack_counter = 0;
            }
            updateSlow();
        }


        frameCounter++;
        if(collisionOn == false){
            if (frameCounter > 60) {
                worldX -= (int) (speed + 5.00);
                frameCounter = 0;
            }
        }

    }

    // Method to apply slow effect
    public void applySlow(int duration, int slowPercentage) {
        if (!isSlowed) {
            originalSpeed = this.speed;
            this.speed = this.speed * (100 - slowPercentage) / 100;
            isSlowed = true;
            slowCounter = duration;
        }
    }

    // Method to update the slow effect
    public void updateSlow() {
        if (isSlowed) {
            slowCounter--;
            if (slowCounter <= 0) {
                this.speed = originalSpeed;
                isSlowed = false;
            }
        }
    }

    public void getImage(){}
    public void setAction(){}
}

