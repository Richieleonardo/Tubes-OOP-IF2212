package org.object.pellet;

import org.Entity.Entity;
import org.main.GamePanel;

public class Kernel_pellet extends Entity {


    public Kernel_pellet(GamePanel gp){
        super(gp);

        name = "Kernel_pellet";
        down1 = setup("/objects/Kernel_pellet.png");

    }

}
