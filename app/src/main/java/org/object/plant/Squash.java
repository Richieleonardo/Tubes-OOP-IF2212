package org.object.plant;

import org.Entity.Entity;
import org.main.GamePanel;
import org.object.pellet.Squash_proj;

public class Squash extends Plant {

    public Squash(GamePanel gp){
        super(gp, "Squash", 50, 100, 5000, 0, 1, 20, false);
        //name = "Squash";

        description = "Squash adalah plant yang dapat melakukan instakill pada zombie.";
        entityDamage = getAttackDamage();
        down1 = setup("/plant/Squash.png");
        down2 = setup("/plant/Squash_Cooldown.png");
        collision = true;
        projectile = new Squash_proj(gp);
    }

    @Override
    public Plant clone() {
        return new Squash(gp);
    }

    public void update() {
        System.out.println(name + "Health : " + Health);
        Shoot();

    }

    public void Shoot() {
        //      PROJECTILE GENERATE ONLY WHEN THE OTHER IS NOT ALIVE
            for (Entity zombie : gp.zombie) {
                if (zombie != null) {
                    if (zombie.worldY == this.worldY) {
                        int distance = zombie.worldX - this.worldX;
                        if (distance <= getRange() && distance >= 0) {
                            if (projectile.alive == false) {
                                maxHealth = 0;
                                projectile.set(worldX, worldY, direction, true, this);

                                //ADD PROJECTILE TO LIST
                                gp.projectileList.add(projectile);
                            }
                        }
                    }
                }
            }
        }
//        public void kamikaze(){
//            int zombieIndex = gp.collisionChecker.checkEntity(this, gp.zombie);
//            if(zombieIndex != 999){
//                gp.zombie.get(zombieIndex).Health -= getAttackDamage();
//
//                if(gp.zombie.get(zombieIndex).Health <= 0){
//                    gp.zombie.remove(zombieIndex);
//                }
//            }
//    }
}




