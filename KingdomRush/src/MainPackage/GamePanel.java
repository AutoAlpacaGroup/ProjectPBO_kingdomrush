/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;
import PlayerBase.PlayerBase;
import Maps.MapsManager;
import Object.Player;
import Object.AssetSetter;
import Object.SuperObject;
import Object.Monster;
import Object.Place;
import PlayerBase.Shop;
import UI.HomeMenuUI;
import UI.InformationBoxUI;
import UI.PauseUI;
import UI.TitleUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
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
    
    public final int arenaScreenCol = 16;
    public final int arenaScreenRow = 9;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 10;
    
    public final int screenWidth = tileSize * maxScreenCol; // 1280 px
    public final int screenHeight = tileSize * maxScreenRow; // 720 px
    
    // FPS
    int fps = 60;
    // GAME SYSTEM
    Player player;
    MapsManager mapsmanager = new MapsManager(this);
    KeyHandler keyhandler = new KeyHandler(this);
    MouseHandler mousehandler = new MouseHandler(this);
    PauseUI pauseUI = new PauseUI(this);    
    TitleUI titleUI = new TitleUI(this);
    HomeMenuUI homemenuUI = new HomeMenuUI(this);
    InformationBoxUI informationBoxUI;
    Shop shop;
    
    PlayerBase playerbase;
    
    Thread gameThread;
    //AssetSetter untuk meletakkan object di map
    //TOWER
    public AssetSetter aSetter = new AssetSetter(this);
    ArrayList<SuperObject> obj = new ArrayList<>();
    
    //MONSTER
    ArrayList<SuperObject> Monster = new ArrayList<>();
    
    // GAME MECHANICS
    public int gameState;
    public int pauseState = 2;
    public int playState = 1;
    public int titleState = 0;
    public boolean shopStateOn = false;
    
    public GamePanel(){
        setupDefault();
        
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        
        // add keyhandler to this panel & focusable to focused to receive keyinputs
        this.addKeyListener(keyhandler);
        this.addMouseListener(mousehandler);
        this.setFocusable(true);        
    }
    // setup default game
    public void setupDefault(){
        player = new Player(this, keyhandler);
        playerbase = new PlayerBase(this, player);
        shop = new Shop(this, playerbase);
        informationBoxUI = new InformationBoxUI(this, player);
        
        gameState = titleState;
    }
    
    // gamethread & run method
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
        aSetter.setEnemy();
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
    
    // UPDATE
    public void playStateUpdate(){
        player.update();
    }
    public void update(){
        if(gameState == playState){
            playStateUpdate();
        }
    }
    
    // PAINT COMPONENT
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        // draw components
        if(gameState == titleState){
            titleUI.draw(g2);
        }else{
            mapsmanager.draw(g2);
            player.draw(g2);
            homemenuUI.draw(g2);
            for(int i=0;i<obj.size();i++){
                if(obj.get(i) !=null){
                    obj.get(i).draw(g2, this);
                }
            }
            for(int i=0;i<Monster.size();i++){
                if(Monster.get(i) != null){
                    Monster.get(i).draw(g2, this);
                    
                    if(Monster.get(i).getWorldX()!=this.tileSize*11){
                        Monster.get(i).setWorldX(Monster.get(i).getWorldX()-10);
                    }else if(Monster.get(i).getWorldX() == this.tileSize*11){
                        Monster.get(i).setWorldY(Monster.get(i).getWorldY()-10);
                    }
                    if(Monster.get(i).getWorldX()==this.tileSize*4 && Monster.get(i).getWorldY()<=this.tileSize*2 ){
                        while(Monster.get(i).getWorldY()+1<160){
                            Monster.get(i).setWorldY(Monster.get(i).getWorldY()+10);
                        }
                    }else if(Monster.get(i).getWorldX()>=this.tileSize*4 && Monster.get(i).getWorldY()==this.tileSize*2 ){
                        Monster.get(i).setWorldX(Monster.get(i).getWorldX()-10);
                    }
                    
                }
            }
            playerbase.draw(g2);
            informationBoxUI.draw(g2, playerbase.getStage(), playerbase.getAllitems());
            if(shopStateOn == true){
                shop.draw(g2);
            }
            if(gameState == pauseState){
                pauseUI.draw(g2);
            }
            g2.dispose();
        }
    }
    
    // GETTER SETTER - TITLEFRAME NUMBER
    public void setTitleFrameSelectedMode(int value){
        titleUI.setNum(value);
    }
    public int getTitleFrameCurrentMode(){
        return titleUI.getNum();
    }
    
    // GETTER SETTER - HOMEMENU & UPGRADEBUTTON
    public boolean isHomeMenuPressed(int x, int y){
        return homemenuUI.isPressed(x,y);
    }
    public boolean isUpgradeButtonPressed(int x, int y){
        return informationBoxUI.isUpgradeButtonPressed(x, y);
    }
    public boolean shopBoxPressed(int x, int y){
        return shop.boxPressed(x,y);
    }
    public void setTower(){
        obj.add(new Place(1));
    }
    public void setMonster(){
        for(int i=0;i<20;i++){
            Monster.add(new Monster(1));
        }
    }
    public int getPosxPlayer(){
        return player.getPosX();
    }
    public int getPosyPlayer(){
        return player.getPosY();
    }
    public void setWorldxTower(int a){
        obj.get(obj.size()-1).setWorldX(a);
    }
    public void setWorldyTower(int a){
        obj.get(obj.size()-1).setWorldY(a);
    }
    public void setWorldxMonster(int a){
        Monster.get(Monster.size()-1).setWorldX(a);
    }
    public void setWorldyMonster(int a){
        Monster.get(Monster.size()-1).setWorldY(a);
    }

    public ArrayList<SuperObject> getObj() {
        return obj;
    }

    public void setObj(ArrayList<SuperObject> obj) {
        this.obj = obj;
    }
    public int jumlahTower(){
        return obj.size();
    }
}
