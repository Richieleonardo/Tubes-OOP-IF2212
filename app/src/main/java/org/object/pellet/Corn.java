package org.object.pellet;

import org.Entity.Projectile;
import org.main.GamePanel;

public class Corn extends Projectile {

    GamePanel gp;

    public Corn(GamePanel gp){
        super(gp);
        this.gp = gp;

        //Projectile status
        speed = 2;
        maxHealth = 999; //Yang -1 assign healthnya tinggi aja, ini lifetime projectilenya 999 health = 999 frame (60 frame = 1 detik)
        Health = maxHealth;
        alive = false;

        name = "Cabbage_pellet";
        down1 = setup("/objects/Corn.png");
    }

    //TODO
    public void Freeze(){

    }
}
