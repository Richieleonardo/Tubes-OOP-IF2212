package src.object.plant;

import src.Entity.Entity;
import src.main.GamePanel;

public class Cabbagepult extends Entity {


    public Cabbagepult(GamePanel gp){
        super(gp);

        name = "Cabbagepult";
        down1 = setup("/objects/Cabbagepult.png");
        collision = true;
    }
}
