/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import MainPackage.GamePanel;
import MainPackage.KeyHandler;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author richa
 */
public class Character {
    // POSITION, IMAGE, DIRECTION
    GamePanel gamepanel;
    KeyHandler keyhandler;
    protected ArrayList<BufferedImage> walkright = new ArrayList<>();
    protected ArrayList<BufferedImage> walkleft = new ArrayList<>();
    protected ArrayList<BufferedImage> idle = new ArrayList<>();
    
    protected int posX, posY;
    protected int characterSpeed;
    protected String direction;
    
    // ANIMATION INDEX & COUNTER
    protected int spriteIndex = 0;
    protected int spriteCounter = 0;
    
    // CHARACTER STATUS
    protected boolean alive;
    protected int level;
    // HP
    protected int characterMaxHp;
    protected int characterHp;
    // SHIELD
    protected int maxShield;
    protected int shield;
    // ATTACK
    protected int defaultDamage;
    protected int attackDamage;
    
    
    
    // CONSTRUCTOR
    public Character(GamePanel gamepanel, KeyHandler keyhandler){
        this.gamepanel = gamepanel;
        this.keyhandler = keyhandler;
        alive = false;
        this.level = 1;
        this.characterMaxHp = 100;
        this.characterHp = characterMaxHp;
        
        this.maxShield = 50;
        this.shield = maxShield; 
        
        this.defaultDamage = 10;
        this.attackDamage = defaultDamage;
    }
    
    public int getMaxHp(){
        return this.characterMaxHp;
    }
    public int getHp(){
        return this.characterHp;
    }
    public int getMaxShield(){
        return this.maxShield;
    }
    public int getShield(){
        return this.shield;
    }
    public int getLevel(){
        return level;
    }
}
