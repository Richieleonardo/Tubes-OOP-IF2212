package org.main;

import org.Entity.Entity;
import org.Entity.Player;
import org.object.pellet.SunParticle;
import org.object.plant.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

import org.object.zombie.*;

public class UI {

    GamePanel gp;
    Graphics2D g2;

    Font arial_40;
    BufferedImage sunImage;
    public boolean messageOn = false;
//    public String message = "";

    //GAME STATUS (Finished/Not Finished)
    boolean gameFinishedWin = false;
    boolean gameFinishedLose = false;
    public static double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    // INVENTORY
    int slotColInv = 0;
    int slotRowInv = 0;

    //DECK
    public int slotColDeck = 0;
    public int slotRowDeck = 0;

    //TEMP
    class TempCursor{
        int tempCol;
        int tempRow;

        public TempCursor(int tempCol, int tempRow){
            this.tempCol = tempCol;
            this.tempRow = tempRow;
        }
    }


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

        //DRAW IF INVENTORY STATE
        if(gp.gameState == gp.inventoryState){
            g2.drawRoundRect(cursorX,cursorY, cursorWidth, cursorHeight, 10, 10);
        }

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

    int cursorCol = 0;
    int cursorRow = 0;
    public void swapPlantInv(){
        int plantIndex1, plantIndex2;

        //GAME CONDITION
        if(gp.keyH.pressedCtrl == true){
            TempCursor tempCursorInv = new TempCursor(slotColInv, slotRowInv);
            cursorCol = tempCursorInv.tempCol;
            cursorRow = tempCursorInv.tempRow;
        }
        if(gp.gameState == gp.swapStateInv){
            int frameX = (gp.getTileSize()/2) + 20;
            int frameY = (gp.getTileSize() * 3) + 20;
            //UNTUK CURSOR NORMAL
            int cursorX = frameX + (gp.getTileSize() * slotColInv);
            int cursorY = frameY + (gp.getTileSize() * slotRowInv);

            //UNTUK CURSOR PILIH
            int cursorXtemp = frameX + (gp.getTileSize() * cursorCol);
            int cursorYtemp = frameY + (gp.getTileSize() * cursorRow);
            int cursorWidth = gp.getTileSize();
            int cursorHeight = gp.getTileSize();

            //DRAW YELLOW CURSOR
            g2.setColor(Color.yellow);
            g2.setStroke(new BasicStroke(3));
            g2.drawRoundRect(cursorXtemp, cursorYtemp, cursorWidth, cursorHeight, 10, 10);

            //DRAW CURSOR
            g2.setColor(Color.white);
            g2.setStroke(new BasicStroke(3));
            g2.drawRoundRect(cursorX,cursorY, cursorWidth, cursorHeight, 10, 10);

            plantIndex1 = cursorCol + (cursorRow * 5);
            plantIndex2 = getPlantIndexOnInventory();

            if(gp.keyH.pressedR == true){
                Collections.swap(inventory, plantIndex1, plantIndex2);
                gp.keyH.pressedR = false;
            }
        }
    }


