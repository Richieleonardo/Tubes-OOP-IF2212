package src.main;

import src.object.*;
import src.object.pellet.Cabbage_pellet;
import src.object.pellet.Kernel_pellet;
import src.object.plant.Cabbagepult;
import src.object.plant.Kernelpult;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setZombie(){

    }

    public void setPlant(){

        gp.obj[2] = new Kernelpult(gp);
        gp.obj[2].worldX = 17 * gp.getTileSize();
        gp.obj[2].worldY = 8 * gp.getTileSize();

        //mulai dari 6
        gp.obj[6] = new Cabbagepult(gp);
        gp.obj[6].worldX = 18 * gp.getTileSize();
        gp.obj[6].worldY = 8 * gp.getTileSize();
    }

    public void setObject(){

        gp.obj[7] = new Cabbage_pellet(gp);
        gp.obj[7].worldX = 18 * gp.getTileSize();
        gp.obj[7].worldY = 7 * gp.getTileSize();

        gp.obj[8] = new Door(gp);
        gp.obj[8].worldX = 20 * gp.getTileSize();
        gp.obj[8].worldY = 10 * gp.getTileSize();

        gp.obj[5] = new Kernel_pellet(gp);
        gp.obj[5].worldX = 17 * gp.getTileSize();
        gp.obj[5].worldY = 7 * gp.getTileSize();


    }
}
