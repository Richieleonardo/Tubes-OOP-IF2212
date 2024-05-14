package src.object;

import src.main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {

    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48); //Default value : 1 tile (48x48)
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;

    public void draw(Graphics2D g2, GamePanel gp){
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if(     worldX + gp.getTileSize() > gp.player.worldX - gp.player.screenX  &&
                worldX - gp.getTileSize() < gp.player.worldX + gp.player.screenX  &&
                worldY + gp.getTileSize() > gp.player.worldY - gp.player.screenY  &&
                worldY - gp.getTileSize() < gp.player.worldY + gp.player.screenY )
        {
            g2.drawImage(image, screenX, screenY, gp.getTileSize(), gp.getTileSize(), null);
        }
    }
}