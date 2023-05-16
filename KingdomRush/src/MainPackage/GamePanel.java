/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;
import Object.Player;
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
    final int scale = 4;
    public final int tileSize = originalTile * scale;
    
    final int maxScreenCol = 16;
    final int maxScreenRow = 9;
    
    final int screenWidth = tileSize * maxScreenCol; // 1280 px
    final int screenHeight = tileSize * maxScreenRow; // 720 px
    
    // FPS
    int fps = 60;
    Player player;
    KeyHandler keyhandler = new KeyHandler();
    Thread gameThread;
    
    public GamePanel(){
        player = new Player(this, keyhandler);
        
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
    
    @Override
    public void run(){
        long drawInterval = 1000 / fps; // interval 1 seconds 60 frames (1000 milisceonds / 60)
        long nextDrawTime = System.currentTimeMillis()+ drawInterval;
                
        while(gameThread != null){
            update();
            repaint();
            
            // SET FPS
            try {
                long remainingTime = nextDrawTime - System.currentTimeMillis(); //
                if(remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep(remainingTime);
                nextDrawTime += drawInterval; // set nextdrawtime plus drawinterval
            } catch (InterruptedException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    // update and paint component
    public void update(){
        // player movement update
        player.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        // draw object player
        player.draw(g2);
        g2.dispose();
    }
}
