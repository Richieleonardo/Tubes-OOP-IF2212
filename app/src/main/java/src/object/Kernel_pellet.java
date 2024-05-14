package src.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Kernel_pellet extends SuperObject{

    public Kernel_pellet(){
        name = "Kernel_pellet";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Kernel_pellet.png"));
        }
        catch(
                IOException e){
            e.printStackTrace();
        }
    }

}
