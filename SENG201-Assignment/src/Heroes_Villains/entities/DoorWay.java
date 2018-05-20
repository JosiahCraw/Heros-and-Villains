package Heroes_Villains.entities;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.nio.Buffer;
import Heroes_Villains.Game;

public class DoorWay{

    private int x;
    private int y;
    private BufferedImage[] images;
    protected Game game;
    private boolean isColliding;
    private boolean vertical;
    private int room;


    public DoorWay(Game game, int x, int y, BufferedImage[] images, boolean vertical, int room) {

        this.x = x;
        this.y = y;
        this.images = images;
        this.game = game;
        this.isColliding = false;
        this.vertical = vertical;
        this.room = room;



    }

    public boolean getIsColliding() {
        return isColliding;
    }

    public void update() {
        Rectangle doorRect = new Rectangle(x, y, images[0].getWidth(), images[0].getHeight());
        Rectangle playerRect = new Rectangle((int) game.getPlayer().getX(), (int) game.getPlayer().getY(), game.getPlayer().getWidth(), game.getPlayer().getHeight());
        if (doorRect.intersects(playerRect)) {
            isColliding = true;
            if (game.getKeyboardListener().f) {
                game.getKeyboardListener().f = false;
                game.getPlayer().setCurrentRoom(room);
                game.getPlayer().setX(640 - (game.getPlayer().getWidth())/2);
                game.getPlayer().setY(360 - (game.getPlayer().getHeight())/2);

            }
        } else {
            isColliding = false;
        }
    }

    public void render(Graphics graphics) {
        if (vertical) {
            if (isColliding) {
                graphics.drawImage(images[1], x, y, null);
            } else {
                graphics.drawImage(images[0], x, y, null);
            }
        } else {
            if (isColliding) {
                graphics.drawImage(images[1], x, y, null);
            } else {
                graphics.drawImage(images[0], x, y, null);
            }
        }
    }
}
