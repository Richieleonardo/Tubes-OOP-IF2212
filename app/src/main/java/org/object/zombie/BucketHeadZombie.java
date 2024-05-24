package org.object.zombie;

import org.Entity.Entity;
import org.main.GamePanel;

import java.util.Random;

public class BucketHeadZombie extends Zombie{
    public BucketHeadZombie(GamePanel gp) {
        super(gp, "Bucket Head Zombie", 300, 1, 100, 1);
        description = "BucketHeadZombie adalah zombie yang menggunakan atribut ember di kepalanya.";
        entityDamage = getAttackDamage();
        direction = "left";
        getImage();
    }
    public void getImage() {

        left1 = setup("/zombie/BucketHeadZombie.png");
        left2 = setup("/zombie/BucketHeadZombie.png");
        right1 = setup("/zombie/BucketHeadZombie.png");
        right2 = setup("/zombie/BucketHeadZombie.png");

    }
}

