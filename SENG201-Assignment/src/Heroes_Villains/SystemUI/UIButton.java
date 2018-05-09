package Heroes_Villains.SystemUI;

import Heroes_Villains.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UIButton extends UIElement {

    private int width, height;
    private boolean isHovering;

    public UIButton(int x, int y, Game game, BufferedImage[] images, int width, int height) {
        super(x, y, game, images);
        this.images = images;
        this.width = width;
        this.height = height;
        isHovering = false;
    }

    @Override
    public void update() {
        isHovering = game.getMouseListener().isHovering(x, y, width, height);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(images[0], x, y, null);
        if(isHovering) {
            graphics.drawImage(images[1], x, y, null);
        }
    }

    @Override
    public boolean click() {
        return isHovering;
    }
}
