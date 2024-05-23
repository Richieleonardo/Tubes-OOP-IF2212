package org.object.plant;

import org.main.GamePanel;
import org.object.pellet.SnowPea;

public class SnowPeashooter extends Plant {

    public SnowPeashooter(GamePanel gp){
        super(gp, "SnowPeashooter", 175, 100, 25, 4, -1, 10, false);

        //name = "SnowPeashooter";
        down1 = setup("/plant/SnowPeashooter.png");
        collision = true;
        projectile = new SnowPea(gp);
        description = "SnowPeaShooter adalah plant yang dapat memperlambat zombie 50% selama 3 detik ";
        des2 = "menggunakan snowpea.";
        plantDamage = getAttackDamage();
    }

    @Override
    public Plant clone(){
        return new SnowPeashooter(gp);
    }

    public void update(){
//        System.out.println(name + "Health : " + Health);
        Shoot();

    }
}
