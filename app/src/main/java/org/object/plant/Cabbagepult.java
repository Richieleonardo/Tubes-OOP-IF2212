package org.object.plant;

import org.Entity.Entity;
import org.Entity.Projectile;
import org.main.GamePanel;
import org.object.pellet.Cabbage_pellet;
import org.object.zombie.Zombie;

public class Cabbagepult extends Plant {


    public Cabbagepult(GamePanel gp){
        super(gp, "Cabbagepult", 100, 300, 40, 1, -1, 5, false);

        //name = "Cabbagepult";
        down1 = setup("/plant/Cabbagepult.png");
        collision = true;
        projectile = new Cabbage_pellet(gp);
    }

    @Override
    public Plant clone(){
        return new Cabbagepult(gp);
    }

    public void update(){
//        System.out.println(name + " Health: " + Health);
        Shoot();

    }
}
