package org.object.zombie;

import org.Entity.Entity;
import org.main.GamePanel;

import java.util.Random;

public class FootballZombie extends Zombie {
    public FootballZombie(GamePanel gp) {
        super(gp, "Football Zombie", 275, 5, 125, 1);
        description = "FootballZombie adalah zombie yang menggunakan atribut pemain football.";
        entityDamage = getAttackDamage();
        direction = "left";
        getImage();
    }
    public void getImage() {


        left1 = setup("/zombie/FootballZombie.png");
        left2 = setup("/zombie/FootballZombie.png");
        right1 = setup("/zombie/FootballZombie.png");
        right2 = setup("/zombie/FootballZombie.png");

    }
}

