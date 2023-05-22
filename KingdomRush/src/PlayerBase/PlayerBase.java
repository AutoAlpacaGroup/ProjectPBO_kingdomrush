/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PlayerBase;

import MainPackage.GamePanel;
import Object.Player;
import UI.InformationBoxUI;
import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author richa
 */
public class PlayerBase {
    protected GamePanel gamepanel;
    protected Player player;
    protected int stage;
    protected int live;
    protected int coin;
    protected InformationBoxUI informationBoxUI;
    
    //ITEMS
    ArrayList<Item> items = new ArrayList<>();
    
    // ICON
    protected Banner coinBanner;
    protected Banner liveBanner;
    
    public PlayerBase(GamePanel gamepanel, Player player){
        this.gamepanel = gamepanel;
        this.player = player;
        this.stage = 1;
        this.live = 20;
        this.coin = 1000;
        
        int x = 0;
        int y = 0;
        int width = gamepanel.tileSize;
        int height = gamepanel.tileSize;
        informationBoxUI = new InformationBoxUI(gamepanel);
        coinBanner = new Banner("/assets/playerbase/coin.png", width, height, x, y, String.valueOf(coin));
        liveBanner = new Banner("/assets/playerbase/live.png", width, height, x, y + gamepanel.tileSize, String.valueOf(live));
        
        // ADD ITEMS
        int size = gamepanel.tileSize - 20;
        addItem("/assets/effect/logo/bomb.png", "/assets/effect/animation/Circle_explosion", "bomb",  10, 120);
        addItem("/assets/effect/logo/bluebomb.png", "/assets/effect/animation/Explosion_blue_circle", "blue bomb", 10, 40);
        addItem("/assets/effect/logo/poisonbomb.png", "/assets/effect/animation/Explosion_gas_circle", "poison bomb", 10, 60);
    }
    
    public void draw(Graphics2D g2){
        coinBanner.draw(g2);
        liveBanner.draw(g2);
        informationBoxUI.draw(g2, ("Stage " + String.valueOf(stage)), items);
    }
    public void addItem(String logoPath, String animationPath, String name, int damage, int cooldown){
        items.add(new Item(logoPath, animationPath, name, damage, cooldown));
    }
}
