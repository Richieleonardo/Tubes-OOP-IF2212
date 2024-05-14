package src.object;

import src.Entity.Entity;
import src.main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Kernel_pellet extends Entity {


    public Kernel_pellet(GamePanel gp){
        super(gp);

        name = "Kernel_pellet";
        down1 = setup("/objects/Kernel_pellet.png");

    }

}
