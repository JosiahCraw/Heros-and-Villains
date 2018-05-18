package Heroes_Villains.SystemUI;

import Heroes_Villains.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class RadioButton extends UIElement {

    private int width, height;
    private boolean clicked;
    private int buttonNum;
    private RadioButtons buttons;

    public RadioButton(int x, int y, Game game, BufferedImage[] images, int width, int height, int buttonNum, RadioButtons buttons) {
        super(x, y, game, images);
        this.buttonNum = buttonNum;
        this.width = width;
        this.height = height;
        clicked = false;
    }

    public boolean isHovering() {
        return game.getMouseListener().isHovering(x, y, width, height);
    }

    @Override
    public void update() {
        this.isHovering();
        if(isHovering() && game.getMouseListener().isLeftClicked()) {
            buttons.clicked(buttonNum);
        }
    }

    @Override
    public void render(Graphics graphics) {
        if(isHovering() && !clicked) {
            graphics.drawImage(images[1], x, y, width, height, null);
        }
        else if(clicked) {
            graphics.drawImage(images[2], x, y, width, height, null);
        } else{
            graphics.drawImage(images[0], x, y, width, height, null);
        }
    }

    @Override
    public boolean click() {
        if(isHovering()) {
            return true;
        }
        return false;
    }
}