package src.object;

import src.main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Threepeater extends SuperObject{
    GamePanel gp;

    public Threepeater(GamePanel gp){
        this.gp = gp;

        name = "Threepeater";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Threepeater.png"));
            image = uTool.scaledImage(image, gp.getTileSize(), gp.getTileSize());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
