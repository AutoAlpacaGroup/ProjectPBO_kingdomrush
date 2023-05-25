/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author USER
 */
public class Monster extends SuperObject {
    public ArrayList<BufferedImage> moveright =  new ArrayList<>();
    public Monster(int a) {
        try{
            image=ImageIO.read(getClass().getResource("/assets/tower/tower"+a+".png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
