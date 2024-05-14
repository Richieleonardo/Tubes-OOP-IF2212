package src.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Squash extends SuperObject{

    public Squash(){
        name = "Squash";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Squash.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
