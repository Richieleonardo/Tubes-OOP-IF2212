package src.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Threepeater extends SuperObject{

    public Threepeater(){
        name = "Threepeater";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Threepeater.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
