package org.Entity;

import org.main.GamePanel;
import org.object.plant.Plant;
import org.object.zombie.Zombie;

public class Projectile extends Entity{

    Plant user;

    public Projectile(GamePanel gp){
        super(gp);
        direction = "left";

    }

    public void set(int worldX, int worldY, String direction, boolean alive, Plant user){
        this.worldX = worldX;
        this.worldY = worldY;
        this.direction = direction;
        this.alive = alive;
        this.user = user;
        this.Health = this.maxHealth;
    }

    public Plant getUser(){
        return user;
    }

    public void update(){
        //Check zombie collision
        int zombieIndex = gp.collisionChecker.checkEntity(this, gp.zombie);
        if(zombieIndex != 999){
            user.attackZombie(zombieIndex);
            alive = false;
        }
        worldX += 2;

        Health--;
        if(Health <= 0 || worldX == 24*gp.getTileSize()){
            alive = false;
        }

    }
}

