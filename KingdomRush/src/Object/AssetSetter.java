/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import MainPackage.GamePanel;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp=gp;
    }
    public void setObject(int a){
        //pengecekan agar tower tetap 1 tile lebarnya
        int b=gp.getPosxPlayer();
        int ctrx=0;
        int c=gp.getPosyPlayer();
        int ctry=0;
        while(b-gp.tileSize>0){
            ctrx++;
            b-=gp.tileSize;
        }
        while(c-gp.tileSize>0){
            ctry++;
            c-=gp.tileSize;
        }
        //pengecekan lokasi valid apakah sudah ditempati
        int ctr=0;
        ArrayList <SuperObject> temp=gp.getObj();
        for(int i=0;i<temp.size();i++){
            if(temp.get(i).getWorldX()==ctrx*gp.tileSize && temp.get(i).getWorldY()==ctry*gp.tileSize && temp.get(i).getWorldY()!=(
                    ctry*gp.tileSize)-1){
                ctr++;
            }
        }
        if(ctr==0){
            gp.setTower();
            gp.setWorldxTower(ctrx * gp.tileSize);
            gp.setWorldyTower(ctry * gp.tileSize);
        }
    }
    
    public void setEnemy(){
        gp.setMonster();
        gp.setWorldxMonster(15*gp.tileSize);
        gp.setWorldyMonster(gp.tileSize*4);
    }
}
