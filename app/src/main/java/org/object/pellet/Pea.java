package org.object.pellet;

import org.Entity.Entity;
import org.main.GamePanel;

import java.awt.*;

public class Pea extends Entity {

    public Pea(GamePanel gp){
        super(gp);

        name = "Pea";
        down1 = setup("/objects/Pea.png");

        solidArea = new Rectangle();
        solidArea.x = 12;
        solidArea.y = 12;
        solidArea.width = 24;
        solidArea.height = 24;

        solidAreaDefaultX = 12;
        solidAreaDefaultY = 12;
        collision = true;
    }
}
