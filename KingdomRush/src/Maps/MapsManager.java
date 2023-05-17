/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Maps;

import MainPackage.GamePanel;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author richardwei
 */
public class MapsManager {
    GamePanel gamepanel;
    Tile[][] tile;
    
    public MapsManager(GamePanel gamepanel){
        this.gamepanel = gamepanel;
        tile = new Tile[9][16];
        getTileImage();
    }
    public void getTileImage(){
        try{
            for(int y = 0; y < 9; y++){
                for(int x = 0; x < 16; x++){
                    tile[y][x] = new Tile();
                    tile[y][x].image = ImageIO.read(getClass().getResourceAsStream("/assets/mapstile/grass.png"));
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){
        int tileSize = gamepanel.tileSize;
        for(int y = 0; y < 9; y++){
            for(int x = 0; x < 16; x++){
                g2.drawImage(tile[y][x].image, x*tileSize, y*tileSize, tileSize, tileSize, gamepanel);
            }
        }
    }
}
