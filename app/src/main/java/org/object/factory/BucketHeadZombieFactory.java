package org.object.factory;

import org.Entity.Entity;
import org.main.GamePanel;
import org.object.zombie.BucketHeadZombie;

public class BucketHeadZombieFactory implements ZombieFactory{
    @Override
    public Entity createZombie(GamePanel gp) {
        return new BucketHeadZombie(gp);
    }
}