    public void swapPlantDeck(){
        int plantIndex1, plantIndex2;

        //GAME CONDITION
        if(gp.keyH.pressedCtrl == true){
            TempCursor tempCursorInv = new TempCursor(slotColDeck, slotRowDeck);
            cursorCol = tempCursorInv.tempCol;
            cursorRow = tempCursorInv.tempRow;
        }
        if(gp.gameState == gp.swapStateDeck){
            int frameX = (gp.getTileSize()/2) + 20;
            int frameY = 10 + 20;
            //UNTUK CURSOR NORMAL
            int cursorX = frameX + (gp.getTileSize() * slotColDeck);
            int cursorY = frameY + (gp.getTileSize() * slotRowDeck);

            //UNTUK CURSOR PILIH
            int cursorXtemp = frameX + (gp.getTileSize() * cursorCol);
            int cursorYtemp = frameY + (gp.getTileSize() * cursorRow);
            int cursorWidth = gp.getTileSize();
            int cursorHeight = gp.getTileSize();

            //DRAW YELLOW CURSOR
            g2.setColor(Color.yellow);
            g2.setStroke(new BasicStroke(3));
            g2.drawRoundRect(cursorXtemp, cursorYtemp, cursorWidth, cursorHeight, 10, 10);

            //DRAW CURSOR
            g2.setColor(Color.white);
            g2.setStroke(new BasicStroke(3));
            g2.drawRoundRect(cursorX,cursorY, cursorWidth, cursorHeight, 10, 10);

            plantIndex1 = cursorCol;
            plantIndex2 = getPlantIndexOnDeck();

            if(gp.keyH.pressedR == true){
                Collections.swap(gp.player.deck, plantIndex1, plantIndex2);
                gp.keyH.pressedR = false;
            }
        }
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
            if(gp.player.deck.get(i).isCooldown){
                g2.setFont(g2.getFont().deriveFont(Font.BOLD, 8F));
                String cooldown = "Cooldown";
                g2.drawImage(gp.player.deck.get(i).down2, slotX, slotY, null);
                g2.drawString(cooldown, slotX, slotY+60);
            }
            else if(!gp.player.deck.get(i).isCooldown){
                g2.drawImage(gp.player.deck.get(i).down1, slotX, slotY, null);
            }
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 11F));
            String cost = String.valueOf(gp.player.deck.get(i).getCost());
            g2.drawString(cost, slotX+27, slotY+40);
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

        //DRAW ONLY IF playState or deckState
        if(gp.gameState == gp.playState || gp.gameState == gp.deckState){
            g2.drawRoundRect(cursorX,cursorY, cursorWidth, cursorHeight, 10, 10);
        }

    }


    //DRAW SUB WINDOW round rect
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
            drawSun();
            drawTimer();
        }
        if(gp.gameState == gp.pauseState){
            drawPauseScreen();
        }

        if(gp.gameState == gp.inventoryState){
            drawDeck();
            drawInventory();
        }

        if(gp.gameState == gp.swapStateInv){
            drawDeck();
            drawInventory();
            swapPlantInv();
        }
        if(gp.gameState == gp.swapStateDeck){
            drawDeck();
            drawInventory();
            swapPlantDeck();
        }
        //CHANGE CURSOR POSITION
        if(gp.gameState == gp.deckState){
            drawDeck();
            drawInventory();
        }

        if(gp.gameState == gp.ListPlantState){
            drawListPlant();
        }

        if(gp.gameState == gp.ListZombiesState){
            drawListZombie();
        }

        if(gp.gameState == gp.HelpState){
            drawHelp();
        }

        if(gp.gameState == gp.endState){
            drawEndScreen();
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
            g2.drawImage(inventoryZombie.get(i).left1, slotX, slotY, null);

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

        // DESCRIPTION FRAME
        int dFrameX = gp.getTileSize() + 20;
        int dFrameY = frameY + frameHeight + 20;
        int dFrameWidth = frameWidth*2 + 90;
        int dFrameHeight = gp.getTileSize()*3;
        drawSubWindow(dFrameX, dFrameY, dFrameWidth, dFrameHeight);

        // DRAW DESCRIPTION TEXT
        int textx = dFrameX + 20;
        int texty = dFrameY + gp.getTileSize() + 50;
        g2.setFont(g2.getFont().deriveFont(14F));

        int itemIndex = getItemIndexOnSlot();

        if(itemIndex < inventorySize){
            g2.drawString("Name : " + inventoryZombie.get(itemIndex).name, textx, dFrameY + gp.getTileSize() -10);
            g2.drawString("Health : " + inventoryZombie.get(itemIndex).maxHealth, textx, dFrameY + gp.getTileSize() + 10);
            g2.drawString(inventoryZombie.get(itemIndex).description, textx, texty);
            g2.drawString(inventoryZombie.get(itemIndex).des2, textx, texty + 20);
            g2.drawString("Attack Damage : " + inventoryZombie.get(itemIndex).entityDamage, textx, dFrameY + gp.getTileSize()+ 30);
        }

//        String text2 = "* Tekan tombol Esc ketika ingin kembali ke title screen";
//        String text3 = "* Gunakan WASD untuk memindahkan kursor";
//        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 24F));
//        g2.drawString(text3, gp.getTileSize()*2, gp.getTileSize()*8);
//        g2.drawString(text2, gp.getTileSize()*2, gp.getTileSize()*8 + 20);

    }

    public int getItemIndexOnSlot(){
        int itemIndex = slotColInv + (slotRowInv*5);
        return itemIndex;
    }

    public void drawHelp(){

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Help";
        int x = getXforCenteredText(text);
        int y = gp.getTileSize()*3;

        //SHADOW
        g2.setColor(Color.black);
        g2.drawString(text, x+5, y+5);
        //MAIN COLOR
        g2.setColor(Color.white);
        g2.drawString(text, x, y);

        int frameX = gp.getTileSize()*2 - 20;
        int frameY = gp.getTileSize()*4 - 40;
        int frameWidth = gp.getTileSize() * 14;
        int frameHeight = gp.getTileSize() * 8 + 10;

        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        String text1 = "** TITLE";
        String text2 = " * Gunakan key WS untuk menggerakkan '>' ke atas dan bawah pada layar utama";
        String text3 = " * Gunakan key Enter untuk masuk ke game state yagn dipilih dengan '>'";
        String text4 = "** HELP";
        String text5 = " * Gunakan key Esc untuk kembali ke TITLE";
        String text6 = "** LIST PLANTS";
        String text7 = " * Gunakan key WASD untuk menggerakkan kursor pada list plants";
        String text8 = " * Gunakan key Esc untuk kembali ke TITLE";
        String text9 = "** LIST ZOMBIES";
        String text10 = "** INVENTORY";
        String text11 = " * Gunakan key 1 untuk memulai permainan";
        String text12 = " * Gunakan key WASD untuk menggerakkan kursor pada list zombies";
        String text13 = " * Gunakan key Enter untuk memasukkan plant ke deck atau mengeluarkan tanaman dari deck";
        String text15 = " * Gunakan key C untuk menukar kursor ke deck ataupun inventory";
        String text16 = " * Gunakan key ctrl untuk memilih plant yang ingin diswap dan gunakan key R pada plant target";
        String text17 = "   yang ingin diswap";
        String text18 = "** PLAY";
        String text19 = " * Gunakan key WASD untuk menggerakkan kursor pada map";
        String text20 = " * Gunakan key ZX untuk menggerakkan kursor pada deck";
        String text21 = " * Gunakan key Enter untuk menanam plant";
        String text22 = " * Gunakan key P untuk melakukan pause pada permainan";
        String text23 = " * Gunakan key Backspace untuk menggali tanaman";
        String text24 = "** END";
        String text25 = " * Permainan akan berakhir jika zombie mencapai tile terakhir atau semua zombie dikalahkan";
        String text26 = " * Gunakan key Esc untuk kembali ke TITLE";

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 12F));
        g2.drawString(text1, gp.getTileSize()*2+5, gp.getTileSize()*4 - 17);
        g2.drawString(text2, gp.getTileSize()*2+5, gp.getTileSize()*4 - 5);
        g2.drawString(text3, gp.getTileSize()*2+5, gp.getTileSize()*4 + 7);
        g2.drawString(text4, gp.getTileSize()*2+5, gp.getTileSize()*4 + 24);
        g2.drawString(text5, gp.getTileSize()*2+5, gp.getTileSize()*4 + 36);
        g2.drawString(text6, gp.getTileSize()*2+5, gp.getTileSize()*4 + 53);
        g2.drawString(text7, gp.getTileSize()*2+5, gp.getTileSize()*4 + 65);
        g2.drawString(text8, gp.getTileSize()*2+5, gp.getTileSize()*4 + 77);
        g2.drawString(text9, gp.getTileSize()*2+5, gp.getTileSize()*4 + 94);
        g2.drawString(text12, gp.getTileSize()*2+5, gp.getTileSize()*4 + 106);
        g2.drawString(text8, gp.getTileSize()*2+5, gp.getTileSize()*4 + 118);
        g2.drawString(text10, gp.getTileSize()*2+5, gp.getTileSize()*4 + 135);
        g2.drawString(text7, gp.getTileSize()*2+5, gp.getTileSize()*4 + 147);
        g2.drawString(text11, gp.getTileSize()*2+5, gp.getTileSize()*4 + 159);
        g2.drawString(text13, gp.getTileSize()*2+5, gp.getTileSize()*4 + 171);
        g2.drawString(text8, gp.getTileSize()*2+5, gp.getTileSize()*4 + 183);
        g2.drawString(text15, gp.getTileSize()*2+5, gp.getTileSize()*4 + 195);
        g2.drawString(text16, gp.getTileSize()*2+5, gp.getTileSize()*4 + 207);
        g2.drawString(text17, gp.getTileSize()*2+5, gp.getTileSize()*4 + 219);
        g2.drawString(text18, gp.getTileSize()*2+5, gp.getTileSize()*4 + 236);
        g2.drawString(text19, gp.getTileSize()*2+5, gp.getTileSize()*4 + 248);
        g2.drawString(text20, gp.getTileSize()*2+5, gp.getTileSize()*4 + 260);
        g2.drawString(text21, gp.getTileSize()*2+5, gp.getTileSize()*4 + 272);
        g2.drawString(text22, gp.getTileSize()*2+5, gp.getTileSize()*4 + 284);
        g2.drawString(text23, gp.getTileSize()*2+5, gp.getTileSize()*4 + 296);
        g2.drawString(text24, gp.getTileSize()*2+5, gp.getTileSize()*4 + 313);
        g2.drawString(text25, gp.getTileSize()*2+5, gp.getTileSize()*4 + 325);
        g2.drawString(text26, gp.getTileSize()*2+5, gp.getTileSize()*4 + 337);

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


