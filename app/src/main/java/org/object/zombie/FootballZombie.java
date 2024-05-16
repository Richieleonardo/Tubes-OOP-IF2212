package org.object.zombie;

import org.main.GamePanel;

import java.util.Random;

public class FootballZombie extends Zombie {
    public FootballZombie(GamePanel gp) {
        super(gp, "Football Zombie", 275, 5, 125, 1, false);
        direction = "left";
        getImage();
    }
    public void getImage() {

        up1 = setup("/zombie/FootballZombie.png");
        up2 = setup("/zombie/FootballZombie.png");
        down1 = setup("/zombie/FootballZombie.png");
        down2 = setup("/zombie/FootballZombie.png");
        left1 = setup("/zombie/FootballZombie.png");
        left2 = setup("/zombie/FootballZombie.png");
        right1 = setup("/zombie/FootballZombie.png");
        right2 = setup("/zombie/FootballZombie.png");

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

