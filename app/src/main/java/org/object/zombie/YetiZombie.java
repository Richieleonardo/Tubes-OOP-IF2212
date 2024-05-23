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
    public void setAction(){

    }
    public void goBack(){
        direction = "right";
    }

}

