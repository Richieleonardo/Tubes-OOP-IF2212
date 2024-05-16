package org.object.plant;

import org.main.GamePanel;

public class Repeater extends Plant {

    public Repeater(GamePanel gp){
        super(gp, "Repeater", 200, 300, 40, 4, -1, 5, false);

        //name = "Repeater";
        down1 = setup("/plant/Repeater.png");
        collision = true;
    }
}
