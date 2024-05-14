package src.object;

import src.main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Sunflower extends SuperObject {
    GamePanel gp;

    public Sunflower(GamePanel gp) {
        this.gp = gp;

        name = "Sunflower";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Sunflower.png"));
            image = uTool.scaledImage(image, gp.getTileSize(), gp.getTileSize());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
