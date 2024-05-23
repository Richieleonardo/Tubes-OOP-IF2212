package org.object.factory;

import org.Entity.Entity;
import org.main.GamePanel;
import org.object.zombie.DuckyTubeZombie;

public class DuckyTubeZombieFactory implements ZombieFactory{
    @Override
    public Entity createZombie(GamePanel gp) {
        return new DuckyTubeZombie(gp);
    }
}
