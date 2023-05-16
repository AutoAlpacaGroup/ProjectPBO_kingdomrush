/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
    
    Thread gameThread;
    
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
    }
    
    // gamethread
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void run(){
        while(gameThread != null){
            System.out.println("starting game lop");
            // update
            update();
            
            //repaint
            repaint();
        }
    }
    
    public void update(){
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D)g;
        
        g2.setColor(Color.red);
        g2.fillRect(100, 100, tileSize, tileSize);
        g2.dispose();
    }
}
