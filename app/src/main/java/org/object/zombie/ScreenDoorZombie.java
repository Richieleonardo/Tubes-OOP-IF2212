package org.object.zombie;

import org.Entity.Entity;
import org.main.GamePanel;

public class ScreenDoorZombie extends Zombie {
    public ScreenDoorZombie(GamePanel gp) {
        super(gp, "Screen Door Zombie", 325, 1, 100, 1);
        direction = "left";
        getImage();
        description = "ScreenDoorZombie adalah zombie yang menggunakan atribut screen door sebagai perisai.";
        plantDamage = getAttackDamage();
    }
    public void getImage() {


        left1 = setup("/zombie/ScreenDoorZombie.png");
        left2 = setup("/zombie/ScreenDoorZombie.png");
        right1 = setup("/zombie/ScreenDoorZombie.png");
        right2 = setup("/zombie/ScreenDoorZombie.png");

    }
    public void setAction(){

    }
}

