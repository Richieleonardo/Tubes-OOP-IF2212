package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class TileManager {
    GamePanel gp;
    Tile[] tile; //Array of tile
    int mapTileNum[][];

    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.getMaxScreenCol()][gp.getMaxScreenRow()];

        getTileImage();
        loadMap("maps/map01.txt"); //Input map file here. Note : Untuk instantiasi tipe tile
    }

    public void getTileImage(){ //Load image method
        try{
            //Banyak jenis tiles
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/grass01.png"));
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/wall.png"));
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/water01.png"));
        }
        catch(IOException e){
            e.printStackTrace();;
        }
    }

    public void loadMap(String filepath){
        try{
            InputStream is = getClass().getClassLoader().getResourceAsStream(filepath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.getMaxScreenCol() && row < gp.getMaxScreenRow()){
                String line = br.readLine();

                while(col < gp.getMaxScreenCol()){
                    String numbers[] = line.split(" "); //TODO : pelajari regex
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.getMaxScreenCol()) {
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
        int x = 0;
        int y = 0;

        while(col < gp.getMaxScreenCol() && row < gp.getMaxScreenRow()){

            int tileNum = mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image, x, y, gp.getTileSize(), gp.getTileSize(), null);
            col++;
            x += gp.getTileSize(); //For collumn tile x = (0, 48, 96, ...)

            if(col == gp.getMaxScreenCol()){
                col = 0;
                x = 0;
                row++;
                y += gp.getTileSize();  //For row tile y = (0, 48, 96, ...)
            }
        }
    }
}
