package org.object.pellet;

import org.Entity.Projectile;
import org.main.GamePanel;

import java.awt.*;

public class SnowPea extends Projectile{

    GamePanel gp;

    public SnowPea(GamePanel gp){
        super(gp);
        this.gp = gp;

        name = "SnowPea";
        down1 = setup("/objects/SnowPea.png");

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
