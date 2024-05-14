package src.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Repeater extends SuperObject{

    public Repeater(){
        name = "Repeater";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Repeater.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
