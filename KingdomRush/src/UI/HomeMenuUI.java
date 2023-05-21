/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;
import MainPackage.GamePanel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
/**
 *
 * @author richardwei
 */
public class HomeMenuUI {
    GamePanel gamepanel;
    BufferedImage image;
    protected int bannerHeight;
    protected int bannerWidth;
    protected int PositionX;
    protected int PositionY;
    final int margin = 10;
    public HomeMenuUI(GamePanel gamepanel){
        try {
            this.gamepanel = gamepanel;
            image = ImageIO.read(getClass().getResourceAsStream("/assets/mapstile/homebutton.png"));
            
            PositionX = gamepanel.screenWidth - gamepanel.tileSize - margin;
            PositionY = 0 + margin;
            bannerHeight = gamepanel.tileSize;
            bannerWidth = gamepanel.tileSize;
        } catch (IOException ex) {
            Logger.getLogger(HomeMenuUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void draw(Graphics2D g2){
        g2.drawImage(image, PositionX, PositionY, bannerWidth, bannerHeight, null);
    }
    
    public boolean isPressed(int x, int y){
        if(x >= PositionX && x < PositionX + bannerWidth){
            if(y >= PositionY && y < PositionY + bannerHeight){
                if(gamepanel.gameState == gamepanel.playState){
                    return true;
                }
            }
        }
        return false;
    }
}
