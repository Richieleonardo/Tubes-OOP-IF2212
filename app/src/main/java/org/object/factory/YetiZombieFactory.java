package org.object.factory;

import org.Entity.Entity;
import org.main.GamePanel;
import org.object.zombie.YetiZombie;

public class YetiZombieFactory implements ZombieFactory{
    @Override
    public Entity createZombie(GamePanel gp) {
        return new YetiZombie(gp);
    }
}
