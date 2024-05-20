package org.Entity;

import org.main.GamePanel;
import org.main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/*
SUPER CLASS UNTUK SEMUA OBJECT YANG DIBUAT PADA PROGRAM

TODO : IMPLEMENT abstract PLANT yang extend Entity.
       IMPLEMENT abstract ZOMBIE yang extend Entity
       Buat ArrayList baru di GamePanel untuk menyimpan Plant dan Zombie saja.

 */
public class Entity {
    public GamePanel gp;

    public int worldX ,worldY;
    public double speed;

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

//    public int type; // 1 plant, 2 zombie

//    //PROJECTILE TEST (for now)
    public boolean alive;
//    public Projectile projectile;

    //TickCounter
    public int tickCounter;

    //CONSTRUCTOR
    public Entity(GamePanel gp){
        this.gp = gp;
    }

    //SETACTION and UPDATE method for Entity
    public void setAction(){}

    public void update(){
        setAction();

        collisionOn = false;
        gp.collisionChecker.checkTile(this);
//        gp.collisionChecker.checkObject(this, false);
        gp.collisionChecker.checkEntity(this, gp.zombie);
        gp.collisionChecker.checkEntity(this, gp.plant);

//        //if collisionOn = false player can move
//        if(collisionOn == false) {
//            switch (direction) {
//                case "up":
//                    worldY -= speed;
//                    break;
//                case "down":
//                    worldY += speed;
//                    break;
//                case "left":
//                    worldX -= speed;
//                    break;
//                case "right":
//                    worldX += speed;
//                    break;
//            }
//        }

        //Image change every 20 frame
        spriteCounter++;
        if(spriteCounter > 20){
            if(spriteNum == 1){
                spriteNum = 2;
            }
            else if(spriteNum == 2){
                spriteNum = 1;
            }
            spriteCounter = 0;
        }


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

        BufferedImage image = down1;

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
