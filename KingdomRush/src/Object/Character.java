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
    protected int posX, posY;
    protected int characterSpeed;
    GamePanel gamepanel;
    KeyHandler keyhandler;
    protected ArrayList<BufferedImage> walkright = new ArrayList<>();
    protected ArrayList<BufferedImage> walkleft = new ArrayList<>();
    protected ArrayList<BufferedImage> idle = new ArrayList<>();
    protected String direction;
    
    // ANIMATION INDEX & COUNTER
    protected int spriteIndex = 0;
    protected int spriteCounter = 0;
    
    // CHARACTER STATUS
    protected int level;
    protected int characterHp;
    protected boolean alive;
    protected int attackDamage;
    
    // CONSTRUCTOR
    public Character(int Hp, GamePanel gamepanel, KeyHandler keyhandler){
        this.gamepanel = gamepanel;
        this.keyhandler = keyhandler;
        alive = false;
        this.characterHp = Hp;
    }
}
