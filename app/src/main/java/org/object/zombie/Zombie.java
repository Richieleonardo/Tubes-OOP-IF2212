package org.object.zombie;

import org.Entity.Entity;
import org.main.GamePanel;

public abstract class Zombie extends Entity {

    private int attack_damage;
    private int attack_speed;
    private boolean isAquatic = false;

    //Check if zombie can attack or not
    public boolean canAttack = true;
    public int attack_counter = 0;

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
            gp.plant[i].Health -= attack_damage;
            canAttack = false;
            if(gp.plant[i].Health <= 0){
                gp.plant[i] = null;
                canAttack = true;
            }
        }
    }

    public void update(){
        System.out.println("Zombie health : " + this.Health);
        System.out.println(this.speed);
        gp.collisionChecker.checkTile(this);
        collisionOn = false;
        //Implement collision with plant
        int Index = gp.collisionChecker.checkEntity(this, gp.plant);
        if(canAttack){
            attackPlant(Index);
        }
        else{
            attack_counter++;
            if(attack_counter == (60*attack_speed)){
                canAttack = true;
                attack_counter = 0;
            }
            updateSlow();
        }



        //if collisionOn = false player can move
        if(collisionOn == false) {
            switch (direction) {
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
            }
        }
    }

    public void getImage(){}
    public void setAction(){}
}

