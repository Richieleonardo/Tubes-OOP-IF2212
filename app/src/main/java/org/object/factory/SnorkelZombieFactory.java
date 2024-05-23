package org.object.factory;

import org.Entity.Entity;
import org.main.GamePanel;
import org.object.zombie.SnorkelZombie;

public class SnorkelZombieFactory implements ZombieFactory{
    @Override
    public Entity createZombie(GamePanel gp) {
        return new SnorkelZombie(gp);
    }
}
