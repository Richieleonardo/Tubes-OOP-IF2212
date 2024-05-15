package src.object.zombie;

import src.Entity.Entity;
import src.main.GamePanel;
import java.util.Random;

public class NormalZombie extends Entity {

    public NormalZombie(GamePanel gp) {
        super(gp);
        name = "NormalZombie";
        speed = 1;
        maxHealth = 100;
        Health = maxHealth;

        getImage();
    }

    public void getImage(){
        up1 = setup("/zombie/NormalZombie.png");
        up2 = setup("/zombie/NormalZombie.png");
        down1 = setup("/zombie/NormalZombie.png");
        down2 = setup("/zombie/NormalZombie.png");
        left1 = setup("/zombie/NormalZombie.png");
        left2 = setup("/zombie/NormalZombie.png");
        right1 = setup("/zombie/NormalZombie.png");
        right2 = setup("/zombie/NormalZombie.png");;
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
