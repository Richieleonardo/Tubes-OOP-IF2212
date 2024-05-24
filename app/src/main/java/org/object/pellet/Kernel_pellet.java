package org.object.pellet;

import org.Entity.Projectile;
import org.main.GamePanel;
import org.object.zombie.Zombie;

public class Kernel_pellet extends Projectile {

    GamePanel gp;

    public Kernel_pellet(GamePanel gp){
        super(gp);
        this.gp =  gp;

        name = "Kernel_pellet";
        down1 = setup("/objects/Kernel_pellet.png");

        speed = 2;
        maxHealth = 99999;
        Health = maxHealth;
        alive = false;
    }

}
