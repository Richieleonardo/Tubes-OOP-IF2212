package src.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Cabbagepult extends SuperObject{

    public Cabbagepult(){
        name = "Cabbagepult";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Cabbagepult.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
