package Heroes_Villains.entities;

import java.awt.*;
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


    public DoorWay(Game game, int x, int y, BufferedImage[] images) {

        this.x = x;
        this.y = y;
        this.images = images;
        this.game = game;
        this.isColliding = false;


    }

    public void update() {
        if ((game.getPlayer().getX() <= x) && (((game.getPlayer().getY() <= 410) && (game.getPlayer().getY() >= 310) ) || ( (game.getPlayer().getY() + game.getPlayer().getHeight() >= 310) && (game.getPlayer().getY() + game.getPlayer().getHeight() <= 410) ) ) ) {
            isColliding = true;
        } else {
            isColliding = false;
        }
    }

    public void render(Graphics graphics) {

        if (isColliding) {
            graphics.drawImage(images[1], x, y, null);
        } else {
            graphics.drawImage(images[0], x, y, null);
        }
    }
}
