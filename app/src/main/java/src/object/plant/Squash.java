package src.object.plant;

import src.main.GamePanel;

public class Squash extends Plant {

    public Squash(GamePanel gp){
        super(gp, "Squash", 50, 100, 5000, 0, 1, 20, false);
        //name = "Squash";

        down1 = setup("/plant/Squash.png");
    }
}
