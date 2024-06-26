package org.object.pellet;

import org.Entity.Projectile;
import org.main.GamePanel;
import org.object.zombie.Zombie;

import java.awt.*;

public class SnowPea extends Projectile{

    GamePanel gp;

    public SnowPea(GamePanel gp){
        super(gp);
        this.gp = gp;

        name = "SnowPea";
        down1 = setup("/objects/SnowPea.png");

        speed = 2;
        maxHealth = 99999;
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
    public void slow(Zombie zombie){
        if (zombie != null) {
            zombie.applySlow(180, 50); // Slow for 3 seconds (180 frames), 50% slow
            this.alive = false; // Projectile disappears after hitting
        }
    }
    @Override
    public void update(){
        //Check zombie collision
        int zombieIndex = gp.collisionChecker.checkEntity(this, gp.zombie);
        if(zombieIndex != 999){
            Zombie zombie = (Zombie) gp.zombie.get(zombieIndex);
            getUser().attackZombie(zombieIndex);
            slow(zombie);
            alive = false;
        }
        worldX += this.speed;

        Health--;
        if(Health <= 0){
            alive = false;
        }

    }
}
