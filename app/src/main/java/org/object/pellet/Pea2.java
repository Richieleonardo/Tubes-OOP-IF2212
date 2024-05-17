package org.object.pellet;

import org.Entity.Projectile;
import org.main.GamePanel;

import java.awt.*;

public class Pea2 extends Projectile{

    GamePanel gp;

    public Pea2(GamePanel gp){
        super(gp);
        this.gp = gp;

        name = "Pea2";
        down1 = setup("/objects/Pea2.png");

        speed = 2;
        maxHealth = 99999;
        Health = maxHealth;
        alive = false;
//        solidArea = new Rectangle();
//        solidArea.x = 9;
//        solidArea.y = 9;
//        solidArea.width = 27;
//        solidArea.height = 27;
//
//        solidAreaDefaultX = 9;
//        solidAreaDefaultY = 9;
//        collision = true;
    }
}
