/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;
import MainPackage.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author richa
 */
public class Player extends Character{
    GamePanel gamepanel;
    KeyHandler keyhandler;
    
    public Player(GamePanel gamepanel, KeyHandler keyhandler){
        this.gamepanel = gamepanel;
        this.keyhandler = keyhandler;
        setupDefaultPlayer();
        getPlayerImage();
    }
    private void setupDefaultPlayer(){
        posX = 100;
        posY = 100;
        characterSpeed = 4;
    }
    public void getPlayerImage() {
        // defautl direction
        direction = "left";
        
        try{
            for(int x = 0; x < 6; x++){
                walkright.add(ImageIO.read(getClass().getResourceAsStream("/assets/player/walk"+(x+1)+".png")));
                walkleft.add(ImageIO.read(getClass().getResourceAsStream("/assets/player/walkleft"+(x+1)+".png")));
                idle.add(ImageIO.read(getClass().getResourceAsStream("/assets/player/idle"+(x+1)+".png")));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    // update draw
    public void update(){
        if(keyhandler.up == true){
            moveUp();
        }else if(keyhandler.down == true){
            moveDown();
        }else if(keyhandler.left == true){
            moveLeft();
        }else if(keyhandler.right == true){
            moveRight();
        }else{
            direction = "idle";
        }
        
        spriteCounter++;
        if(spriteCounter > 10){
            if(spriteIndex == 5){
                spriteIndex = 0;
            }else{
                spriteIndex++;
            }
            spriteCounter = 0;
        }
    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;
        
        if(direction.equals("up")){
            image = walkleft.get(spriteIndex);
        }else if(direction.equals("down")){
            image = walkright.get(spriteIndex);
        }else if(direction.equals("left")){
            image = walkleft.get(spriteIndex);
        }else if(direction.equals("right")){
            image = walkright.get(spriteIndex);
        }else if(direction.equals("idle")){
            image = idle.get(spriteIndex);
        }
        
        g2.drawImage(image, posX, posY, gamepanel.tileSize, gamepanel.tileSize, null);
    }
}
