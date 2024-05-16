package src.object.zombie;

import src.Entity.Entity;
import src.main.GamePanel;

import java.util.Random;

public class Cat extends Entity {

    public Cat(GamePanel gp) {
        super(gp);
        name = "Cat";
        speed = 1;
        maxHealth = 100;
        Health = maxHealth;

        getImage();
    }

    public void getImage(){
        up1 = setup("/objects/Cat_Orange.png");
        up2 = setup("/objects/Cat_Orange.png");
        down1 = setup("/objects/Cat_Orange.png");
        down2 = setup("/objects/Cat_Orange.png");
        left1 = setup("/objects/Cat_Orange.png");
        left2 = setup("/objects/Cat_Orange.png");
        right1 = setup("/objects/Cat_Orange.png");
        right2 = setup("/objects/Cat_Orange.png");;
    }

    public void setAction(){

        tickCounter++;

        if(tickCounter == 120){
            Random random = new Random();
            int i = random.nextInt(100) +1; //pick up a number from 1 to 100

            if(i <= 25){
                direction = "up";
            }
            if(i > 25 && i <= 50){
                direction = "down";
            }
            if(i > 50 && i <= 75){
                direction = "left";
            }
            if(i > 75 && i <= 100){
                direction = "right";
            }

            tickCounter = 0;
        }
    }
}
