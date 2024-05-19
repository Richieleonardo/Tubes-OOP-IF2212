package org.main;

import org.object.Door;
import org.object.pellet.Kernel_pellet;
import org.object.plant.Peashooter;
import org.object.plant.Repeater;
import org.object.zombie.ConeHeadZombie;
import org.object.zombie.NormalZombie;
import org.object.*;
import org.object.pellet.Cabbage_pellet;
import org.object.plant.Cabbagepult;
import org.object.plant.Kernelpult;

/*
ASSETSETTER DIGUNAKAN UNTUK MELETAKAN OBJECT PADA MAP
UNTUK SEKARANG MASIH DALAM TESTING PURPOSE
 */

/*
TODO : Coba test random spawn pada zombie, fokus pada koordinat worldY zombie.
       Agar zombie bisa berada pas ditengah Tile, dikali dengan getTileSize()
       Rand(1-6)+1 untuk 6 tiles.
       Perlu Count Zombie untuk ngitung zombienya.
       Zombie berhenti spawn pada detik 200.
       Pake System.nanoTime() untuk hitung time. [1_000_000_000 nanoSecond] = 1 second

       Tutorial : https://youtu.be/RXq8cyv_7Mc?si=RyHsIb0PsbNCpyHy
 */

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setZombie(){
        gp.zombie[0] = new NormalZombie(gp);
        gp.zombie[0].worldX = 24 * gp.getTileSize();
        gp.zombie[0].worldY = 7 * gp.getTileSize();

        gp.zombie[1] = new ConeHeadZombie(gp);
        gp.zombie[1].worldX = 24 * gp.getTileSize();
        gp.zombie[1].worldY = 6 * gp.getTileSize();

    }

    public void setPlant(){

        gp.plant[0] = new Peashooter(gp);
        gp.plant[0].worldX = 18 * gp.getTileSize();
        gp.plant[0].worldY = 7 * gp.getTileSize();

        gp.plant[1] = new Cabbagepult(gp);
        gp.plant[1].worldX = 17 * gp.getTileSize();
        gp.plant[1].worldY = 7 * gp.getTileSize();

        gp.plant[2] = new Repeater(gp);
        gp.plant[2].worldX = 17 * gp.getTileSize();
        gp.plant[2].worldY = 6 * gp.getTileSize();

        gp.plant[3] = new Peashooter(gp);
        gp.plant[3].worldX = 16 * gp.getTileSize();
        gp.plant[3].worldY = 6 * gp.getTileSize();

    }

    public void setObject(){

        gp.obj[7] = new Cabbage_pellet(gp);
        gp.obj[7].worldX = 18 * gp.getTileSize();
        gp.obj[7].worldY = 7 * gp.getTileSize();

//        gp.obj[8] = new Door(gp);
//        gp.obj[8].worldX = 20 * gp.getTileSize();
//        gp.obj[8].worldY = 10 * gp.getTileSize();

//        gp.obj[5] = new Kernel_pellet(gp);
//        gp.obj[5].worldX = 17 * gp.getTileSize();
//        gp.obj[5].worldY = 7 * gp.getTileSize();


    }
}
