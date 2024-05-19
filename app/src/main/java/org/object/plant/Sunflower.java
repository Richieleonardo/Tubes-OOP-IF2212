package org.object.plant;

import org.main.GamePanel;
import org.Entity.Player;

public class Sunflower extends Plant implements ProduceSun{

    int counter = 0;

    public Sunflower(GamePanel gp) {
        super(gp, "Sunflower", 50, 100, 0, 0, 0, 10, false);

        //name = "Sunflower";
        down1 = setup("/plant/Sunflower.png");
        collision = true;
    }

    @Override
    public Plant clone(){
        return new Sunflower(gp);
    }

    @Override
    public void produceSun() {
        Player.hasSun += 25;
    }

    @Override
    public void update() {
        System.out.println(name + "Health : " + Health);
        super.update();
        counter++;
        if(counter == 60 * 3){
            produceSun();
            counter = 0;
        }

    }
}
