package org.object.zombie;

import org.main.GamePanel;

import java.util.Random;

public class PoleVaultingZombie extends Zombie implements Jump{
    public PoleVaultingZombie(GamePanel gp) {
        super(gp, "Pole Vaulting Zombie", 175, 1, 100, 1);
        direction = "left";
        getImage();
    }
    public void getImage() {
        //TODO
        left1 = setup("/zombie/NormalZombie.png");
//        left2 = setup("/zombie/.png");
// belum ada png
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

