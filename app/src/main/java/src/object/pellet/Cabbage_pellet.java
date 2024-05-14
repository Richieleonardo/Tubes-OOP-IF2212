package src.object.pellet;

import src.Entity.Entity;
import src.main.GamePanel;

public class Cabbage_pellet extends Entity {


    public Cabbage_pellet(GamePanel gp){
        super(gp);
        name = "Cabbage_pellet";
        down1 = setup("/objects/Cabbage_pellet.png");

    }
}
