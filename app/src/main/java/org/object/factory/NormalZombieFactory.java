package org.object.factory;

import org.Entity.Entity;
import org.main.GamePanel;
import org.object.zombie.NormalZombie;

public class NormalZombieFactory implements ZombieFactory {
    @Override
    public Entity createZombie(GamePanel gp) {
        return new NormalZombie(gp);
    }
}
