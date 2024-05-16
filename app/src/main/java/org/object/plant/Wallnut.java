package org.object.plant;

import org.main.GamePanel;

public class Wallnut extends Plant {

    public Wallnut(GamePanel gp){
        super(gp, "Wall nut", 50, 1000, 0, 0, 0, 20, false);

        //name = "Wallnut";
        down1 = setup("/plant/Wallnut.png");
        collision = true;
    }
}
