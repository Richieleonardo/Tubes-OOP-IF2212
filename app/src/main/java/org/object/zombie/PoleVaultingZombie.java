package org.object.zombie;

import org.Entity.Entity;
import org.main.GamePanel;

import java.util.Random;

public class PoleVaultingZombie extends Zombie implements Jump{
    static boolean hasJumped = false;
    public PoleVaultingZombie(GamePanel gp) {
        super(gp, "Pole Vaulting Zombie", 175, 1, 100, 1);
        description = "PoleVaultingZombie adalah zombie yang dapat melompati plant sebanyak 1 kali.";
        entityDamage = getAttackDamage();
        direction = "left";
        getImage();
    }
    public void getImage() {
        //TODO
        left1 = setup("/zombie/PoleVaultingZombie.png");
//        left2 = setup("/zombie/.png");
// belum ada png
    }
    public void setAction(){

//        tickCounter++;
//
//        if(tickCounter == 120){
//            Random random = new Random();
//            int i = random.nextInt(100) +1; //pick up a number from 1 to 100
//
//            if(i <= 25){
//                direction = "left";
//                tickCounter = 0;
//            }
//            tickCounter = 0;        }
    }
    public void jump(){
        this.worldX -=60;
        //    super.attackPlant();
    }
    @Override
    public void update(){

//        System.out.println("Zombie health : " + this.Health);
        collisionOn = false;
        gp.collisionChecker.checkTile(this);
        //Implement collision with plant
        int Index = gp.collisionChecker.checkEntity(this, gp.plant);
        if(canAttack){
            if (!hasJumped) {
                if (collisionOn) {
                    jump();
                    attackPlant(Index);
                    hasJumped = true;
                } else {
                    attackPlant(Index);
                }
            }
            else{
                attackPlant(Index);
            }
        }
        else{
            attack_counter++;
            if(attack_counter > (60*getAttack_Speed())){
                canAttack = true;
                attack_counter = 0;
            }
            updateSlow();
        }


        frameCounter++;
        if(collisionOn == false){
            if (frameCounter > 60) {
                worldX -= (int) (speed + 5.00);
                frameCounter = 0;
            }
        }
    }

}

