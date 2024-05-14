package src.object.pellet;

import src.Entity.Entity;
import src.main.GamePanel;

import java.awt.*;

public class SnowPea extends Entity {


    public SnowPea(GamePanel gp){
        super(gp);

        name = "SnowPea";
        down1 = setup("/objects/SnowPea.png");

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
