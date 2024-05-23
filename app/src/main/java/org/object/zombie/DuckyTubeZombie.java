package org.object.zombie;

import org.Entity.Entity;
import org.main.GamePanel;

import java.util.Random;

public class DuckyTubeZombie extends Zombie{
    public DuckyTubeZombie(GamePanel gp) {
        super(gp, "Ducky Tube Zombie", 100, 1, 100, 1);
        description = "DuckyTubeZombie adalah zombie aquatic yang menggunakan atribut ducky tube.";
        entityDamage = getAttackDamage();
        direction = "left";
        setIsAquatic(true);
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
}

