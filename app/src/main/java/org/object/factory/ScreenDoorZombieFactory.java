package org.object.factory;

import org.Entity.Entity;
import org.main.GamePanel;
import org.object.zombie.ScreenDoorZombie;

public class ScreenDoorZombieFactory implements ZombieFactory{
    @Override
    public Entity createZombie(GamePanel gp) {
        return new ScreenDoorZombie(gp);
    }
}
