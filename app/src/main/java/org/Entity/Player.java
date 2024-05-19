package org.Entity;

import org.main.GamePanel;
import org.main.KeyHandler;
import org.object.plant.Cabbagepult;
import org.object.plant.Peashooter;
import org.object.plant.SnowPeashooter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Player extends Entity{

    KeyHandler keyH;
    //PLAYER SUN
    public static int hasSun = 0;

    Graphics2D g2;
    public ArrayList<Entity> deck = new ArrayList<>();
    public final int deckSize = 6;
    //CURSOR PLACEMENT IN MAP
    public int worldCursorCol = 16;
    public int worldCursorRow = 7;

    public final int screenX;
    public final int screenY;

    public int tickCounter = 0;


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
        worldX = gp.getTileSize() * 18;
        worldY = gp.getTileSize() * 8;
        speed = 4;
        direction = "down";
        hasSun = 100;
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

    public void selectPlant(){
        int itemIndex = gp.ui.getPlantIndexOnInventory();

        if(itemIndex < gp.ui.inventory.size()){
            Entity selectedItem = gp.ui.inventory.get(itemIndex);
            if(!deck.contains(selectedItem)){
                if (deck.size() < 6) {
                    deck.add(selectedItem);
                }
                else{
                    System.out.println("Can't put plants");
                }
            }
            else{
                deck.remove(selectedItem);
            }
        }
    }


    /*
    TODO : SPAWN PLANT DENGAN MENGGUNAKAN FITUR DECK
           MENGURANGI SUN JIKA BERHASIL MENANAM TANAMAN
           MEMBERIKAN COOLDOWN SETIAP TANAMAN DITANAM
     */
    public void putPlant(){
        int plantIndex = gp.ui.getPlantIndexOnDeck();

        //GET TILE
        int worldTileX = worldCursorCol/gp.getTileSize();
        int worldTileY = worldCursorRow/gp.getTileSize();
        int tileNum = gp.tileM.mapTileNum[worldTileX][worldTileY];

        if(plantIndex < deck.size()){
            Entity selectedPlant = deck.get(plantIndex);

        }

        // CURSOR
        int cursorX = (gp.getTileSize() * worldCursorCol);
        int cursorY = (gp.getTileSize() * worldCursorRow);
        int cursorWidth = gp.getTileSize();
        int cursorHeight = gp.getTileSize();

        //DRAW CURSOR
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(3));
        if(gp.gameState == gp.playState){
            g2.drawRoundRect(cursorX,cursorY, cursorWidth, cursorHeight, 10, 10);
        }
    }

    /*
    TODO : MENGHILANGKAN TANAMAN DARI MAP
           JIKA TANAMAN DI AIR DAN DIATAS LILYPAD, MENGHILANGKAN KEDUA TANAMAN
     */
    public void digPlant(){

    }

    public void addSun(){
        if(tickCounter == 3*60){
            hasSun += 25;
            tickCounter = 0;
        }
        else{
            tickCounter++;
        }
    }

    public void update(){
        addSun();
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

//            check object collision
//            int objIndex= gp.collisionChecker.checkObject(this, true);
//            pickUpObject(objIndex);
//
//            check zombie collision
//            int zombieIndex = gp.collisionChecker.checkEntity(this, gp.zombie);
//            contactZombie(zombieIndex);

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
