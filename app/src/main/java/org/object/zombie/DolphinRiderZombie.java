package org.object.zombie;

import org.main.GamePanel;

import java.util.Random;

public class DolphinRiderZombie extends Zombie implements Jump {
    public DolphinRiderZombie(GamePanel gp) {
        super(gp, "Dolphin Rider Zombie", 175, 1, 100, 1);
        setIsAquatic(true);
        direction = "left";
        getImage();
    }
    public void getImage() {
        //TODO
        left1 = setup("/zombie/NormalZombie.png");


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
    public void jump(){
        this.worldX -=48;
    //    super.attackPlant();
    }
}

