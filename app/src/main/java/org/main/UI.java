package org.main;

import org.Entity.Entity;
import org.object.pellet.SunParticle;
import org.object.plant.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.Entity.Entity;
import org.object.zombie.*;

public class UI {

    GamePanel gp;
    Graphics2D g2;

    Font arial_40;
    BufferedImage sunImage;
    public boolean messageOn = false;
//    public String message = "";

    boolean gameFinished = false;
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    // INVENTORY
    int slotColInv = 0;
    int slotRowInv = 0;
    public int slotColDeck = 0;
    public int slotRowDeck = 0;
    public ArrayList<Entity> inventory = new ArrayList<>();
    public ArrayList<Entity> inventoryZombie = new ArrayList<>();
    public final int inventorySize = 10;
    public int commandNum = 0;

    public UI(GamePanel gp){
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        SunParticle sun = new SunParticle(gp);
        sunImage = sun.image;
        setItems();
    }

//    public void showMessage(String text){
//
//        message = text;
//        messageOn = true;
//    }

    public void setItems(){
        inventory.add(new Sunflower(gp));
        inventory.add(new Peashooter(gp));
        inventory.add(new SnowPeashooter(gp));
        inventory.add(new Wallnut(gp));
        inventory.add(new Cabbagepult(gp));
        inventory.add(new Kernelpult(gp));
        inventory.add(new Lilypad(gp));
        inventory.add(new Squash(gp));
        inventory.add(new Repeater(gp));
        inventory.add(new Threepeater(gp));
        inventoryZombie.add(new NormalZombie(gp));
        inventoryZombie.add(new ConeHeadZombie(gp));
        inventoryZombie.add(new BucketHeadZombie(gp));
        inventoryZombie.add(new DolphinRiderZombie(gp));
        inventoryZombie.add(new DuckyTubeZombie(gp));
        inventoryZombie.add(new FootballZombie(gp));
        inventoryZombie.add(new PoleVaultingZombie(gp));
        inventoryZombie.add(new ScreenDoorZombie(gp));
        inventoryZombie.add(new SnorkelZombie(gp));
        inventoryZombie.add(new YetiZombie(gp));
    }

    //Maybe useful later
    public int getPlantIndexOnInventory(){
        int plantIndex = slotColInv + (slotRowInv * 5);
        return plantIndex;
    }

    public int getPlantIndexOnDeck(){
        int plantIndex = slotColDeck;
        return plantIndex;
    }

    public void drawInventory(){


        int frameX = gp.getTileSize()/2;
        int frameY = gp.getTileSize() * 3;
        int frameWidth = gp.getTileSize() * 6;
        int frameHeight = gp.getTileSize() * 3;

        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        //SLOT
        final int slotXstart = frameX + 20;
        final int slotYstart = frameY + 20;
        int slotX = slotXstart;
        int slotY = slotYstart;

        //DRAW INVENTORY's ITEMS
        for(int i = 0; i < inventory.size(); i++){
            g2.drawImage(inventory.get(i).down1, slotX, slotY, null);

            slotX += gp.getTileSize();
            if(slotX == 4 || i == 4){
                slotX = slotXstart;
                slotY += gp.getTileSize();
            }
        }

        // CURSOR
        int cursorX = slotXstart + (gp.getTileSize() * slotColInv);
        int cursorY = slotYstart + (gp.getTileSize() * slotRowInv);
        int cursorWidth = gp.getTileSize();
        int cursorHeight = gp.getTileSize();

        //DRAW CURSOR
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(cursorX,cursorY, cursorWidth, cursorHeight, 10, 10);

//        int plantIndex = getPlantIndexOnInventory();
//        if(itemIndex<inventory.size()){
//
//        }
        String text1 = "Silahkan masukkan plant ke dalam deck";
        String text2 = "* Gunakan WASD untuk memindahkan kursor";
        String text3 = "* Ketika ingin menambahkan atau menghapus tanaman";
        String text4 = "  dari deck tekan tombol \"Enter\" di keyboard";
        String text5 = "* Tekan tombol Esc ketika ingin kembali ke title screen";
        String text6 = "* Tekan tombol 1 ketika ingin memulai permainan";
        Font header1 = new Font("Arial", Font.BOLD, 26);
        Font header2 = new Font("Arial", Font.PLAIN, 20);
        g2.setFont(header1);
        g2.drawString(text1, gp.getTileSize(), gp.getTileSize()*7);
        g2.setFont(header2);
        g2.drawString(text2, gp.getTileSize(), gp.getTileSize()*7 + 30);
        g2.drawString(text3, gp.getTileSize(), gp.getTileSize()*8);
        g2.drawString(text4, gp.getTileSize(), gp.getTileSize()*8 + 20);
        g2.drawString(text5, gp.getTileSize(), gp.getTileSize()*8 + 40);
        g2.drawString(text6, gp.getTileSize(), gp.getTileSize()*8 + 60);
    }

