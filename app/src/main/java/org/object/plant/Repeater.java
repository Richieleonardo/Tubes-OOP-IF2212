package org.object.plant;

import org.main.GamePanel;
import org.object.pellet.Pea2;

public class Repeater extends Plant {

    public Repeater(GamePanel gp){
        super(gp, "Repeater", 200, 300, 40, 4, -1, 5, false);

        //name = "Repeater";
        down1 = setup("/plant/Repeater.png");
        collision = true;
        projectile = new Pea2(gp);
    }

    @Override
    public Plant clone(){
        return new Repeater(gp);
    }

    public void update(){
        System.out.println(name + "Health : " + Health);
        Shoot();

    }
}
