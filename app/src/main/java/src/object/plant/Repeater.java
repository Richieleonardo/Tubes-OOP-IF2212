package src.object.plant;

import src.main.GamePanel;

public class Repeater extends Plant {

    public Repeater(GamePanel gp){
        super(gp, "Repeater", 200, 300, 40, 4, -1, 5);

        //name = "Repeater";
        down1 = setup("/plant/Repeater.png");
        collision = true;
    }
}
