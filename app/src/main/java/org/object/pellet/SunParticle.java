package org.object.pellet;

import org.Entity.Projectile;
import org.main.GamePanel;

public class SunParticle extends Projectile {

    GamePanel gp;

    public SunParticle(GamePanel gp){
        super(gp);
        this.gp =  gp;

        name = "SunParticle";
        down1 = setup("/objects/SunParticle.png");

        speed = 2;
        maxHealth = 99999;
        Health = maxHealth;
        alive = false;
    }
}

