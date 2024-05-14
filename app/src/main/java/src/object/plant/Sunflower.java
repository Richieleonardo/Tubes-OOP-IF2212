package src.object.plant;

import src.Entity.Entity;
import src.main.GamePanel;

public class Sunflower extends Entity {

    public Sunflower(GamePanel gp) {
        super(gp);

        name = "Sunflower";
        down1 = setup("/objects/Squash.png");
        collision = true;
    }
}
