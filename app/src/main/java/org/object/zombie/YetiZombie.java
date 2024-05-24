package org.object.zombie;

import org.Entity.Entity;
import org.main.GamePanel;

public class YetiZombie extends Zombie implements Escape{
    public YetiZombie(GamePanel gp) {
        super(gp, "Yeti Zombie", 400, 1, 200, 1);
        description = "YetiZombie adalah zombie yang mempunyai kemampuan untuk Escape.";
        entityDamage = getAttackDamage();
        direction = "left";
        getImage();
    }
    public void getImage() {

        left1 = setup("/zombie/YetiZombie_Left.png");
        left2 = setup("/zombie/YetiZombie_Left.png");
        right1 = setup("/zombie/YetiZombie_Right.png");
        right2 = setup("/zombie/YetiZombie_Right.png");
    }

    public void goBack(){
        direction = "right";
        frameCounter++;
        if(collisionOn == false) {
            if (frameCounter > 60) {
                worldX += (int) (speed + 15.00);
                frameCounter = 0;

            }
        }
    }
    @Override
    public void update(){

//        System.out.println("Zombie health : " + this.Health);
        collisionOn = false;
        gp.collisionChecker.checkTile(this);

        //Implement collision with plant
        int Index = gp.collisionChecker.checkEntity(this, gp.plant);
        if(canAttack){
            attackPlant(Index);
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
                if(this.getHealth() > 350) {
                    worldX -= (int) (speed + 5.00);
                    frameCounter = 0;
                } else {
                    goBack();
                }
            }
        }

    }

}

