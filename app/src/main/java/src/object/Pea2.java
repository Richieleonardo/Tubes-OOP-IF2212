package src.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Pea2 extends SuperObject{

    public Pea2(){
        name = "Pea2";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Pea2.png"));
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
