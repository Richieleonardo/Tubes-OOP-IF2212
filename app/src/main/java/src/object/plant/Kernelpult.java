package src.object.plant;

import src.main.GamePanel;

public class Kernelpult extends Plant {

    public Kernelpult(GamePanel gp){
        super(gp, "Kernelpult", 100, 300, 30, 3, -1, 5);

        //name = "Kernelpult";
        down1 = setup("/plant/Kernelpult.png");
        collision = true;
    }
}
