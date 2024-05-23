package org.object.plant;

import org.Entity.Projectile;
import org.main.GamePanel;
import org.object.pellet.Kernel_pellet;

public class Kernelpult extends Plant {

    Projectile corn;
    public Kernelpult(GamePanel gp){
        super(gp, "Kernelpult", 100, 300, 30, 3, -1, 5, false);

        //name = "Kernelpult";
        down1 = setup("/plant/Kernelpult.png");
        collision = true;
        projectile = new Kernel_pellet(gp);
        description = "Kernelpult adalah plant yang dapat menyerang zombie menggunakan kernel pellet.";
        plantDamage = getAttackDamage();
    }

    @Override
    public Plant clone(){
        return new Kernelpult(gp);
    }

    public void update(){
//        System.out.println(name + "Health : " + Health);
        Shoot();

    }
}
