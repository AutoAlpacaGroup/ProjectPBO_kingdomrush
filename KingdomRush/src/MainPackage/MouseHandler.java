/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author richardwei
 */
public class MouseHandler implements MouseListener{
    GamePanel gamepanel;
    
    public MouseHandler(GamePanel gamepanel){
        this.gamepanel = gamepanel;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mousePositionX = e.getX();
        int mousePositionY = e.getY();
        
        if(gamepanel.isHomeMenuPressed(mousePositionX, mousePositionY)){
            gamepanel.gameState = gamepanel.pauseState;
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
