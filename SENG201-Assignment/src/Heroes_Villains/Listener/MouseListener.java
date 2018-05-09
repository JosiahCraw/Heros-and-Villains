package Heroes_Villains.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseListener implements java.awt.event.MouseListener, MouseMotionListener {

    public boolean leftClicked, rightClicked;
    public int mousePosX, mousePosY;

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {
            leftClicked = true;
        }
        else if(e.getButton() == MouseEvent.BUTTON3) {
            rightClicked = true;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    public boolean isHovering(int x, int y, int width, int height) {
        if(mousePosX >= x && mousePosX <= x + width) {
            if(mousePosY >= y && mousePosY <= y + height) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {
            leftClicked = false;
        }
        else if(e.getButton() == MouseEvent.BUTTON3) {
            rightClicked = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mousePosX = e.getX();
        mousePosY = e.getY();
    }

    //Getters

    public boolean isLeftClicked() {
        return leftClicked;
    }

    public boolean isRightClicked() {
        return rightClicked;
    }

    public int getMousePosX() {
        return mousePosX;
    }

    public int getMousePosY() {
        return mousePosY;
    }
}
