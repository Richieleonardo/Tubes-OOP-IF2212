package org.object.zombie;

import org.Entity.Entity;
import org.main.GamePanel;

import java.util.Random;

public class DolphinRiderZombie extends Zombie implements Jump{
    static boolean hasJumped = false;
    public DolphinRiderZombie(GamePanel gp) {
        super(gp, "Dolphin Rider Zombie", 175, 1, 100, 1);
        description = "DolphinRiderZombie adalah zombie aquatic yang dapat melompati Plant sebanyak 1 kali.";
        entityDamage = getAttackDamage();
        setIsAquatic(true);
        direction = "left";
        getImage();
    }
    public void getImage() {
        //TODO
        left1 = setup("/zombie/DolphinRiderZombie.png");


    }
    public void setAction(){

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
                if(collisionOn) {
                    jump();
                    attackPlant(Index);
                    hasJumped = true;
                } else {attackPlant(Index);}
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

