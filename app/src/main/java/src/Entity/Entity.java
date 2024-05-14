package src.Entity;

import src.main.GamePanel;
import src.main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

//Super class entity dalam game
public class Entity {
    GamePanel gp;

    public int worldX ,worldY;
    public int speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;//Store image file
    public String direction = "down"; //DEFAULT

    public int spriteCounter = 0;
    public int spriteNum = 1;

    //ENTITY STATUS
    public int maxHealth;
    public int Health;

    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;

    //FOR OBJECT
    public BufferedImage image;
    public String name;
    public boolean collision = false;

    //CONSTRUCTOR
    public Entity(GamePanel gp){
        this.gp = gp;
    }

    public BufferedImage setup(String imagePath){
        UtilityTool uTool = new UtilityTool();
        BufferedImage Image = null;

        try {
            Image = ImageIO.read(getClass().getResourceAsStream(imagePath));
            Image = uTool.scaledImage(Image, gp.getTileSize(), gp.getTileSize());

        }
        catch(IOException e){
            e.getStackTrace();
        }
        return Image;
    }

    public void draw(Graphics2D g2){

        BufferedImage image = null;

        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if(     worldX + gp.getTileSize() > gp.player.worldX - gp.player.screenX  &&
                worldX - gp.getTileSize() < gp.player.worldX + gp.player.screenX  &&
                worldY + gp.getTileSize() > gp.player.worldY - gp.player.screenY  &&
                worldY - gp.getTileSize() < gp.player.worldY + gp.player.screenY )
        {
            if(direction == "up"){
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up2;
                }
            }
            else if(direction == "down"){
                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2){
                    image = down2;
                }
            }
            else if(direction == "left"){
                if(spriteNum == 1){
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;
                }
            }
            else{
                if(spriteNum == 1){
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }
            }
            g2.drawImage(image, screenX, screenY, null);
        }
    }


}
