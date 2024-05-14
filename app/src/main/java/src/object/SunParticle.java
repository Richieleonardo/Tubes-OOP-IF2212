package src.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class SunParticle extends SuperObject{

    public SunParticle(){

        name = "SunParticle";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/SunParticle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

