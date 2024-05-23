package org.object.factory;

import org.Entity.Entity;
import org.main.GamePanel;
import org.object.zombie.ConeHeadZombie;

public class ConeHeadZombieFactory implements ZombieFactory{
    @Override
    public Entity createZombie(GamePanel gp) {
        return new ConeHeadZombie(gp);
    }
}
