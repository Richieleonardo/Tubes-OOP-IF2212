package org.object.pellet;

import org.Entity.Entity;
import org.main.GamePanel;

public class SunParticle extends Entity {

    public SunParticle(GamePanel gp){
        super(gp);

        name = "SunParticle";
        down1 = setup("/plant/Squash.png");
    }
}

