package src.main;

import src.object.*;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){
        gp.obj[0] = new Peashooter();
        gp.obj[0].worldX = 15 * gp.getTileSize();
        gp.obj[0].worldY = 8 * gp.getTileSize();

        gp.obj[1] = new SnowPeashooter();
        gp.obj[1].worldX = 16 * gp.getTileSize();
        gp.obj[1].worldY = 8 * gp.getTileSize();

        gp.obj[2] = new Kernelpult();
        gp.obj[2].worldX = 17 * gp.getTileSize();
        gp.obj[2].worldY = 8 * gp.getTileSize();

        //mulai dari 6
        gp.obj[6] = new Cabbagepult();
        gp.obj[6].worldX = 18 * gp.getTileSize();
        gp.obj[6].worldY = 8 * gp.getTileSize();

        gp.obj[7] = new Cabbage_pellet();
        gp.obj[7].worldX = 18 * gp.getTileSize();
        gp.obj[7].worldY = 7 * gp.getTileSize();

        gp.obj[8] = new Sunflower();
        gp.obj[8].worldX = 15 * gp.getTileSize();
        gp.obj[8].worldY = 10 * gp.getTileSize();

        gp.obj[9] = new SunParticle();
        gp.obj[9].worldX = 15 * gp.getTileSize();
        gp.obj[9].worldY = 9 * gp.getTileSize();

        gp.obj[10] = new Repeater();
        gp.obj[10].worldX = 16 * gp.getTileSize();
        gp.obj[10].worldY = 10 * gp.getTileSize();

        gp.obj[11] = new Threepeater();
        gp.obj[11].worldX = 17 * gp.getTileSize();
        gp.obj[11].worldY = 10 * gp.getTileSize();

        gp.obj[12] = new Squash();
        gp.obj[12].worldX = 18 * gp.getTileSize();
        gp.obj[12].worldY = 10 * gp.getTileSize();
//        gp.obj[2] = new Pea();
//        gp.obj[2].worldX = 18 * gp.getTileSize();
//        gp.obj[2].worldY = 7 * gp.getTileSize();
//
//        gp.obj[3] = new Pea();
//        gp.obj[3].worldX = 18 * gp.getTileSize();
//        gp.obj[3].worldY = 8 * gp.getTileSize();

        gp.obj[3] = new Pea2();
        gp.obj[3].worldX = 15 * gp.getTileSize();
        gp.obj[3].worldY = 7 * gp.getTileSize();

        gp.obj[4] = new SnowPea();
        gp.obj[4].worldX = 16 * gp.getTileSize();
        gp.obj[4].worldY = 7 * gp.getTileSize();

        gp.obj[5] = new Kernel_pellet();
        gp.obj[5].worldX = 17 * gp.getTileSize();
        gp.obj[5].worldY = 7 * gp.getTileSize();


    }
}
