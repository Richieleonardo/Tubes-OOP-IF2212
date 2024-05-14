package src.object.plant;

import src.Entity.Entity;
import src.main.GamePanel;

public class SnowPeashooter extends Entity {

    public SnowPeashooter(GamePanel gp){
        super(gp);

        name = "SnowPeashooter";
        down1 = setup("/plant/SnowPeashooter.png");
        collision = true;
    }
}
