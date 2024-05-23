package org.object.factory;

import org.Entity.Entity;
import org.main.GamePanel;

public interface ZombieFactory {
    Entity createZombie(GamePanel gp);
}
