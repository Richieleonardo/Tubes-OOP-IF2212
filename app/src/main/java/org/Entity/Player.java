package org.Entity;

import org.main.GamePanel;
import org.main.KeyHandler;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Player extends Entity{

    KeyHandler keyH;
    public static int hasSun = 0;
    
    
    public final int screenX;
    public final int screenY;

    //Constructor
    public Player(GamePanel gp, KeyHandler keyH){
        super(gp);
        this.keyH = keyH;

        maxHealth = 6;
        Health = maxHealth;

        screenX = gp.getScreenWidth()/2 - (gp.getTileSize()/2);
        screenY = gp.getScreenHeight()/2 - (gp.getTileSize()/2);

        solidArea = new Rectangle(); //player 2
        solidArea.x = 12;
        solidArea.y = 0;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 24;
        solidArea.height = 48;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){ //Posisi awal player
        worldX = gp.getTileSize() * 17;
        worldY = gp.getTileSize() * 4;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){
            up1 = setup("/player/boy_up_1.png");
            up2 = setup("/player/boy_up_2.png");
            down1 = setup("/player/boy_down_1.png");
            down2 = setup("/player/boy_down_2.png");
            left1 = setup("/player/boy_left_1.png");
            left2 = setup("/player/boy_left_2.png");
            right1 = setup("/player/boy_right_1.png");
            right2 = setup("/player/boy_right_2.png");

    }



    public void update(){
//        System.out.println(Health);
        if(keyH.upPressed || keyH.downPressed ||
                keyH.leftPressed || keyH.rightPressed){
            if(keyH.upPressed){
                direction = "up";
            }
            else if (keyH.downPressed){
                direction = "down";
            }
            else if (keyH.leftPressed) {
                direction = "left";
            }
            else if (keyH.rightPressed){
                direction = "right";
            }

            //check tile collision
            collisionOn = false;
            gp.collisionChecker.checkTile(this);

            //check object collision
            int objIndex= gp.collisionChecker.checkObject(this, true);
            pickUpObject(objIndex);

            //check zombie collision
            int zombieIndex = gp.collisionChecker.checkEntity(this, gp.zombie);
            contactZombie(zombieIndex);

            //if collisionOn = false player can move
            if(collisionOn == false) {
                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }

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

    }

    public void pickUpObject(int index){

        if(index != 999){
            String objectName = gp.obj[index].name;

            switch(objectName){
                case "Pea":
                    hasSun++;
                    gp.obj[index] = null;
                    System.out.println("Has pea: "+hasSun);
                    break;
                case "Peashooter":
                    if(hasSun > 0){
                        gp.obj[index] = null;
                        hasSun--;
                    }
                    System.out.println("Has pea: "+hasSun);
                    break;
                case "Pea2":
                    gp.obj[index] = null;
                    break;
                case "SnowPea":
                    gp.obj[index] = null;
                    break;


            }
        }
    }

    //Test damage
    public void contactZombie(int i){
        if(i != 999){
            Health -= 1;
        }
    }

    public void draw(Graphics2D g2){
        BufferedImage image = null;

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