//        String text2 = "* Tekan tombol Esc ketika ingin kembali ke title screen";
//        String text3 = "* Gunakan WASD untuk memindahkan kursor";
//        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 24F));
//        g2.drawString(text3, gp.getTileSize()*2, gp.getTileSize()*8);
//        g2.drawString(text2, gp.getTileSize()*2, gp.getTileSize()*8 + 20);

        // DESCRIPTION FRAME
        int dFrameX = gp.getTileSize() + 20;
        int dFrameY = frameY + frameHeight + 20;
        int dFrameWidth = frameWidth*2 + 90;
        int dFrameHeight = gp.getTileSize()*3;
        drawSubWindow(dFrameX, dFrameY, dFrameWidth, dFrameHeight);

        // DRAW DESCRIPTION TEXT
        int textx = dFrameX + 20;
        int texty = dFrameY + gp.getTileSize() + 50;
        g2.setFont(g2.getFont().deriveFont(14F));

        int itemIndex = getItemIndexOnSlot();

        if(itemIndex < inventorySize){
            g2.drawString("Name : " + inventory.get(itemIndex).name, textx, dFrameY + gp.getTileSize() -10);
            g2.drawString("Health : " + inventory.get(itemIndex).maxHealth, textx, dFrameY + gp.getTileSize() + 10);
            g2.drawString(inventory.get(itemIndex).description, textx, texty);
            g2.drawString(inventory.get(itemIndex).des2, textx, texty + 20);
            g2.drawString("Attack Damage : " + inventory.get(itemIndex).entityDamage, textx, dFrameY + gp.getTileSize()+ 30);
        }
