package org.object.plant;

import org.Entity.Entity;
import org.Entity.Projectile;
import org.main.GamePanel;
import org.object.pellet.Pea2;

public class Threepeater extends Plant {
    Projectile projectile2;
    Projectile projectile3;
    public Threepeater(GamePanel gp){
        super(gp, "Threepeater", 325, 200, 35, 4, -1, 15, false);

        //name = "Threepeater";
        description = "Threepeater adalah plant yang dapat menyerang zombie pada 3 tile berbeda menggunakan .";
        des2 = "pea.";
        entityDamage = getAttackDamage();
        down1 = setup("/plant/Threepeater.png");
        down2 = setup("/plant/Threepeater_Cooldown.png");
        projectile = new Pea2(gp);
        projectile2 = new Pea2(gp);
        projectile3 = new Pea2(gp);
    }

    @Override
    public Plant clone(){
        return new Threepeater(gp);
    }

    public void update(){
//        System.out.println(name + "Health : " + Health);
        Shoot();

    }

    @Override
    public void Shoot(){
        //      PROJECTILE GENERATE ONLY WHEN THE OTHER IS NOT ALIVE
        if(canAttack){
            for(Entity zombie : gp.zombie) {
                if (zombie != null) {
                    if (zombie.worldY == this.worldY || zombie.worldY-48 == this.worldY || zombie.worldY+48 == this.worldY) {
                        int distance = zombie.worldX - worldX;
                        if (distance <= getRange() && distance >= 0) {
                            if (projectile.alive == false) {
                                projectile.set(worldX, worldY, direction, true, this);

                                //ADD PROJECTILE TO LIST
                                gp.projectileList.add(projectile);

//                                projectile = new Pea2(gp); // Create new projectile instance
                                if (worldY-1*gp.getTileSize()!=5* gp.getTileSize()) {
                                    projectile2.set(worldX, worldY - 48, direction, true, this);  // Consider using Repeater instead of 'this'
                                    gp.projectileList.add(projectile2);
                                }
                                if (worldY+1*gp.getTileSize()!=12* gp.getTileSize()) {
//                                projectile = new Pea2(gp); // Create new projectile instance
                                    projectile3.set(worldX, worldY + 48, direction, true, this);  // Consider using Repeater instead of 'this'
                                    gp.projectileList.add(projectile3);
                                }
                            }
                        }
                    }
                }
            }
            canAttack = false;
        }
        else{
            attack_counter++; //HITUNG FRAME (60FRAME = 1 detik)
            if(attack_counter == 60*getAttack_Speed()){ //ATTACK setiap 3 detik
                canAttack = true;
                attack_counter = 0;
            }
        }
    }
}
