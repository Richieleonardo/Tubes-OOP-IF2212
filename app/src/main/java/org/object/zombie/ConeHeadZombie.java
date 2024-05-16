package org.object.zombie;

import org.main.GamePanel;

import java.util.Random;

public class ConeHeadZombie extends Zombie {
    public ConeHeadZombie(GamePanel gp) {
        super(gp, "Cone Head Zombie", 250, 5, 100, 1, false);
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

//        tickCounter++;
//
//        if(tickCounter == 120){
//            Random random = new Random();
//            int i = random.nextInt(100) +1; //pick up a number from 1 to 100
//
//            if(i <= 25){
//                direction = "left";
//                tickCounter = 0;
//            }
//            tickCounter = 0;        }
    }
}

