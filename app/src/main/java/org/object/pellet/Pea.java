package org.object.pellet;

import org.Entity.Projectile;
import org.main.GamePanel;

import java.awt.*;

public class Pea extends Projectile {

    GamePanel gp;

    public Pea(GamePanel gp){
        super(gp);
        this.gp = gp;

        name = "Pea";
        down1 = setup("/objects/Pea.png");

        speed = 2;
        maxHealth = 99999;
        Health = maxHealth;
        alive = false;

//        solidArea = new Rectangle();
//        solidArea.x = 12;
//        solidArea.y = 12;
//        solidArea.width = 24;
//        solidArea.height = 24;
//
//        solidAreaDefaultX = 12;
//        solidAreaDefaultY = 12;
//        collision = true;
    }
}
