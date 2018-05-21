package Heroes_Villains.Listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class KeyboardListener implements KeyListener {

    public boolean[] keys, justPressed, cantPress;

    public Boolean up, down, left, right;
    public Boolean arrowUp, arrowDown, arrowLeft, arrowRight, f, enter, delete, control, p;
    public Boolean esc;
    public Boolean invOpen;

    public KeyboardListener() {
        keys = new boolean[256];
        Arrays.fill(keys, false);
        invOpen = false;
        justPressed = new boolean[keys.length];
        cantPress = new boolean[keys.length];
    }

    public void update() {
        for(int i=0; i<keys.length; i++) {
            if(cantPress[i] && !keys[i]) {
                cantPress[i] = false;
            }else if(justPressed[i]) {
                cantPress[i] = true;
                justPressed[i] = false;
            }
            if(!cantPress[i] && keys[i]) {
                justPressed[i] = true;
            }
        }
        esc = keys[KeyEvent.VK_ESCAPE];

        up = keys[KeyEvent.VK_W];
        left = keys[KeyEvent.VK_A];
        down = keys[KeyEvent.VK_S];
        right = keys[KeyEvent.VK_D];

        arrowUp = keys[KeyEvent.VK_UP];
        arrowDown = keys[KeyEvent.VK_DOWN];
        arrowLeft = keys[KeyEvent.VK_LEFT];
        arrowRight = keys[KeyEvent.VK_RIGHT];

        f = keys[KeyEvent.VK_F];

        enter = keys[KeyEvent.VK_ENTER];
        delete = keys[KeyEvent.VK_DELETE] || keys[KeyEvent.VK_BACK_SPACE];

        control = keys[KeyEvent.VK_CONTROL];
        p = keys[KeyEvent.VK_P];
    }

    public boolean keyJustPressed(int keyCode){
        if(keyCode < 0 || keyCode >= keys.length)
            return false;
        return justPressed[keyCode];
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Unused
    }

    @Override
    public void keyPressed(KeyEvent e) {
        /*if(e.getKeyCode() == KeyEvent.VK_E) {
            if(invOpen == true) {
                invOpen = false;
            }
            else {
                invOpen = true;
            }
            return;
        }*/
        if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length) {
            return;
        }
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length) {
            return;
        }
        keys[e.getKeyCode()] = false;
        if(e.getKeyCode() == KeyEvent.VK_UP) {

        }
    }
}
