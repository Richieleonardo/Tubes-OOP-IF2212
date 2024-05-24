package org.object.plant;

import org.Entity.Entity;
import org.Entity.Projectile;
import org.main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Plant extends Entity {
    private int cost;
    private int health;
    private int attack_damage;
    private int attack_speed;
    private int range;
    private int cooldown;
    private boolean isAquatic;

    //CHECK COOLDOWN
    public boolean isCooldown;

    //Projectile
    public Projectile projectile;
    public boolean canAttack = true;
    public int attack_counter = 0;


    public Plant(GamePanel gp, String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown, boolean isAquatic) {
        super(gp);
        this.name = name;
        this.cost = cost;
        this.maxHealth = health;
        Health = maxHealth;
        this.attack_damage = attack_damage;
        this.attack_speed = attack_speed;
        if (range == -1) {
            this.range = 9 * 48;
        } else {
            this.range = range * 48;
        }
        this.cooldown = cooldown;
        this.isAquatic = isAquatic;
        this.isCooldown = false;

        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 48;
        solidArea.height = 48;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }


    //Clone plant object
    public abstract Plant clone();

    public String getName() {
        return this.name;
    }

    public int getCost() {
        return this.cost;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
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

    public boolean getIsAquatic() {
        return isAquatic;
    }

    public void setIsAquatic(boolean isAquatic) {
        this.isAquatic = isAquatic;
    }


    public boolean isCooldown() { return isCooldown; }
    public void setCooldown(boolean cooldown){
        isCooldown = cooldown;
    }

    public void Shoot() {
        //      PROJECTILE GENERATE ONLY WHEN THE OTHER IS NOT ALIVE
        if (canAttack) {
            for (Entity zombie : gp.zombie) {
                if (zombie != null) {
                    if (zombie.worldY == this.worldY) {
                        int distance = zombie.worldX - this.worldX;
                        if (distance <= getRange() && distance >= 0 ) {
                            if (projectile.alive == false) {
                                projectile.set(worldX, worldY, direction, true, this);

                                //ADD PROJECTILE TO LIST
                                gp.projectileList.add(projectile);
                            }
                        }
                    }
                }
            }
            canAttack = false;
        } else {
            attack_counter++; //HITUNG FRAME (60FRAME = 1 detik)
            if(attack_counter == 60*getAttack_Speed()){ //ATTACK setiap 3 detik
                canAttack = true;
                attack_counter = 0;
            }
        }
    }

    int coolcount = 0;
    public void update(){
//        System.out.println(name + "Health : " + Health);
//        System.out.println("Plant : " + worldX + ", " + worldY);

    }

    public void attackZombie(int i){
        if(i != 999){
            gp.zombie.get(i).Health -= attack_damage;

            if(gp.zombie.get(i).Health <= 0){
                gp.zombie.remove(i);
            }
        }
    }

    /*
    FOR COOLDOWN (I KNOW IT IS BAD..., BUT AT LEAST I TRY!)
     */

    public Runnable r = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(cooldown*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            setCooldown(false);
            coolcount = 0;
//            System.out.println("Cooldown status : " + isCooldown);
            }
    };



//    public Thread cool = new Thread(r);

    public String toString() {
        return this.name;
    }
}
