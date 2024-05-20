package org.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    public boolean checkDrawTime = false;

    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); //return number key that was pressed
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

        //INVENTORY STATE
        if(code == KeyEvent.VK_I){
            if(gp.gameState == gp.playState){
                gp.gameState = gp.inventoryState;
            }
            else if(gp.gameState == gp.inventoryState){
                gp.gameState = gp.playState;
            }
        }

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
                gp.gameState = 0;
            }
            if(code == KeyEvent.VK_1){
                gp.gameState = 1;
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
    }
}
