package org.object.plant;

import com.sun.source.tree.CatchTree;
import org.Entity.Entity;
import org.Entity.Projectile;
import org.main.GamePanel;
import org.object.pellet.Pea2;

import java.util.concurrent.TimeUnit;

public class Repeater extends Plant {
    Projectile projectile2;
    public Repeater(GamePanel gp){
        super(gp, "Repeater", 200, 300, 40, 4, -1, 5, false);

        //name = "Repeater";
        down1 = setup("/plant/Repeater.png");
        collision = true;
        projectile = new Pea2(gp);
        projectile2 = new Pea2(gp);
    }

    @Override
    public Plant clone(){
        return new Repeater(gp);
    }

    public void update() {
            System.out.println(name + "Health : " + Health);
            Shoot();
    }
    public void Shoot() {
        //      PROJECTILE GENERATE ONLY WHEN THE OTHER IS NOT ALIVE
        if (canAttack) {
            for (Entity zombie : gp.zombie) {
                if (zombie != null) {
                    if (zombie.worldY == this.worldY) {
                        int distance = zombie.worldX - this.worldX;
                        if (distance <= getRange()) {
                            projectile.set(worldX, worldY, direction, true, this);
                            gp.projectileList.add(projectile);

                            // Shoot second projectile with slight delay
                            try {
                                TimeUnit.NANOSECONDS.sleep(2000);
                                projectile = new Pea2(gp); // Create new projectile instance
                                projectile2.set(worldX, worldY, direction, true, this);  // Consider using Repeater instead of 'this'
                                gp.projectileList.add(projectile2);
                            } catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
            canAttack = false;
        } else {
            attack_counter++; //HITUNG FRAME (60FRAME = 1 detik)
            if(attack_counter == 60*getAttack_Speed()){ //ATTACK setiap 3 detik
                canAttack = true;
                attack_counter = 0;
            }
        }
    }
}
