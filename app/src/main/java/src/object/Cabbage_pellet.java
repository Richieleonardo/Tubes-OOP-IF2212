package src.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Cabbage_pellet extends SuperObject{

    public Cabbage_pellet(){
        name = "Cabbage_pellet";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Cabbage_pellet.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
