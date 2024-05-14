package src.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Kernelpult extends SuperObject{

    public Kernelpult(){
        name = "Kernelpult";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Kernelpult.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
