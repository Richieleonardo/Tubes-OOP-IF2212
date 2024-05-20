package org.object.zombie;

import org.main.GamePanel;

import java.util.Random;

public class ConeHeadZombie extends Zombie {
    public ConeHeadZombie(GamePanel gp) {
        super(gp, "Cone Head Zombie", 250, 1, 100, 1);
        direction = "left";
        getImage();
}
    public void getImage() {

        left1 = setup("/zombie/ConeHeadZombie.png");
        left2 = setup("/zombie/ConeHeadZombie.png");
        right1 = setup("/zombie/ConeHeadZombie.png");
        right2 = setup("/zombie/ConeHeadZombie.png");
    }
    public void setAction(){

    }
}

