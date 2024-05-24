package org.object.zombie;

import org.Entity.Entity;
import org.main.GamePanel;

import java.util.Random;

public class DuckyTubeZombie extends Zombie{
    public DuckyTubeZombie(GamePanel gp) {
        super(gp, "Ducky Tube Zombie", 100, 4, 100, 1);
        description = "DuckyTubeZombie adalah zombie aquatic yang menggunakan atribut ducky tube.";
        entityDamage = getAttackDamage();
        direction = "left";
        setIsAquatic(true);
        getImage();
    }
    public void getImage() {
        //TODO
        left1 = setup("/zombie/DuckyTubeZombie.png");


    }
}

