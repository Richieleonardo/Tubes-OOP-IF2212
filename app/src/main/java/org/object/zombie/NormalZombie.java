package org.object.zombie;

import org.main.GamePanel;

/*
maxHealth = 100
speed = 1
 */
public class NormalZombie extends Zombie {

    public NormalZombie(GamePanel gp) {
        super(gp, "NormalZombie", 125, 1, 100, 3);
        direction = "left";
        getImage();
    }

    public void getImage(){

        left1 = setup("/zombie/NormalZombie.png");
        left2 = setup("/zombie/NormalZombie.png");
        right1 = setup("/zombie/NormalZombie.png");
        right2 = setup("/zombie/NormalZombie.png");
    }

    public void setAction(){
//        tickCounter++;
//
//        if(tickCounter == 120){
//            Random random = new Random();
//            int i = random.nextInt(100) +1; //pick up a number from 1 to 100
//
//            if(i <= 25){
//                direction = "up";
//            }
//            if(i > 25 && i <= 50){
//                direction = "down";
//            }
//            if(i > 50 && i <= 75){
//                direction = "left";
//            }
//            if(i > 75 && i <= 100){
//                direction = "right";
//            }
//
//            tickCounter = 0;
//        }

//        direction = "left";
    }


}