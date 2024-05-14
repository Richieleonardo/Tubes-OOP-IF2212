package src.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Peashooter extends SuperObject{
    public Peashooter(){
        name = "Peashooter";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Peashooter.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}

