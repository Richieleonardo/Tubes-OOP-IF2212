package org.object.zombie;

import org.main.GamePanel;

import java.util.Random;

public class YetiZombie extends Zombie {
    public YetiZombie(GamePanel gp) {
        super(gp, "Yeti Zombie", 400, 5, 200, 1, false);
        direction = "left";
        getImage();
    }
    public void getImage() {

        left1 = setup("/zombie/YetiZombie_Left.png");
        left2 = setup("/zombie/YetiZombie_Left.png");
        right1 = setup("/zombie/YetiZombie_Right.png");
        right2 = setup("/zombie/YetiZombie_Right.png");
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

