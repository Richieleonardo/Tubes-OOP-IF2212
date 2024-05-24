package org.object.zombie;

import org.Entity.Entity;
import org.main.GamePanel;

import java.util.Random;

public class DolphinRiderZombie extends Zombie implements Jump{
    public DolphinRiderZombie(GamePanel gp) {
        super(gp, "Dolphin Rider Zombie", 175, 1, 100, 1);
        description = "DolphinRiderZombie adalah zombie aquatic yang dapat melompati Plant sebanyak 1 kali.";
        entityDamage = getAttackDamage();
        setIsAquatic(true);
        direction = "left";
        getImage();
    }
    public void getImage() {
        //TODO
        left1 = setup("/zombie/DolphinRiderZombie.png");


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

