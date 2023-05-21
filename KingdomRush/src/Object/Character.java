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
    public int posX, posY;
    public int characterSpeed;
    GamePanel gamepanel;
    KeyHandler keyhandler;
    public ArrayList<BufferedImage> walkright = new ArrayList<>();
    public ArrayList<BufferedImage> walkleft = new ArrayList<>();
    public ArrayList<BufferedImage> idle = new ArrayList<>();
    public String direction;
    
    // ANIMATION INDEX & COUNTER
    public int spriteIndex = 0;
    public int spriteCounter = 0;
    
    // CHARACTER STATUS
    public int characterHp;
    public boolean alive;
    public int attackDamage;
    
    // CONSTRUCTOR
    public Character(int Hp, GamePanel gamepanel, KeyHandler keyhandler){
        this.gamepanel = gamepanel;
        this.keyhandler = keyhandler;
        alive = false;
        this.characterHp = Hp;
    }
}
