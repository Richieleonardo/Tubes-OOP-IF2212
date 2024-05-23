package org.object.factory;

import org.Entity.Entity;
import org.main.GamePanel;
import org.object.zombie.PoleVaultingZombie;

public class PoleVaultingZombieFactory implements ZombieFactory{
    @Override
    public Entity createZombie(GamePanel gp) {
        return new PoleVaultingZombie(gp);
    }
}
