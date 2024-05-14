package src.object;

import src.Entity.Entity;
import src.main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Cabbage_pellet extends Entity {


    public Cabbage_pellet(GamePanel gp){
        super(gp);
        name = "Cabbage_pellet";
        down1 = setup("/objects/Cabbage_pellet.png");

    }
}
