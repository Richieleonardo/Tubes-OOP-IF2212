package src.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Sunflower extends SuperObject {

    public Sunflower() {
        name = "Sunflower";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Sunflower.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
