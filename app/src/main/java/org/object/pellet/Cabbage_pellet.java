package org.object.pellet;

import org.Entity.Projectile;
import org.main.GamePanel;

public class Cabbage_pellet extends Projectile {

    GamePanel gp;


    public Cabbage_pellet(GamePanel gp){
        super(gp);
        this.gp = gp;

        //Projectile status
        speed = 2;
        maxHealth = 99999;
        Health = maxHealth;
        alive = false;

        name = "Cabbage_pellet";
        down1 = setup("/objects/Cabbage_pellet.png");
    }




}
