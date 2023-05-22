/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import MainPackage.GamePanel;
import PlayerBase.Item;
import java.awt.*;
import static java.awt.SystemColor.text;
import java.io.IOException;
import java.io.InputStream;
import java.security.spec.NamedParameterSpec;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author richa
 */
public class InformationBoxUI extends UIBox{
    protected int borderSize;
    protected Color backgroundColor;
    protected Color borderColor;
    protected Font customFont;
    protected Color fontColor;
    
    protected int margin;
    
    public InformationBoxUI(GamePanel gamepanel){
        this.gamepanel = gamepanel;
        this.margin = gamepanel.tileSize;
        
        // SETUP BANNER HEIGHT, WIDTH, START POSITION & BORDER SIZE
        bannerHeight = gamepanel.tileSize;
        bannerWidth = gamepanel.screenWidth;
        PositionX = 0;
        PositionY = gamepanel.screenHeight - gamepanel.tileSize;
        borderSize = 6;
        // ==========================================
        // SET COLOR BACKGROUND & BORDER
        backgroundColor = new Color(51, 31, 16);
        borderColor = new Color(139, 69, 19);
        
        // SET FONT
        InputStream inputstream = getClass().getResourceAsStream("/assets/font/Merriweather-Regular.ttf");
        try { 
            customFont = Font.createFont(Font.TRUETYPE_FONT, inputstream);
            fontColor = new Color(254,254,204);
        } catch (FontFormatException ex) {
            Logger.getLogger(InformationBoxUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InformationBoxUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void draw(Graphics2D g2, String stage, ArrayList<Item> items){
        g2.setColor(backgroundColor);
        g2.fillRect(PositionX, PositionY, bannerWidth, bannerHeight);
        
        g2.setStroke(new BasicStroke(borderSize));
        g2.setColor(borderColor);
        g2.drawRect(PositionX, PositionY, bannerWidth, bannerHeight);
        
        int x, y, textLength, height, width;
        
        // DRAW STAGE TEXT
        g2.setFont(customFont);
        g2.setColor(fontColor);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 30));
        
        textLength = (int)g2.getFontMetrics().getStringBounds(stage, g2).getWidth();
        x = bannerWidth / 2 - textLength / 2;
        y = gamepanel.arenaScreenRow * gamepanel.tileSize + (bannerHeight / 2 - g2.getFontMetrics().getHeight() / 2) + g2.getFontMetrics().getAscent();
        // y = Arena_height + bannerheight/2 - textheight/2;
        g2.drawString(stage, x, y);
        
        // DRAW ITEMS
        height = bannerHeight - 2 * borderSize - 6;
        width = height;
        x = x + textLength + margin / 2;
        y = gamepanel.arenaScreenRow * gamepanel.tileSize + bannerHeight / 2 - height / 2;
        
        for(int i = 0; i < items.size(); i++){
            g2.drawImage(items.get(i).getLogo(), x, y, width, height, null);
            
            x += width + 2; // MARGIN 2 PX
            String itemText = "LV " + String.valueOf(items.get(i).getLevel()); // SET ITEM INFORMATION TEXT
            
            // === DRAW ITEM INFORMATION TEXT (LEVEL INFORMATION) === 
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 16));
            // info arg : itemtext, x , y+fontascent
            g2.drawString(itemText, x, y + g2.getFontMetrics().getAscent());
            
            // === DRAW ITEM INFORMATION TEXT (COOLDOWN INFORMATION) ===
            itemText = "CD " + String.valueOf(items.get(i).getCooldown()); // RESET INFORMATION TEXT
            // info arg : itemtext, x, font_height+y
            g2.drawString(itemText, x, (y + g2.getFontMetrics().getAscent() + g2.getFontMetrics().getHeight()));
            
            x += (int)g2.getFontMetrics().getStringBounds(itemText, g2).getWidth() + 10;
        }
    }
    
}
