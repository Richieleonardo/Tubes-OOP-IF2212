package org.object.plant;

import org.main.GamePanel;
import org.object.pellet.Pea2;

public class Threepeater extends Plant {

    public Threepeater(GamePanel gp){
        super(gp, "Threepeater", 325, 300, 60, 4, -1, 15, false);

        //name = "Threepeater";
        down1 = setup("/plant/Threepeater.png");
        projectile = new Pea2(gp);
    }

    public void update(){
        System.out.println(name + "Health : " + Health);
        Shoot();

    }
}
