package org.object.zombie;

import org.main.GamePanel;

import java.util.Random;

public class DuckyTubeZombie extends Zombie {
    public DuckyTubeZombie(GamePanel gp) {
        super(gp, "Ducky Tube Zombie", 100, 5, 100, 1);
        direction = "left";
        setIsAquatic(true);
        getImage();
    }
    public void getImage() {

//        left1 = setup("/zombie/.png");


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
