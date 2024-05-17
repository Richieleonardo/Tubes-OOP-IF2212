package org.object.plant;

import org.Entity.Entity;
import org.Entity.Projectile;
import org.main.GamePanel;
import org.object.pellet.Cabbage_pellet;
import org.object.zombie.Zombie;

public class Cabbagepult extends Plant {



    public Cabbagepult(GamePanel gp){
        super(gp, "Cabbagepult", 100, 300, 40, 3, -1, 5, false);

        //name = "Cabbagepult";
        down1 = setup("/plant/Cabbagepult.png");
        collision = true;
        projectile = new Cabbage_pellet(gp);
    }

    public void update(){
        System.out.println(name + " Health: " + Health);

        // PROJECTILE GENERATE ONLY WHEN THE OTHER IS NOT ALIVE
        if (!canAttack) {
            attack_counter++;
            if (attack_counter == 60 * getAttack_Speed()) {
                canAttack = true;
                attack_counter = 0;
            }
            return;
        }

        if (getRange() == -1) {
            if (!projectile.alive) {
                projectile.set(worldX, worldY, direction, true, this);
                // ADD PROJECTILE TO LIST
                gp.projectileList.add(projectile);
            }
        } else {
            for (Entity zombie : gp.zombie) {
                if (zombie == null || zombie.worldY != this.worldY) {
                    continue;
                }

                int distance = zombie.worldX - worldX;
                if (distance <= getRange() && !projectile.alive) {
                    projectile.set(worldX, worldY, direction, true, this);
                    // ADD PROJECTILE TO LIST
                    gp.projectileList.add(projectile);
                    break;
                }
            }
        }

        canAttack = false;
    }

}
