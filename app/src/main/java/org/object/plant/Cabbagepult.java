package org.object.plant;

import org.Entity.Entity;
import org.Entity.Projectile;
import org.main.GamePanel;
import org.object.pellet.Cabbage_pellet;

public class Cabbagepult extends Plant {



    public Cabbagepult(GamePanel gp){
        super(gp, "Cabbagepult", 100, 300, 40, 3, -1, 5, false);

        //name = "Cabbagepult";
        down1 = setup("/plant/Cabbagepult.png");
        collision = true;
        projectile = new Cabbage_pellet(gp);
    }

    public void update(){
        //PROJECTILE GENERATE ONLY WHEN THE OTHER IS NOT ALIVE
        if(projectile.alive == false){
            projectile.set(worldX, worldY, direction, true, this);

            //ADD PROJECTILE TO LIST
            gp.projectileList.add(projectile);
        }
    }
}
