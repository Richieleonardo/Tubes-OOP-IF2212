package org.object.pellet;

import org.Entity.Entity;
import org.main.GamePanel;

import java.awt.*;

public class Pea2 extends Entity {

    public Pea2(GamePanel gp){
        super(gp);

        name = "Pea2";
        down1 = setup("/objects/Pea2.png");

        solidArea = new Rectangle();
        solidArea.x = 9;
        solidArea.y = 9;
        solidArea.width = 27;
        solidArea.height = 27;

        solidAreaDefaultX = 9;
        solidAreaDefaultY = 9;
        collision = true;
    }
}
