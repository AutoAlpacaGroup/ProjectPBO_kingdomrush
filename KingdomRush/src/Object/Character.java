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
    public ArrayList<BufferedImage> walkright = new ArrayList<>();
    public ArrayList<BufferedImage> walkleft = new ArrayList<>();
    public ArrayList<BufferedImage> idle = new ArrayList<>();
    public String direction;
    
    public int spriteIndex = 0;
    public int spriteCounter = 0;
    
    public void moveUp(){
        direction = "up";
        if(posY-characterSpeed >= 0){
            posY -= characterSpeed;
        }else{
            posY = 0;
        }
    }
    public void moveDown(){
        direction = "down";
        if(posY+characterSpeed <= 720-80){ 
            posY += characterSpeed;
        }else{
            posY = 720-80;
        }
    }
    public void moveLeft(){
        direction = "left";
        if(posX-characterSpeed >= 0){
            posX -= characterSpeed;
        }else{
            posX = 0;
        }
    }
    public void moveRight(){
        direction = "right";
        if(posX+characterSpeed <= 1280-80){ // check if < 1280 (maps dimension) - 80 (tilesize)
            posX += characterSpeed;
        }else{
            posX = 1280-80;
        }
    }
}
