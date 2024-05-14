package src.object.pellet;

import src.Entity.Entity;
import src.main.GamePanel;

public class SunParticle extends Entity {

    public SunParticle(GamePanel gp){
        super(gp);

        name = "SunParticle";
        down1 = setup("/objects/Squash.png");
    }
}

