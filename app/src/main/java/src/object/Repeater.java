package src.object;

import src.main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Repeater extends SuperObject{
    GamePanel gp;

    public Repeater(GamePanel gp){
        this.gp = gp;
        name = "Repeater";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Repeater.png"));
            image = uTool.scaledImage(image, gp.getTileSize(), gp.getTileSize());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