//        int frameX2 = gp.getTileSize()*2 - 20;
//        int frameY2 = gp.getTileSize()*4 - 40;
//        int frameWidth2 = gp.getTileSize() * 14;
//        int frameHeight2 = gp.getTileSize() * 8;
//
//        drawSubWindow(frameX2, frameY2, frameWidth2, frameHeight2);

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
        g2.drawImage(inventory.getFirst().down1, x, y, gp.getTileSize()*2, gp.getTileSize()*2, null);

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

    public void drawSun(){
        SunParticle sun = new SunParticle(gp);
        int x = gp.getTileSize() * 8;
        int y = 10;
        int width = gp.getTileSize() + (gp.getTileSize()/2);
        int height = gp.getTileSize() * 2;
        drawSubWindow(x, y, width, height);
        g2.drawImage(sun.down1, x+12, y+10, null);
//        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 17F));
//        g2.drawString("x", x+32, y+16+gp.getTileSize());
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 22F));

        g2.drawString(String.valueOf(Player.hasSun), x+17, y+27+gp.getTileSize());
    }

    public void drawPauseScreen(){
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;

        g2.drawString(text, x, y);
    }

    public void drawEndScreen(){
        if(gameFinishedWin){
            String text = "You Win!";
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,80F));
            int x = getXforCenteredText(text);
            int y = gp.getTileSize()*7;
            g2.drawString(text, x, y);
        }
        if(gameFinishedLose){
            String text = "You Lose!";
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,80F));
            int x = getXforCenteredText(text);
            int y = gp.getTileSize()*7;
            g2.drawString(text, x, y);
        }
    }

    public void drawTimer(){
        playTime += (double) 1/60;
        g2.drawString("Time: " + dFormat.format(playTime), gp.getTileSize()*11, 65);
    }

    public int getXforCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }

}
