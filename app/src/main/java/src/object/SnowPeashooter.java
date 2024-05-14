package src.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class SnowPeashooter extends SuperObject{
    public SnowPeashooter(){
        name = "SnowPeashooter";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/SnowPeashooter.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
