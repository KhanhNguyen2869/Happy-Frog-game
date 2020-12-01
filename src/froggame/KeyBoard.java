/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package froggame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Kero
 */
public class KeyBoard implements KeyListener{
    private boolean press = false;
    private boolean release = true;



    public boolean isPress() {
        return press;
    }

    public void setPress(boolean press) {
        this.press = press;
    }

    public boolean isRelease() {
        return release;
    }

    public void setRelease(boolean release) {
        this.release = release;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            if(release){
                press = true;
                release = false;
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        release = true;
    }
    
}