    public void drawHeader1(String text, int x, int y){
        Font header1 = new Font("Arial", Font.BOLD, 26);
        g2.drawString(text, x, y);
    }

    public void drawHeader2(String text, int x, int y){
        Font header2 = new Font("Arial", Font.PLAIN, 20);
        g2.drawString(text, x, y);
    }



    public void drawDeck(){
        int x = gp.getTileSize()/2;
        int y = 10;
        int width = gp.getTileSize() * 7;
        int height = gp.getTileSize() * 2;

        drawSubWindow(x, y, width, height);

        //SLOT
        final int slotXstart = x + 20;
        final int slotYstart = y + 20;
        int slotX = slotXstart;
        int slotY = slotYstart;

        //DRAW DECK's ITEMS
        for(int i = 0; i < gp.player.deck.size(); i++){
            g2.drawImage(gp.player.deck.get(i).down1, slotX, slotY, null);

            slotX += gp.getTileSize();
        }


        // CURSOR
        int cursorX = slotXstart + (gp.getTileSize() * slotColDeck);
        int cursorY = slotYstart + (gp.getTileSize() * slotRowDeck);
        int cursorWidth = gp.getTileSize();
        int cursorHeight = gp.getTileSize();

        //DRAW CURSOR
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(3));
        if(gp.gameState == gp.playState){
            g2.drawRoundRect(cursorX,cursorY, cursorWidth, cursorHeight, 10, 10);
        }

    }

    public void drawSubWindow(int x, int y, int width, int height){
        //WINDOW
        Color c = new Color(0,0,0,220);

        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255,255,255);
        g2.setColor(c);
        //BasicStroke untuk ketebalan outline window
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
    }

    public void draw(Graphics2D g2){
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);

        //TITLE STATE
        if(gp.gameState == gp.titleState){
            drawTitleScreen();
        }

        if(gp.gameState == gp.playState){
            //Do playstate stuff
            drawDeck();

        }
        if(gp.gameState == gp.pauseState){
            drawPauseScreen();
        }

        if(gp.gameState == gp.inventoryState){
            drawDeck();
            drawInventory();
        }

        if(gp.gameState == gp.ListPlantState){
            drawListPlant();
        }

        if(gp.gameState == gp.ListZombiesState){
            drawListZombie();
        }

    }

    public void drawListZombie(){
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Zombies List";
        int x = getXforCenteredText(text);
        int y = gp.getTileSize()*3;

        //SHADOW
        g2.setColor(Color.black);
        g2.drawString(text, x+5, y+5);
        //MAIN COLOR
        g2.setColor(Color.white);
        g2.drawString(text, x, y);

        int frameX = gp.getTileSize()*6;
        int frameY = gp.getTileSize()*6 - 80;
        int frameWidth = gp.getTileSize() * 6;
        int frameHeight = gp.getTileSize() * 3;

        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        //SLOT
        final int slotXstart = frameX + 20;
        final int slotYstart = frameY + 20;
        int slotX = slotXstart;
        int slotY = slotYstart;

        //DRAW INVENTORY's ITEMS
        for(int i = 0; i < inventoryZombie.size(); i++){
            g2.drawImage(inventoryZombie.get(i).down1, slotX, slotY, null);

            slotX += gp.getTileSize();
            if(slotX == 4 || i == 4){
                slotX = slotXstart;
                slotY += gp.getTileSize();
            }
        }
        // CURSOR
        int cursorX = slotXstart + (gp.getTileSize() * slotColInv);
        int cursorY = slotYstart + (gp.getTileSize() * slotRowInv);
        int cursorWidth = gp.getTileSize();
        int cursorHeight = gp.getTileSize();

        //DRAW CURSOR
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(cursorX,cursorY, cursorWidth, cursorHeight, 10, 10);


        String text2 = "* Tekan tombol Esc ketika ingin kembali ke title screen";
        String text3 = "* Gunakan WASD untuk memindahkan kursor";
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 24F));
        g2.drawString(text3, gp.getTileSize()*2, gp.getTileSize()*8);
        g2.drawString(text2, gp.getTileSize()*2, gp.getTileSize()*8 + 20);
    }

    public void drawListPlant(){

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Plants List";
        int x = getXforCenteredText(text);
        int y = gp.getTileSize()*3;

        //SHADOW
        g2.setColor(Color.black);
        g2.drawString(text, x+5, y+5);
        //MAIN COLOR
        g2.setColor(Color.white);
        g2.drawString(text, x, y);

        int frameX = gp.getTileSize()*6;
        int frameY = gp.getTileSize()*6 - 80;
        int frameWidth = gp.getTileSize() * 6;
        int frameHeight = gp.getTileSize() * 3;

        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        //SLOT
        final int slotXstart = frameX + 20;
        final int slotYstart = frameY + 20;
        int slotX = slotXstart;
        int slotY = slotYstart;

        //DRAW INVENTORY's ITEMS
        for(int i = 0; i < inventory.size(); i++){
            g2.drawImage(inventory.get(i).down1, slotX, slotY, null);

            slotX += gp.getTileSize();
            if(slotX == 4 || i == 4){
                slotX = slotXstart;
                slotY += gp.getTileSize();
            }
        }
        // CURSOR
        int cursorX = slotXstart + (gp.getTileSize() * slotColInv);
        int cursorY = slotYstart + (gp.getTileSize() * slotRowInv);
        int cursorWidth = gp.getTileSize();
        int cursorHeight = gp.getTileSize();

        //DRAW CURSOR
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(cursorX,cursorY, cursorWidth, cursorHeight, 10, 10);


        String text2 = "* Tekan tombol Esc ketika ingin kembali ke title screen";
        String text3 = "* Gunakan WASD untuk memindahkan kursor";
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 24F));
        g2.drawString(text3, gp.getTileSize()*2, gp.getTileSize()*8);
        g2.drawString(text2, gp.getTileSize()*2, gp.getTileSize()*8 + 20);
    }
    public void drawTitleScreen(){

        g2.setColor(new Color(70,120,80));
        g2.fillRect(0,0, gp.screenWidth, gp.screenHeight);

        //TITLE NAME
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,80F));
        String text = "Michael VS Lalapan";
        int x = getXforCenteredText(text);
        int y = gp.getTileSize()*3;

        //SHADOW
        g2.setColor(Color.black);
        g2.drawString(text, x+5, y+5);
        //MAIN COLOR
        g2.setColor(Color.white);
        g2.drawString(text, x, y);

        //Plant IMAGE
        x = gp.screenWidth/2 - (gp.getTileSize()*2)/2;
        y += gp.getTileSize();
        g2.drawImage(gp.plant.getFirst().down1, x, y, gp.getTileSize()*2, gp.getTileSize()*2, null);

        //MENU
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));

        text = "START";
        x = getXforCenteredText(text);
        y += gp.getTileSize()*3.5;
        g2.drawString(text, x, y);
        if(commandNum == 0) {
            g2.drawString(">", x-gp.getTileSize(), y);
        }

        text = "HELP";
        x = getXforCenteredText(text);
        y += gp.getTileSize();
        g2.drawString(text, x, y);
        if(commandNum == 1) {
            g2.drawString(">", x-gp.getTileSize(), y);
        }

        text = "PLANTS LIST";
        x = getXforCenteredText(text);
        y += gp.getTileSize();
        g2.drawString(text, x, y);
        if(commandNum == 2) {
            g2.drawString(">", x-gp.getTileSize(), y);
        }

        text = "ZOMBIES LIST";
        x = getXforCenteredText(text);
        y += gp.getTileSize();
        g2.drawString(text, x, y);
        if(commandNum == 3) {
            g2.drawString(">", x-gp.getTileSize(), y);
        }

        text = "EXIT";
        x = getXforCenteredText(text);
        y += gp.getTileSize();
        g2.drawString(text, x, y);
        if(commandNum == 4) {
            g2.drawString(">", x-gp.getTileSize(), y);
        }

    }

    public void drawPauseScreen(){
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;

        g2.drawString(text, x, y);
    }

    public int getXforCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }

}
