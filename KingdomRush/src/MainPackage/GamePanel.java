/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
/**
 *
 * @author richa
 */
public class GamePanel extends JPanel implements Runnable{
    final int originalTile = 20;
    final int scale = 2;
    final int tileSize = originalTile * scale;
    
    final int maxScreenCol = 32;
    final int maxScreenRow = 18;
    
    final int screenWidth = tileSize * maxScreenCol; // 1280 px
    final int screenHeight = tileSize * maxScreenRow; // 720 px
    final int playerSpeed = 4;
    
    // FPS
    int fps = 60;
    int posx = 100;
    int posy = 100;
    KeyHandler keyhandler = new KeyHandler();
    Thread gameThread;
    
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        
        // add keyhandler to this panel & focusable to focused to receive keyinputs
        this.addKeyListener(keyhandler);
        this.setFocusable(true);        
    }
    
    // gamethread & run method
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void run(){
        while(gameThread != null){
            update();
            repaint();
            try {
                Thread.sleep(18);
            } catch (InterruptedException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    // update and paint component
    public void update(){
        
        // player movement update
        if(keyhandler.up == true){
            System.out.println("up");
            posy-=playerSpeed;
        }else if(keyhandler.down == true){
            System.out.println("down");
            posy+=playerSpeed;
        }else if(keyhandler.left == true){
            System.out.println("left");
            posx-=playerSpeed;
        }else if(keyhandler.right == true){
            System.out.println("right");
            posx+=playerSpeed;
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.red);
        g2.fillRect(posx, posy, tileSize, tileSize);
        g2.dispose();
    }
}
