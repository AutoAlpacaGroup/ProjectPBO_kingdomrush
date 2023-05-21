/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PlayerBase;

import MainPackage.GamePanel;
import java.awt.Graphics2D;

/**
 *
 * @author richa
 */
public class PlayerBase {
    protected GamePanel gamepanel;
    protected int level;
    protected int live;
    protected int coin;
    
    // ICON
    protected Banner coinBanner;
    protected Banner liveBanner;
    
    public PlayerBase(GamePanel gamepanel){
        this.gamepanel = gamepanel;
        this.level = 1;
        this.live = 20;
        this.coin = 1000;
        
        int x = 0;
        int y = 0;
        int width = gamepanel.tileSize;
        int height = gamepanel.tileSize;
        coinBanner = new Banner("/assets/playerbase/coin.png", width, height, x, y, String.valueOf(coin));
        liveBanner = new Banner("/assets/playerbase/live.png", width, height, x, y + gamepanel.tileSize, String.valueOf(live));
    }
    
    public void draw(Graphics2D g2){
        coinBanner.draw(g2);
        liveBanner.draw(g2);
    }
}
