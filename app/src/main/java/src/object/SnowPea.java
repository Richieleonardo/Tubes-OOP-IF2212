package src.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class SnowPea extends SuperObject{

    public SnowPea(){
        name = "SnowPea";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/SnowPea.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        solidArea.x = 9;
        solidArea.y = 9;
        solidArea.width = 27;
        solidArea.height = 27;

        solidAreaDefaultX = 9;
        solidAreaDefaultY = 9;
        collision = true;
    }
}
