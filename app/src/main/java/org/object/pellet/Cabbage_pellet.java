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
        maxHealth = 999; //Yang -1 assign healthnya tinggi aja, ini lifetime projectilenya 999 health = 999 frame (60 frame = 1 detik)
        Health = maxHealth;
        alive = false;

        name = "Cabbage_pellet";
        down1 = setup("/objects/Cabbage_pellet.png");
    }




}
