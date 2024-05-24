package org.object.pellet;

import org.Entity.Projectile;
import org.main.GamePanel;
import org.object.zombie.Zombie;

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

    public void stun(Zombie zombie){
        if (zombie != null) {
            zombie.applySlow(90, 100); // Stun for 1.5 seconds (90 frames), 100% slow
            this.alive = false; // Projectile disappears after hitting
        }
    }
    @Override
    public void update(){
        //Check zombie collision
        int zombieIndex = gp.collisionChecker.checkEntity(this, gp.zombie);
        if(zombieIndex != 999){
            Zombie zombie = (Zombie) gp.zombie.get(zombieIndex);
            getUser().attackZombie(zombieIndex);
            stun(zombie);
            alive = false;
        }
        worldX += this.speed;

        Health--;
        if(Health <= 0){
            alive = false;
        }

    }
}
