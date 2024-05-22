package org.object.plant;

import org.main.GamePanel;

import java.awt.*;

public class Wallnut extends Plant {

    public Wallnut(GamePanel gp){
        super(gp, "Wall nut", 50, 1000, 0, 0, 0, 20, false);

        //name = "Wallnut";
        down1 = setup("/plant/Wallnut.png");
        collision = true;
    }

    @Override
    public Plant clone(){
        return new Wallnut(gp);
    }

    public void update(){
//        System.out.println(name + "Health : " + Health);

    }
}
