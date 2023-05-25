/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author USER
 */
public class Place  extends SuperObject{
    
    public Place(int a) {
        try{
            image=ImageIO.read(getClass().getResource("/assets/tower/tower1.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
