package org.tile;

import org.main.GamePanel;
import org.main.UtilityTool;
import org.main.*;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;


public class TileManager {
    GamePanel gp;
    public Tile[] tile; //Array of tile
    public int[][] mapTileNum;

    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap(); //Input map file here. Note : Untuk instantiasi tipe tile
    }

    public void getTileImage(){ //Load image method
        //Banyak jenis tiles
        setup(0, "/tiles/grass01.png", false);
        setup(1, "/tiles/wall.png", true);
        setup(2, "/tiles/water01.png", true);
        setup(3, "/tiles/earth.png", false);
        setup(4, "/tiles/road00.png", false);
        setup(5, "/tiles/tree.png", true);
        setup(6, "/tiles/SolidAreaCounter.png", false);
//            tile[0] = new Tile();
//            tile[0] = ImageIO.read(getClass().getResourceAsStream("/tiles/" + "grass01" + ".png"));
    }

    public void setup(int index, String imagePath, boolean collision){

        UtilityTool uTool = new UtilityTool();

        try{
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream(imagePath));
            tile[index].image = uTool.scaledImage(tile[index].image, gp.getTileSize(), gp.getTileSize());
            tile[index].collision = collision;
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadMap(){
        try{
            InputStream is = getClass().getResourceAsStream("/maps/mapdebug.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(is)));

            int col = 0; //0
            int row = 0; //0

            while(col < gp.maxWorldCol && row < gp.maxWorldRow){ //maxWorldCol,maxWorldRow (Untuk camera setting)
                String line = br.readLine();

                while(col < gp.maxWorldCol){
                    String numbers[] = line.split(" "); //TODO : pelajari regex
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
    *   Draw tiles inside Game Panel Frame
    *   KODE : [0 = grass], [1 = wall], [2 = water]
    */


    public void draw(Graphics2D g2){
        int col = 0;
        int row = 0;

        while(col < gp.maxWorldCol && row < gp.maxWorldRow){ //maxWorldCol, maxWorldRow for camera settings

            int tileNum = mapTileNum[col][row];

            int worldX = col * gp.getTileSize();
            int worldY = row * gp.getTileSize();
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if(     worldX + gp.getTileSize() > gp.player.worldX - gp.player.screenX  &&
                    worldX - gp.getTileSize() < gp.player.worldX + gp.player.screenX  &&
                    worldY + gp.getTileSize() > gp.player.worldY - gp.player.screenY  &&
                    worldY - gp.getTileSize() < gp.player.worldY + gp.player.screenY )
            {
                g2.drawImage(tile[tileNum].image, screenX, screenY, null); //Optimized draw tile
            }

            col++;


            if(col == gp.maxWorldCol ){
                col = 0;
                row++;

            }
        }
    }
}
