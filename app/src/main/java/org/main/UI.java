package org.main;

import org.object.pellet.SunParticle;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

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

    public UI(GamePanel gp){
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        SunParticle sun = new SunParticle(gp);
        sunImage = sun.image;
    }

//    public void showMessage(String text){
//
//        message = text;
//        messageOn = true;
//    }
    public void drawInventory(){
        int frameX = gp.getTileSize()/2;
        int frameY = gp.getTileSize() * 3;
        int frameWidht = gp.getTileSize() * 12;
        int frameHeight = gp.getTileSize() * 3;

        drawSubWindow(frameX, frameY, frameWidht, frameHeight);

    }

    public void drawDeck(){
        int x = gp.getTileSize()/2;
        int y = 10;
        int width = gp.screenWidth - (gp.getTileSize() * 4);
        int height = gp.getTileSize() * 2;

        drawSubWindow(x, y, width, height);
    }

    public void drawSubWindow(int x, int y, int width, int height){
        //WINDOW
        Color c = new Color(0,0,0);

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
