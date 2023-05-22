/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PlayerBase;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author richa
 */
public class Item {
    protected BufferedImage itemLogo; 
    protected BufferedImage[] animation;
    protected String itemName;
    protected int level;
    protected int cooldown;
    protected int damage;
    
    // BUTTON POSITION
    protected int x, y;
    protected int height, width;
    
    public Item(String logoPath, String animationPath, String name, int damage, int cooldown){
        this.itemName = name;
        this.damage = damage;
        this.level = 1;
        this.cooldown = cooldown;
        animation = new BufferedImage[10];
        
        try {
            // SET ITEM LOGO
            itemLogo = ImageIO.read(getClass().getResourceAsStream(logoPath));
            
            // SET ITEM ANIMATION
            for(int x = 0; x < 10; x++){
                String path = animationPath + String.valueOf((x+1)) + ".png";
                animation[x] = ImageIO.read(getClass().getResourceAsStream(path));
            }
        } catch (IOException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public BufferedImage getLogo(){
        return itemLogo;
    }
    
    public void setButtonPosition(int x, int y, int height, int width){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
    public int getLevel(){
        return level;
    }
    public int getCooldown(){
        return cooldown;
    }
}
