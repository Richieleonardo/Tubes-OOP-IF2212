package src.object;

import src.main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class SnowPea extends SuperObject{
    GamePanel gp;

    public SnowPea(GamePanel gp){
        this.gp = gp;

        name = "SnowPea";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/SnowPea.png"));
            image = uTool.scaledImage(image, gp.getTileSize(), gp.getTileSize());
        }
        catch(IOException e){
            e.printStackTrace();
        }
        solidArea.x = 9;
        solidArea.y = 9;
        solidArea.width = 27;
        solidArea.height = 27;

        solidAreaDefaultX = 9;
        solidAreaDefaultY = 9;
        collision = true;
    }
}
