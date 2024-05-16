package src.object.plant;

import src.main.GamePanel;

public class Sunflower extends Plant {

    public Sunflower(GamePanel gp) {
        super(gp, "Sunflower", 50, 100, 0, 0, 0, 10);

        //name = "Sunflower";
        down1 = setup("/plant/Squash.png");
        collision = true;
    }
}