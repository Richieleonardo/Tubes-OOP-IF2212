package org.object.pellet;

import org.Entity.Projectile;
import org.main.GamePanel;
import org.object.zombie.Zombie;

import java.awt.*;

public class Squash_proj extends Projectile{

    GamePanel gp;

    public Squash_proj(GamePanel gp){
        super(gp);
        this.gp = gp;

        name = "Squash_proj";
        down1 = setup("/plant/Squash.png");

        speed = 2;
        maxHealth = 24;
        Health = maxHealth;
        alive = false;
//        solidArea = new Rectangle();
//        solidArea.x = 9;
//        solidArea.y = 9;
//        solidArea.width = 27;
//        solidArea.height = 27;
//
//        solidAreaDefaultX = 9;
//        solidAreaDefaultY = 9;
//        collision = true;
    }
    @Override
    public void update(){
        //Check zombie collision
        int zombieIndex = gp.collisionChecker.checkEntity(this, gp.zombie);
        if(zombieIndex != 999){
            Zombie zombie = (Zombie) gp.zombie.get(zombieIndex);
            getUser().attackZombie(zombieIndex);
        }
        worldX += this.speed;

        Health--;
        if(Health <= 0){
            alive = false;
        }

    }
}
