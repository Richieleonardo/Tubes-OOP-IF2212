package org.object.plant;

import org.Entity.Entity;
import org.main.GamePanel;
import org.object.pellet.Pea2;

public class Threepeater extends Plant {

    public Threepeater(GamePanel gp){
        super(gp, "Threepeater", 325, 300, 60, 4, -1, 15, false);

        //name = "Threepeater";
        down1 = setup("/plant/Threepeater.png");
        projectile = new Pea2(gp);
    }

    @Override
    public Plant clone(){
        return new Threepeater(gp);
    }

    public void update(){
        System.out.println(name + "Health : " + Health);
        Shoot();

    }
    public void Shoot(){
        //      PROJECTILE GENERATE ONLY WHEN THE OTHER IS NOT ALIVE
        if(canAttack){
            for(Entity zombie : gp.zombie) {
                if (zombie != null) {
                    if (zombie.worldY == this.worldY) {
                        int distance = zombie.worldX - worldX;
                        if (distance <= getRange() || getRange() == -1) {
                            if (projectile.alive == false) {
                                projectile.set(worldX, worldY, direction, true, this);

                                //ADD PROJECTILE TO LIST
                                gp.projectileList.add(projectile);
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
