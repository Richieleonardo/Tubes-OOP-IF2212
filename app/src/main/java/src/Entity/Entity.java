package src.Entity;

import java.awt.image.BufferedImage;

//Super class entity dalam game
public class Entity {
    public int x ,y;
    public int speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;//Store image file
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
}
