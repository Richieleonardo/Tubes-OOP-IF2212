package org.object.plant;

import org.main.GamePanel;

public class Kernelpult extends Plant {

    public Kernelpult(GamePanel gp){
        super(gp, "Kernelpult", 100, 300, 30, 3, -1, 5, false);

        //name = "Kernelpult";
        down1 = setup("/plant/Kernelpult.png");
        collision = true;
    }
}
