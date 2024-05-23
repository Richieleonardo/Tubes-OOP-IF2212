package org.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    public boolean checkDrawTime = false;

    //SWAP PLANT
    public boolean pressedCtrl = false;
    public boolean pressedR = false;

    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); //return number key that was pressed

        //PLAY STATE
        if(gp.gameState == gp.playState){
            if(code == KeyEvent.VK_W){
                upPressed = true;
            }
            if(code == KeyEvent.VK_S){
                downPressed = true;
            }
            if(code == KeyEvent.VK_A){
                leftPressed = true;
            }
            if(code == KeyEvent.VK_D){
                rightPressed = true;
            }
            if(code == KeyEvent.VK_Z){
                if(gp.ui.slotColDeck != 0){
                    gp.ui.slotColDeck--;
                }
            }
            if(code == KeyEvent.VK_X){
                if(gp.ui.slotColDeck != 5){
                    gp.ui.slotColDeck++;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                //PLANT ITEMS
                gp.player.putPlant();
            }
            if(code == KeyEvent.VK_BACK_SPACE){
                //PLANT ITEMS
                gp.player.digPlant();
            }
        }

        //ZOMBIES LIST STATE
        if(gp.gameState == gp.ListZombiesState){
            if(code == KeyEvent.VK_W){
                if(gp.ui.slotRowInv != 0){
                    gp.ui.slotRowInv--;
                }

            }
            if(code == KeyEvent.VK_S){
                if(gp.ui.slotRowInv != 1){
                    gp.ui.slotRowInv++;
                }
            }
            if(code == KeyEvent.VK_A){
                if(gp.ui.slotColInv != 0) {
                    gp.ui.slotColInv--;
                }
            }
            if(code == KeyEvent.VK_D){
                if(gp.ui.slotColInv != 4){
                    gp.ui.slotColInv++;
                }
            }
            if(code == KeyEvent.VK_ESCAPE) {
                gp.gameState = 0;
            }
        }

        //PLANTS LIST STATE
        if(gp.gameState == gp.ListPlantState){
            if(code == KeyEvent.VK_W){
                if(gp.ui.slotRowInv != 0){
                    gp.ui.slotRowInv--;
                }

            }
            if(code == KeyEvent.VK_S){
                if(gp.ui.slotRowInv != 1){
                    gp.ui.slotRowInv++;
                }
            }
            if(code == KeyEvent.VK_A){
                if(gp.ui.slotColInv != 0) {
                    gp.ui.slotColInv--;
                }
            }
            if(code == KeyEvent.VK_D){
                if(gp.ui.slotColInv != 4){
                    gp.ui.slotColInv++;
                }
            }
            if(code == KeyEvent.VK_ESCAPE) {
                gp.gameState = 0;
            }
        }

        //HELP STATE
        if(gp.gameState == gp.HelpState){
            if(code == KeyEvent.VK_ESCAPE) {
                gp.gameState = 0;
            }
        }


        //END STATE
        if(gp.gameState == gp.endState){
            if(code == KeyEvent.VK_ESCAPE) {
                gp.ui.gameFinishedWin = false;
                gp.ui.gameFinishedLose = false;
                UI.playTime = 0;
                gp.player.deck.clear();
                gp.zombie.clear();
                gp.gameState = gp.titleState;
            }
        }

        //TITLE STATE
        if(gp.gameState == gp.titleState){
            if(code == KeyEvent.VK_W){
                gp.ui.commandNum--;
                if(gp.ui.commandNum < 0){
                    gp.ui.commandNum = 4;
                }
            }
            if(code == KeyEvent.VK_S){
                gp.ui.commandNum++;
                if(gp.ui.commandNum > 4){
                    gp.ui.commandNum = 0;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                if(gp.ui.commandNum == 0){
                    gp.gameState = gp.inventoryState;
                }
                if(gp.ui.commandNum == 1){
                    gp.gameState = gp.HelpState;
                }
                if(gp.ui.commandNum == 2){
                    gp.gameState = gp.ListPlantState;
                }
                if(gp.ui.commandNum == 3){
                    gp.gameState = gp.ListZombiesState;
                }
                if(gp.ui.commandNum == 4){
                    System.exit(0);
                }
            }
        }

        //PAUSE STATE
        if(code == KeyEvent.VK_P){ //SHORTCUT KEY FOR GAME STATE (EXAMPLE)
            if(gp.gameState == gp.playState){
                gp.gameState = gp.pauseState;
            }
            else if(gp.gameState == gp.pauseState){
                gp.gameState = gp.playState;
            }

        }


        //CHANGE CURSOR DRAW BETWEEN DECK AND INVENTORY
        if(code == KeyEvent.VK_C){ //SHORTCUT KEY FOR GAME STATE (EXAMPLE)
            if(gp.gameState == gp.inventoryState){
                gp.gameState = gp.deckState;
            }
            else if(gp.gameState == gp.deckState){
                gp.gameState = gp.inventoryState;
            }

        }

        //INVENTORY STATE
        if(gp.gameState == gp.inventoryState){
            //DO SOMETHING
            if(code == KeyEvent.VK_W){
                if(gp.ui.slotRowInv != 0){
                    gp.ui.slotRowInv--;
                }

            }
            if(code == KeyEvent.VK_S){
                if(gp.ui.slotRowInv != 1){
                    gp.ui.slotRowInv++;
                }
            }
            if(code == KeyEvent.VK_A){
                if(gp.ui.slotColInv != 0) {
                    gp.ui.slotColInv--;
                }
            }
            if(code == KeyEvent.VK_D){
                if(gp.ui.slotColInv != 4){
                    gp.ui.slotColInv++;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                gp.player.selectPlant();
            }
            if(code == KeyEvent.VK_ESCAPE){
                gp.gameState = gp.titleState;
            }
            if(code == KeyEvent.VK_1){
                if(gp.player.deck.size() == 6){
                    gp.gameState = gp.playState;
                }
                else{
                    System.out.println("Plant harus 6 untuk memulai permainan!");
                }
            }
        }

        //DECK STATE
        if(gp.gameState == gp.deckState){
            if(code == KeyEvent.VK_Z){
                if(gp.ui.slotColDeck != 0){
                    gp.ui.slotColDeck--;
                }
            }
            if(code == KeyEvent.VK_X){
                if(gp.ui.slotColDeck != 5){
                    gp.ui.slotColDeck++;
                }
            }
        }

        if(code == KeyEvent.VK_2){
            if(gp.gameState == gp.inventoryState || gp.gameState == gp.deckState){
                gp.gameState = gp.swapStateInv;
//                System.out.println("Change State " + gp.gameState);
            }
            else if(gp.gameState == gp.swapStateInv){ //Always comeback to inventory state after swap
                gp.gameState = gp.inventoryState;
//                System.out.println("Change State " + gp.gameState);
            }
        }

        if(code == KeyEvent.VK_3){
            if(gp.gameState == gp.inventoryState){
                gp.gameState = gp.swapStateDeck;
                System.out.println("Change State " + gp.gameState);
            }
            else if(gp.gameState == gp.swapStateDeck){ //Always comeback to inventory state after swap
                gp.gameState = gp.inventoryState;
                System.out.println("Change State " + gp.gameState);
            }
        }

        //SWAP STATE
        if(gp.gameState == gp.swapStateInv){
            if(code == KeyEvent.VK_W){
                if(gp.ui.slotRowInv != 0){
                    gp.ui.slotRowInv--;
                }

            }
            if(code == KeyEvent.VK_S){
                if(gp.ui.slotRowInv != 1){
                    gp.ui.slotRowInv++;
                }
            }
            if(code == KeyEvent.VK_A){
                if(gp.ui.slotColInv != 0) {
                    gp.ui.slotColInv--;
                }
            }
            if(code == KeyEvent.VK_D){
                if(gp.ui.slotColInv != 4){
                    gp.ui.slotColInv++;
                }
            }
            if(code == KeyEvent.VK_CONTROL){
                pressedCtrl = true;
            }
            if(code == KeyEvent.VK_R){
                pressedR = true;
            }
        }
        if(gp.gameState == gp.swapStateDeck){
            if(code == KeyEvent.VK_Z){
                if(gp.ui.slotColDeck != 0){
                    gp.ui.slotColDeck--;
                }
            }
            if(code == KeyEvent.VK_X){
                if(gp.ui.slotColDeck != 5){
                    gp.ui.slotColDeck++;
                }
            }
            if(code == KeyEvent.VK_CONTROL){
                pressedCtrl = true;
            }
            if(code == KeyEvent.VK_R){
                pressedR = true;
            }
        }


        //DEBUG
        if(code == KeyEvent.VK_T){
            if(checkDrawTime == false){
                checkDrawTime = true;
            }
            else if(checkDrawTime == true){
                checkDrawTime = false;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_S){
            downPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
        if(code == KeyEvent.VK_CONTROL){
            pressedCtrl = false;
        }
//        if(code == KeyEvent.VK_R){
//            pressedR = false;
//        }
    }
}
