package src.object.plant;

import src.Entity.Entity;
import src.main.GamePanel;

public class Squash extends Entity {

    public Squash(GamePanel gp){
        super(gp);
        name = "Squash";

        down1 = setup("/plant/Squash.png");
    }
}
