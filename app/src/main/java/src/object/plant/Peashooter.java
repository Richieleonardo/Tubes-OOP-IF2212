package src.object.plant;

import src.main.GamePanel;

public class Peashooter extends Plant {

    public Peashooter(GamePanel gp){
        super(gp, "Peashooter", 100, 100, 25, 4, -1, 10);

        //name = "Peashooter";
        down1 = setup("/plant/Peashooter.png");
        collision = true;
    }
}
