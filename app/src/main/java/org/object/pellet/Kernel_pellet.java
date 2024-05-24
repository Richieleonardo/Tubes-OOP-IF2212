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
