/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PlayerBase;

import MainPackage.GamePanel;
import UI.InformationBoxUI;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author richa
 */
public class Shop {
    GamePanel gamepanel;
    protected int positionX, positionY;
    protected int bannerHeight, bannerWidth;
    protected final int borderSize = 8;
    
    
    //ITEMS AND BUILD
    ArrayList<Item> items;
    public Shop(GamePanel gamepanel){
        this.gamepanel = gamepanel;
        bannerHeight = gamepanel.screenHeight - gamepanel.tileSize * 4;
        bannerWidth = bannerHeight;
        positionX = gamepanel.screenWidth / 2 - bannerWidth / 2;
        positionY = gamepanel.screenHeight / 2 - bannerHeight / 2;
    }
    
    public void draw(Graphics2D g2){
        g2.setColor(new Color(222,139,43));
        g2.fillRect(positionX, positionY, bannerWidth, bannerHeight);
        
        g2.setStroke(new BasicStroke(borderSize));
        g2.setColor(new Color(154,62,51));
        g2.drawRect(positionX, positionY, bannerWidth, bannerHeight);
        // DRAW HEADER
        drawHeader(g2);
    }
    public void drawHeader(Graphics2D g2){
        BufferedImage image = null;
        InputStream inputstream = getClass().getResourceAsStream("/assets/font/Merriweather-Regular.ttf");
        Font customFont = null;
        Color fontColor = null;
        
        try { 
            customFont = Font.createFont(Font.TRUETYPE_FONT, inputstream);
            fontColor = new Color(0,0,0);
        } catch (FontFormatException ex) {
            Logger.getLogger(InformationBoxUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InformationBoxUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            image  = ImageIO.read(getClass().getResourceAsStream("/assets/banner/banner.png"));
        } catch (IOException ex) {
            Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int width = bannerWidth - gamepanel.tileSize;
        int height = gamepanel.tileSize;
        int y = positionY - height / 2;
        int x = positionX + bannerWidth / 2 - width / 2;
        
        g2.drawImage(image, x, y, width, height, null);
        
        String headerText = "UPGRADE ITEMS & BUILD";
        g2.setFont(customFont);
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20));
        y = y + height / 2 - g2.getFontMetrics().getHeight() / 2 + g2.getFontMetrics().getAscent();
        x = x + width / 2 - (int)g2.getFontMetrics().getStringBounds(headerText, g2).getWidth() / 2;
        g2.drawString(headerText, x, y);
        
        // DRAWCONTENT
        drawContent(g2);
    }
    public void drawContent(Graphics2D g2){
        
    }
    
    public boolean boxPressed(int x, int y){
        if(x > positionX && x < positionX + bannerWidth){
            if(y > positionY && y < positionY + bannerHeight){
                return true;
            }
        }
        return false;
    }
}
