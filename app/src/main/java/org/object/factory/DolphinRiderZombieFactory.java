package org.object.factory;

import org.Entity.Entity;
import org.main.GamePanel;
import org.object.zombie.DolphinRiderZombie;

public class DolphinRiderZombieFactory implements ZombieFactory {

    @Override
    public Entity createZombie(GamePanel gp) {
        return new DolphinRiderZombie(gp);
    }
}
