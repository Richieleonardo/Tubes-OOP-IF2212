package src.object.plant;

import src.main.GamePanel;

public class SnowPeashooter extends Plant {

    public SnowPeashooter(GamePanel gp){
        super(gp, "SnowPeashooter", 175, 100, 25, 4, -1, 10);

        //name = "SnowPeashooter";
        down1 = setup("/plant/SnowPeashooter.png");
        collision = true;
    }
}
