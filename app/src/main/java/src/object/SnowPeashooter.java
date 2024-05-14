package src.object;

import src.main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class SnowPeashooter extends SuperObject{
    GamePanel gp;

    public SnowPeashooter(GamePanel gp){
        this.gp = gp;

        name = "SnowPeashooter";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/SnowPeashooter.png"));
            image = uTool.scaledImage(image, gp.getTileSize(), gp.getTileSize());
        }
        catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
