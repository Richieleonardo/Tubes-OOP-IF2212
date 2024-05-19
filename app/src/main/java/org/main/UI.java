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
    public final int inventorySize = 10;

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
        g2.setFont(new Font("arial_40", Font.BOLD, 26));
        Font header1 = new Font("Arial", Font.BOLD, 26);
        Font header2 = new Font("Arial", Font.PLAIN, 20);
        g2.setFont(header1);
        g2.drawString(text1, gp.getTileSize(), gp.getTileSize()*7);
        g2.setFont(header2);
        g2.drawString(text2, gp.getTileSize(), gp.getTileSize()*7 + 30);
        g2.drawString(text3, gp.getTileSize(), gp.getTileSize()*8);
        g2.drawString(text4, gp.getTileSize(), gp.getTileSize()*8 + 20);
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
