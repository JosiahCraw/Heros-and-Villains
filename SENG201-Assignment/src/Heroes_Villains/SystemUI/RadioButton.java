package Heroes_Villains.SystemUI;

import Heroes_Villains.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class RadioButton extends UIElement {

    public RadioButton(int x, int y, Game game, BufferedImage[] images) {
        super(x, y, game, images);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {

    }

    @Override
    public boolean click() {
        return false;
    }
}
