package org.object.factory;

import org.Entity.Entity;
import org.main.GamePanel;
import org.object.zombie.FootballZombie;

public class FootballZombieFactory implements ZombieFactory{
    @Override
    public Entity createZombie(GamePanel gp) {
        return new FootballZombie(gp);
    }
}
