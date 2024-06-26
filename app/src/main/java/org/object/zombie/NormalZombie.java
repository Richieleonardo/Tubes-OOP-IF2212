package org.object.zombie;

import org.Entity.Entity;
import org.main.GamePanel;

import java.awt.*;

/*
maxHealth = 100
speed = 1
 */
public class NormalZombie extends Zombie {

    public NormalZombie(GamePanel gp) {
        super(gp, "NormalZombie", 125, 4, 100, 3);
        description = "NormalZombie adalah zombie yang tidak memiliki atribut.";
        entityDamage = getAttackDamage();
        direction = "left";
        getImage();
//        solidArea.width = 45;
//        solidArea = new Rectangle(9,0,48, 45);
    }

    public void getImage(){

        left1 = setup("/zombie/NormalZombie.png");
        left2 = setup("/zombie/NormalZombie.png");
        right1 = setup("/zombie/NormalZombie.png");
        right2 = setup("/zombie/NormalZombie.png");
    }
}
