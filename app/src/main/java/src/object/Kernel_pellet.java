package src.object;

import src.main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Kernel_pellet extends SuperObject{

    GamePanel gp;

    public Kernel_pellet(GamePanel gp){
        this.gp = gp;

        name = "Kernel_pellet";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Kernel_pellet.png"));
            image = uTool.scaledImage(image, gp.getTileSize(), gp.getTileSize());
        }
        catch(
                IOException e){
            e.printStackTrace();
        }
    }

}
