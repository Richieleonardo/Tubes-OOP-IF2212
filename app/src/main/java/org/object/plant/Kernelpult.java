package org.object.plant;

import org.Entity.Entity;
import org.Entity.Projectile;
import org.main.GamePanel;
import org.object.pellet.Corn;
import org.object.pellet.Kernel_pellet;
import org.object.pellet.Pea2;

import java.security.SecureRandom;

public class Kernelpult extends Plant {

    Projectile corn;
    public Kernelpult(GamePanel gp){
        super(gp, "Kernelpult", 100, 300, 30, 3, -1, 5, false);

        //name = "Kernelpult";
        description = "Kernelpult adalah plant yang dapat menyerang zombie menggunakan kernel pellet/ corn yang dapat memberi stun selama 1.5 detik.";
        entityDamage = getAttackDamage();
        down1 = setup("/plant/Kernelpult.png");
        collision = true;
        projectile = new Kernel_pellet(gp);
        corn = new Corn(gp);

    }

    @Override
    public Plant clone(){
        return new Kernelpult(gp);
    }

    public void update(){
//        System.out.println(name + "Health : " + Health);
        Shoot();



    }
    public void Shoot() {
        //      PROJECTILE GENERATE ONLY WHEN THE OTHER IS NOT ALIVE
        if (canAttack) {
            for (Entity zombie : gp.zombie) {
                if (zombie != null) {
                    if (zombie.worldY == this.worldY) {
                        int distance = zombie.worldX - this.worldX;
                        if (distance <= getRange() && distance >= 0 ) {
                            if (projectile.alive == false) {
                                SecureRandom rand = new SecureRandom();
                                int lucky = rand.nextInt(10);
                                if (lucky==0 || lucky ==1) {
                                    corn.set(worldX, worldY, direction, true, this);
                                    gp.projectileList.add(corn);
                                }

                                // Shoot second projectile with slight delay
                                else {
                                    if (corn.alive == false) {
                                        projectile.set(worldX, worldY, direction, true, this);
                                        gp.projectileList.add(projectile);
                                    }
                                }
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
