/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author richa
 */
public class Character {
    public int posX, posY;
    public int characterSpeed;
    public ArrayList<BufferedImage> walk = new ArrayList<>();
    public String direction;
    
    public int spriteIndex = 0;
    public int spriteCounter = 0;
    
    public void moveUp(){
        direction = "up";
        posY -= characterSpeed;
    }
    public void moveDown(){
        direction = "down";
        posY += characterSpeed;
    }
    public void moveLeft(){
        direction = "left";
        posX -= characterSpeed;
    }
    public void moveRight(){
        direction = "right";
        posX += characterSpeed;
    }
}
