package org.object.zombie;

import org.Entity.Entity;
import org.main.GamePanel;
import org.object.plant.Cabbagepult;

import java.util.Random;

public class ConeHeadZombie extends Zombie{
    public ConeHeadZombie(GamePanel gp) {
        super(gp, "Cone Head Zombie", 250, 4, 100, 1);
        description = "ConeHeadZombie adalah zombie yang menggunakan atribut traffic cone di kepalanya.";
        entityDamage = getAttackDamage();
        direction = "left";
        getImage();
}
    public void getImage() {

        left1 = setup("/zombie/ConeHeadZombie.png");
        left2 = setup("/zombie/ConeHeadZombie.png");
        right1 = setup("/zombie/ConeHeadZombie.png");
        right2 = setup("/zombie/ConeHeadZombie.png");
    }
}

