package src.object;

import src.main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Cabbagepult extends SuperObject{

    GamePanel gp;

    public Cabbagepult(GamePanel gp){
        this.gp = gp;

        name = "Cabbagepult";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Cabbagepult.png"));
            image = uTool.scaledImage(image, gp.getTileSize(), gp.getTileSize());
        }
        catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
