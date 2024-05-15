package src.object.plant;

import src.main.GamePanel;

public class Cabbagepult extends Plant {

    public Cabbagepult(GamePanel gp){
        super(gp, "Cabbagepult", 100, 300, 40, 3, -1, 5);

        //name = "Cabbagepult";
        down1 = setup("/plant/Cabbagepult.png");
        collision = true;
    }
}
