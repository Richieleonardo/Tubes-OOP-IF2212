package org.object.zombie;

import org.main.GamePanel;

import java.util.Random;

public class BucketHeadZombie extends Zombie {
    public BucketHeadZombie(GamePanel gp) {
        super(gp, "Bucket Head Zombie", 300, 1, 100, 1);
        direction = "left";
        getImage();
    }
    public void getImage() {

        left1 = setup("/zombie/BucketHeadZombie.png");
        left2 = setup("/zombie/BucketHeadZombie.png");
        right1 = setup("/zombie/BucketHeadZombie.png");
        right2 = setup("/zombie/BucketHeadZombie.png");

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

