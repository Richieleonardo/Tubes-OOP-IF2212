package org.object.pellet;

import org.Entity.Entity;
import org.main.GamePanel;

public class Cabbage_pellet extends Entity {


    public Cabbage_pellet(GamePanel gp){
        super(gp);
        name = "Cabbage_pellet";
        down1 = setup("/objects/Cabbage_pellet.png");

    }
}
