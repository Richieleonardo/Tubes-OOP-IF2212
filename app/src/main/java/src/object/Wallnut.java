package src.object;

import src.main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Wallnut extends SuperObject{
    GamePanel gp;

    public Wallnut(GamePanel gp){
        this.gp = gp;

        name = "Wallnut";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Wallnut.png"));
            image = uTool.scaledImage(image, gp.getTileSize(), gp.getTileSize());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
