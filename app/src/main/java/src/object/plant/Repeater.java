package src.object.plant;

import src.Entity.Entity;
import src.main.GamePanel;

public class Repeater extends Entity {

    public Repeater(GamePanel gp){
        super(gp);
        name = "Repeater";
        down1 = setup("/objects/Repeater.png");
        collision = true;
    }
}
