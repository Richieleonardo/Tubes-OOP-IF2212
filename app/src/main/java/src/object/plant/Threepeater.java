package src.object.plant;

import src.Entity.Entity;
import src.main.GamePanel;

public class Threepeater extends Entity {

    public Threepeater(GamePanel gp){
        super(gp);

        name = "Threepeater";
        down1 = setup("/objects/Threepeater.png");
    }
}
