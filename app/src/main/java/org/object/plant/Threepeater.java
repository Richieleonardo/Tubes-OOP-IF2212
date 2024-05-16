package org.object.plant;

import org.main.GamePanel;

public class Threepeater extends Plant {

    public Threepeater(GamePanel gp){
        super(gp, "Threepeater", 325, 300, 60, 4, -1, 15, false);

        //name = "Threepeater";
        down1 = setup("/plant/Threepeater.png");
    }
}
