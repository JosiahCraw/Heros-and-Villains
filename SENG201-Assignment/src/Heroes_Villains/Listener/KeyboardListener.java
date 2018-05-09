package Heroes_Villains.Listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class KeyboardListener implements KeyListener {

    private Boolean[] keys;

    public Boolean up, down, left, right;
    public Boolean arrowUp, arrowDown, arrowLeft, arrowRight;
    public Boolean esc;

    public KeyboardListener() {
        keys = new Boolean[256];
        Arrays.fill(keys, false);
    }

    public void update() {
        esc = keys[KeyEvent.VK_ESCAPE];

        up = keys[KeyEvent.VK_W];
        left = keys[KeyEvent.VK_A];
        down = keys[KeyEvent.VK_S];
        right = keys[KeyEvent.VK_D];

        arrowUp = keys[KeyEvent.VK_UP];
        arrowDown = keys[KeyEvent.VK_DOWN];
        arrowLeft = keys[KeyEvent.VK_LEFT];
        arrowRight = keys[KeyEvent.VK_RIGHT];
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Unused
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}
