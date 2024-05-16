package org.object.zombie;

import org.main.GamePanel;

public class ScreenDoorZombie extends Zombie {
    public ScreenDoorZombie(GamePanel gp) {
        super(gp, "Screen Door Zombie", 325, 5, 100, 1, false);
        direction = "left";
        getImage();
    }
    public void getImage() {


        left1 = setup("/zombie/ScreenDoorZombie.png");
        left2 = setup("/zombie/ScreenDoorZombie.png");
        right1 = setup("/zombie/ScreenDoorZombie.png");
        right2 = setup("/zombie/ScreenDoorZombie.png");

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

