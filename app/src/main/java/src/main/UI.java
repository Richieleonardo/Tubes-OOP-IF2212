package src.main;

import src.object.Pea;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {

    GamePanel gp;
    Font arial_40;
    BufferedImage peaImage;
    public boolean messageOn = false;
//    public String message = "";

    boolean gameFinished = false;
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp){
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        Pea pea = new Pea();
        peaImage = pea.image;
    }

//    public void showMessage(String text){
//
//        message = text;
//        messageOn = true;
//    }

    public void draw(Graphics2D g2){

        if(gameFinished == true){
            g2.setFont(arial_40);
            g2.setColor(Color.white);

            String text;
            int textLength;
            int x;
            int y;

            text = "Game finished!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

            x = gp.getScreenWidth()/2 - textLength/2;
            y = gp.getScreenHeight()/2 - (gp.getTileSize()*3);
            g2.drawString(text, x, y);

            gp.gameThread = null;
        }
        else{
            g2.setFont(arial_40);
            g2.setColor(Color.white);
            g2.drawImage(peaImage, gp.getTileSize()/2, gp.getTileSize()/2, gp.getTileSize(), gp.getTileSize(), null);
            g2.drawString("x " + gp.player.hasPea, 70, 54);

            //TIME
            playTime += (double)1/60;

            g2.drawString("Time: " + dFormat.format(playTime), gp.getTileSize()*11, 65);

            //END THE GAME
//            if(playTime > 10.00){
//                gameFinished = true;
//            }
        }

    }
}
