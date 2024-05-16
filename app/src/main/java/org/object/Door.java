package org.object;

import org.Entity.Entity;
import org.main.GamePanel;

import java.awt.*;

public class Door extends Entity {

    public Door(GamePanel gp){
        super(gp);
        name = "Door";
        down1 = setup("/objects/Door.png");

        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 24;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 48;
        solidArea.height = 12;

        collision = true;
    }
}
