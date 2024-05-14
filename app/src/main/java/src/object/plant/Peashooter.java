package src.object.plant;

import src.Entity.Entity;
import src.main.GamePanel;

public class Peashooter extends Entity {

    public Peashooter(GamePanel gp){
        super(gp);

        name = "Peashooter";
        down1 = setup("/plant/Peashooter.png");
        collision = true;
    }
}

