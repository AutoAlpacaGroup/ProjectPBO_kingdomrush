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
                walk.add(ImageIO.read(getClass().getResourceAsStream("/assets/player/player"+(x+1)+".png")));
            }
            System.out.println(walk.size());
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
        }
    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;
        
        if(direction == "up"){
            image = walk.get(0);
        }else if(direction == "down"){
            image = walk.get(1);
        }else if(direction == "left"){
            image = walk.get(2);
        }else if(direction == "right"){
            image = walk.get(3);
        }
        
        g2.drawImage(image, posX, posY, gamepanel.tileSize, gamepanel.tileSize, null);
    }
}
