package org.object.pellet;

import org.Entity.Projectile;
import org.main.GamePanel;

import java.awt.*;

public class Squash_proj extends Projectile{

    GamePanel gp;

    public Squash_proj(GamePanel gp){
        super(gp);
        this.gp = gp;

        name = "Squash_proj";
        down1 = setup("/plant/Squash.png");

        speed = 1;
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
