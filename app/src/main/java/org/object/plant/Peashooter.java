package org.object.plant;

import org.Entity.Entity;
import org.main.GamePanel;
import org.object.pellet.Pea;
import org.object.pellet.Squash_proj;

public class Peashooter extends Plant {

    public Peashooter(GamePanel gp){
        super(gp, "Peashooter", 100, 100, 25, 4, -1, 10, false);

        //name = "Peashooter";
        down1 = setup("/plant/Peashooter.png");
        collision = true;
        projectile = new Pea(gp);
    }

    @Override
    public Plant clone(){
        return new Peashooter(gp);
    }

    public void update(){
        System.out.println(name + "Health : " + Health);
        Shoot();

    }

}

