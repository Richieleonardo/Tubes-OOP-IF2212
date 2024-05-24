package org.object.zombie;

import org.Entity.Entity;
import org.main.GamePanel;

import java.util.Random;

public class SnorkelZombie extends Zombie {
    static boolean hasJumped;
    public SnorkelZombie(GamePanel gp) {
        super(gp, "Snorkel Zombie", 100, 4, 100, 1);
        description = "SnorkelZombie adalah zombie aquatic dengan kemampuan menyelam.";
        entityDamage = getAttackDamage();
        direction = "left";
        getImage();
    }
    public void getImage() {
        //TODO
        left1 = setup("/zombie/SnorkelZombie.png");


    }

    public void jump(){
        this.worldX -=144;
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
                jump();
                attackPlant(Index);
                hasJumped = true;
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

