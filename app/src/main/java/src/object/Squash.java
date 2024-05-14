package src.object;

import src.main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Squash extends SuperObject{
    GamePanel gp;

    public Squash(GamePanel gp){
        this.gp = gp;
        name = "Squash";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Squash.png"));
            image = uTool.scaledImage(image, gp.getTileSize(), gp.getTileSize());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
