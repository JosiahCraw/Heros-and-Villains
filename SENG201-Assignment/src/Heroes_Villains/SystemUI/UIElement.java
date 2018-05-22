package Heroes_Villains.SystemUI;

import Heroes_Villains.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class UIElement {

    public int x, y;
    protected Game game;
    protected BufferedImage[] images;

    public UIElement(int x, int y, Game game, BufferedImage[] images) {
        this.x = x;
        this.y = y;
        this.game = game;
        this.images = images;
    }

    public abstract void update();

    public abstract void render(Graphics graphics);

    public abstract boolean click();
}
