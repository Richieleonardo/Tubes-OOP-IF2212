package src.object;

import src.main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class SunParticle extends SuperObject{
    GamePanel gp;

    public SunParticle(GamePanel gp){
        this.gp = gp;

        name = "SunParticle";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/SunParticle.png"));
            image = uTool.scaledImage(image, gp.getTileSize(), gp.getTileSize());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

