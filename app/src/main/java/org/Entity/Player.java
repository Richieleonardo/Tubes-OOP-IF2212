package org.Entity;

import org.main.GamePanel;
import org.main.KeyHandler;
import org.object.plant.*;
import org.object.zombie.*;
import org.main.UI;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.security.SecureRandom;
import java.util.ArrayList;

public class Player extends Entity{

    KeyHandler keyH;
    //PLAYER SUN
    public static int hasSun = 0;

    Graphics2D g2;
    public ArrayList<Plant> deck = new ArrayList<>();
    public final int deckSize = 6;
    //CURSOR PLACEMENT IN MAP
    public int worldCursorCol = 16;
    public int worldCursorRow = 7;

    public final int screenX;
    public final int screenY;

    public int sunTickCounter = 0;
    public int zombieTickCounter = 180; //DEFAULT

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
        solidArea.height = 20;

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
        up1 = setup("/player/hotbar_selector.png");
        up2 = setup("/player/hotbar_selector.png");
        down1 = setup("/player/hotbar_selector.png");
        down2 = setup("/player/hotbar_selector.png");
        left1 = setup("/player/hotbar_selector.png");
        left2 = setup("/player/hotbar_selector.png");
        right1 = setup("/player/hotbar_selector.png");
        right2 = setup("/player/hotbar_selector.png");

    }

    public void selectPlant(){
        int itemIndex = gp.ui.getPlantIndexOnInventory();

        if(itemIndex < gp.ui.inventory.size()){
            Entity selectedItem = gp.ui.inventory.get(itemIndex);
            if(!deck.contains(selectedItem)){
                if (deck.size() < 6) {
                    deck.add((Plant) selectedItem);
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

//        //GET TILE
//        int worldTileX = worldCursorCol/gp.getTileSize();
//        int worldTileY = worldCursorRow/gp.getTileSize();
//        int tileNum = gp.tileM.mapTileNum[worldTileX][worldTileY];

        if(plantIndex < deck.size()){
            // Membuat copy plant
            Plant selectedPlant = (Plant) deck.get(plantIndex).clone();

            // Mendapatkan posisi player
            int playerTileX = (int) Math.floor((worldX+24)/gp.getTileSize());
            int playerTileY = (int) Math.floor((worldY+24)/gp.getTileSize());

            // Menanam jika kondisi berikut terpenuhi
            // TODO: belum memperhitungkan cooldown plant
            if (hasSun >= selectedPlant.getCost() && isPlantable(selectedPlant, playerTileX, playerTileY)){
                useSun(selectedPlant.getCost());
                gp.assetSetter.setPlant(selectedPlant, playerTileX, playerTileY);
            }
        }
    }

    public boolean isOnWater(int X, int Y){
        return (X >= 15 && X <= 23) && (Y >= 8 && Y <= 9);
    }

    public boolean isPlanted(int X, int Y){
        int tileX = X*gp.getTileSize();
        int tileY = Y*gp.getTileSize();

        // Mengecek apakah terdapat plant
        for (Entity p : gp.plant){
            Plant castp = (Plant) p;
            if (castp.worldX == tileX && castp.worldY == tileY){
                return true;
            }
        }
        return false;
    }

    public boolean isLilyPadPlanted(int X, int Y){
        int tileX = X*gp.getTileSize();
        int tileY = Y*gp.getTileSize();

        // Mengecek apakah Lilypad sudah ditanam
        for (Entity p : gp.plant){
            if (((Plant) p).getName().equals("Lilypad") && p.worldX == tileX && p.worldY == tileY){
                return true;
            }
        }
        return false;
    }

    public boolean isPlantable(Plant plant, int X, int Y){
        boolean isValidPos = (X >= 15 && X <= 23) && (Y >= 6 && Y <= 11);

        if (isOnWater(X, Y)){ // Jika player berada di atas air
            if (plant.getIsAquatic()){ // Memastikan Lilypad tidak bertumpuk
                return isValidPos && !isLilyPadPlanted(X, Y);
            } else { // Harus ada Lilypad sebelum ditanam plant lain
                return isValidPos && isLilyPadPlanted(X, Y);
            }
        } else {
            return !plant.getIsAquatic() && isValidPos && !isPlanted(X, Y);
        }
    }

    /*
    TODO : MENGHILANGKAN TANAMAN DARI MAP
           JIKA TANAMAN DI AIR DAN DIATAS LILYPAD, MENGHILANGKAN KEDUA TANAMAN
     */
    public void digPlant(){
        int playerTileX = worldX/gp.getTileSize();
        int playerTileY = worldY/gp.getTileSize();

        //DEBUG
//        System.out.println("Player : " + playerTileX + ", " + playerTileY);

        // Menghapus semua plant yang berada pada tile worldX, worldY
        gp.plant.removeIf(p -> (p.worldX/gp.getTileSize()) == playerTileX && (p.worldY/gp.getTileSize()) == playerTileY);
    }

    public void addSun() {
        SecureRandom rand = new SecureRandom();
        if (sunTickCounter == 60) {
            int randInterval = 3 + rand.nextInt(3);
            if (sunTickCounter == randInterval * 60) {
                hasSun += 25;
                sunTickCounter = 0;
            }
        } else {
            sunTickCounter++;
        }
    }

    public void useSun(int cost){
        hasSun -= cost;
    }


    /*
    TODO : SPESIFIKASIKAN ZOMBIE YANG SPAWN DI AIR ATAU GA, KITA CARI DARI generateZombie.
           KITA HARUS BUAT TIMER YANG DIMULAI KETIKA gameState == PlayState dimulai. (set 20 detik sebelum zombie spawn)
           KAYAKNYA PERLU ADA KONDISI IS ZOMBIE AQUATIC JADI KITA BISA SPESIFIKASIKAN KALAU TILE ZOMBIE SPAWN ITU HANYA DI TILE WATER SAJA
           .
           NOTE: WATER TILE ITU DI
           (X >= 15 && X <= 23)
           &&
           (Y >= 8 && Y <= 9)
     */

    //SPAWN THE ZOMBIE
    public void spawnZombies(){
        if(UI.playTime > 20){
            if(zombieTickCounter == 3*60){ //ZOMBIE SPAWN 3 DETIK  SEKALI
                SecureRandom rand = new SecureRandom();
                int row = rand.nextInt(6); //WORLDY COORDINATE
                if(gp.zombie.size() <= 10){
                    gp.assetSetter.setZombie(generateZombie(), 24, row+6); //ZOMBIE CAN'T SPAWN MORE THAN 10
                }
                zombieTickCounter = 0;
            } else {
                zombieTickCounter++;
            }
        }
    }

    //CHOOSE WHAT ZOMBIE TYPE TO SPAWN
    public Entity generateZombie(){
        SecureRandom rand = new SecureRandom();
        int randZombie = rand.nextInt(10);
        return switch (randZombie) {
            case 0 -> new NormalZombie(gp);
            case 1 -> new BucketHeadZombie(gp);
            case 2 -> new YetiZombie(gp);
            case 3 -> new ConeHeadZombie(gp);
            case 4 -> new FootballZombie(gp);
            case 5 -> new DolphinRiderZombie(gp);   //AQUATIC ZOMBIE
            case 6 -> new DuckyTubeZombie(gp);      //AQUATIC ZOMBIE
            case 7 -> new PoleVaultingZombie(gp);
            case 8 -> new ScreenDoorZombie(gp);
            case 9 -> new SnorkelZombie(gp);        //AQUATIC ZOMBIE
            default -> null;
        };
    }

    public void update(){
        addSun();
        spawnZombies();
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
