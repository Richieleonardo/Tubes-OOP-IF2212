package src.object.plant;

import src.Entity.Entity;
import src.main.GamePanel;

public class Kernelpult extends Entity {

    public Kernelpult(GamePanel gp){
        super(gp);

        name = "Kernelpult";
        down1 = setup("/plant/Kernelpult.png");
        collision = true;
    }
}
