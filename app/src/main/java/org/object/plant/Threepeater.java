package org.object.plant;

import org.Entity.Entity;
import org.Entity.Projectile;
import org.main.GamePanel;
import org.object.pellet.Pea2;

public class Threepeater extends Plant {
    Projectile projectile2;
    Projectile projectile3;
    public Threepeater(GamePanel gp){
        super(gp, "Threepeater", 325, 300, 60, 4, -1, 15, false);

        //name = "Threepeater";
        down1 = setup("/plant/Threepeater.png");
        projectile = new Pea2(gp);
        projectile2 = new Pea2(gp);
        projectile3 = new Pea2(gp);
    }

    @Override
    public Plant clone(){
        return new Threepeater(gp);
    }

    public void update(){
        System.out.println(name + "Health : " + Health);
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
                        if (distance <= getRange() || getRange() == -1) {
                            if (projectile.alive == false) {
                                projectile.set(worldX, worldY, direction, true, this);

                                //ADD PROJECTILE TO LIST
                                gp.projectileList.add(projectile);

//                                projectile = new Pea2(gp); // Create new projectile instance
                                projectile2.set(worldX, worldY-48, direction, true, this);  // Consider using Repeater instead of 'this'
                                gp.projectileList.add(projectile2);

//                                projectile = new Pea2(gp); // Create new projectile instance
                                projectile3.set(worldX, worldY+48, direction, true, this);  // Consider using Repeater instead of 'this'
                                gp.projectileList.add(projectile3);
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
