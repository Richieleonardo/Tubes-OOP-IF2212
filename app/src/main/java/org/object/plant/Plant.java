package org.object.plant;

import org.Entity.Entity;
import org.Entity.Projectile;
import org.main.GamePanel;

public abstract class Plant extends Entity {
    private int cost;
    private int health;
    private int attack_damage;
    private int attack_speed;
    private int range;
    private int cooldown;
    private boolean isAquatic;


    //Projectile
    public Projectile projectile;
    public boolean canAttack = true;
    public int attack_counter  = 0;

    public Plant(GamePanel gp, String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown, boolean isAquatic) {
        super(gp);
        this.name = name;
        this.cost = cost;
        this.maxHealth = health;
        Health = maxHealth;
        this.attack_damage = attack_damage;
        this.attack_speed = attack_speed;
        if(range == -1){
            this.range = range;
        }
        else{
            this.range = range * 48;
        }
        this.cooldown = cooldown;
        this.isAquatic = isAquatic;
    }

    public String getName() {
        return this.name;
    }

    public int getCost() {
        return this.cost;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getAttackDamage() {
        return this.attack_damage;
    }

    public int getAttack_Speed() {
        return this.attack_speed;
    }

    public int getRange() {
        return this.range;
    }

    public int getCooldown() {
        return this.cooldown;
    }

    public boolean getIsAquatic(){
        return isAquatic;
    }

    public void setIsAquatic(boolean isAquatic){
        this.isAquatic = isAquatic;
    }

    public void die() {
    }

    public void Shoot(){
            // PROJECTILE GENERATE ONLY WHEN THE OTHER IS NOT ALIVE
            if (!canAttack) {
                attack_counter++;
                if (attack_counter == 60 * getAttack_Speed()) {
                    canAttack = true;
                    attack_counter = 0;
                }
                return;
            }

            if (getRange() == -1) {
                if (!projectile.alive) {
                    projectile.set(worldX, worldY, direction, true, this);
                    // ADD PROJECTILE TO LIST
                    gp.projectileList.add(projectile);
                }
            } else {
                for (Entity zombie : gp.zombie) {
                    if (zombie == null || zombie.worldY != this.worldY) {
                        continue;
                    }

                    int distance = zombie.worldX - worldX;
                    if (distance <= getRange() && !projectile.alive) {
                        projectile.set(worldX, worldY, direction, true, this);
                        // ADD PROJECTILE TO LIST
                        gp.projectileList.add(projectile);
                        break;
                    }
                }
            }

            canAttack = false;
    }

    public void attackZombie(int i){
        if(i != 999){
            gp.zombie[i].Health -= attack_damage;

            if(gp.zombie[i].Health <= 0){
                gp.zombie[i] = null;
            }
        }
    }


    public String toString() {
        return this.name;
    }
}
