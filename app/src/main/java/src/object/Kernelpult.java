package src.object;

import src.main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Kernelpult extends SuperObject{
    GamePanel gp;
    public Kernelpult(GamePanel gp){
        this.gp = gp;

        name = "Kernelpult";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Kernelpult.png"));
            image = uTool.scaledImage(image, gp.getTileSize(), gp.getTileSize());
        }
        catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
