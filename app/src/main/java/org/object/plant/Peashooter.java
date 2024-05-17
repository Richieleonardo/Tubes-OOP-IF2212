package org.object.plant;

import org.main.GamePanel;

public class Peashooter extends Plant {

    public Peashooter(GamePanel gp){
        super(gp, "Peashooter", 100, 100, 25, 4, -1, 10, false);

        //name = "Peashooter";
        down1 = setup("/plant/Peashooter.png");
        collision = true;
    }

}

