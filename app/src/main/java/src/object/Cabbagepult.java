package src.object;

import src.Entity.Entity;
import src.main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Cabbagepult extends Entity {


    public Cabbagepult(GamePanel gp){
        super(gp);

        name = "Cabbagepult";
        down1 = setup("/objects/Cabbagepult.png");
        collision = true;
    }
}
