package org.object.zombie;

import org.Entity.Entity;
import org.main.GamePanel;

import java.util.Random;

public class SnorkelZombie extends Zombie {
    public SnorkelZombie(GamePanel gp) {
        super(gp, "Snorkel Zombie", 100, 1, 100, 1);
        description = "SnorkelZombie adalah zombie aquatic dengan kemampuan menyelam.";
        entityDamage = getAttackDamage();
        direction = "left";
        getImage();
    }
    public void getImage() {
        //TODO
        left1 = setup("/zombie/NormalZombie.png");


    }
    public void setAction(){

    }
}

