package src.object;

import src.main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Pea extends SuperObject{
    GamePanel gp;

    public Pea(GamePanel gp){
        this.gp = gp;

        name = "Pea";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Pea.png"));
            image = uTool.scaledImage(image, gp.getTileSize(), gp.getTileSize());
        }
        catch(IOException e){
            e.printStackTrace();
        }
        solidArea.x = 12;
        solidArea.y = 12;
        solidArea.width = 24;
        solidArea.height = 24;

        solidAreaDefaultX = 12;
        solidAreaDefaultY = 12;
        collision = true;
    }
}
