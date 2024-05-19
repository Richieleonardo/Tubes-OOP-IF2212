package org.object.plant;

import org.Entity.Entity;
import org.main.GamePanel;
import org.object.pellet.Squash_proj;

public class Squash extends Plant {

    public Squash(GamePanel gp){
        super(gp, "Squash", 50, 100, 5000, 0, 1, 20, false);
        //name = "Squash";

        down1 = setup("/plant/Squash.png");
        collision = true;
        projectile = new Squash_proj(gp);

    }

    @Override
    public Plant clone(){
        return new Squash(gp);
    }

    public void update(){
        System.out.println(name + "Health : " + Health);
        Shoot();
        int zombieIndex = gp.collisionChecker.checkEntity(this, gp.zombie);
        if(zombieIndex != 999){
            attackZombie(zombieIndex);
            alive = false;
            worldX += 48;
        }
    }


}
