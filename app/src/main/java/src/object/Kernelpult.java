package src.object;

import src.Entity.Entity;
import src.main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Kernelpult extends Entity {

    public Kernelpult(GamePanel gp){
        super(gp);

        name = "Kernelpult";
        down1 = setup("/objects/Kernelpult.png");
        collision = true;
    }
}
