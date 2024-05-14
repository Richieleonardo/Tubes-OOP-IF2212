package src.object;

import src.main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Peashooter extends SuperObject{
    GamePanel gp;

    public Peashooter(GamePanel gp){
        this.gp = gp;

        name = "Peashooter";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Peashooter.png"));
            image = uTool.scaledImage(image, gp.getTileSize(), gp.getTileSize());
        }
        catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}

