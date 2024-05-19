package org.object.plant;

import org.main.GamePanel;

public class Lilypad extends Plant {

    public Lilypad(GamePanel gp){
        super(gp, "Lilypad",25,100,0,0,0,10, true);

        //belum ada png
        name = "Lilypad";
        down1 = setup("/plant/Lilypad.png");
        collision = true;
    }

    @Override
    public Plant clone(){
        return new Lilypad(gp);
    }

    public void update(){
        System.out.println(name + "Health : " + Health);

    }
}