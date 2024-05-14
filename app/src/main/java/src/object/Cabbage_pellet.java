package src.object;

import src.main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Cabbage_pellet extends SuperObject{

    GamePanel gp;

    public Cabbage_pellet(GamePanel gp){
        this.gp = gp;
        name = "Cabbage_pellet";

        try{
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/Cabbage_pellet.png"));
            image = uTool.scaledImage(image, gp.getTileSize(), gp.getTileSize());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
