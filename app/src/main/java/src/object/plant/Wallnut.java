package src.object.plant;

import src.Entity.Entity;
import src.main.GamePanel;

public class Wallnut extends Entity {

    public Wallnut(GamePanel gp){
        super(gp);

        name = "Wallnut";
        down1 = setup("/objects/Wallnut.png");
        collision = true;
    }
}
