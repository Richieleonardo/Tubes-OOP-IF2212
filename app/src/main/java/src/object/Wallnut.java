package src.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Wallnut extends SuperObject{

    public Wallnut(){
        name = "Wallnut";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Wallnut.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
