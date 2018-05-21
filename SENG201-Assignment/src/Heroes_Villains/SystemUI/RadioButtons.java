package Heroes_Villains.SystemUI;

import Heroes_Villains.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class RadioButtons extends UIElement{

    private int numButtons;
    private int spacing;
    private boolean horzizontal;
    protected RadioButton[] buttons;
    private BufferedImage[][] imagesArray;
    private int width, height;
    public int currentlyClicked;


    public RadioButtons(int x, int y, Game game, BufferedImage[] images, int numButtons, int spacing, boolean horizontal, int width, int height) {
        super(x, y, game, images);
        this.numButtons = numButtons;
        this.spacing = spacing;
        this.horzizontal = horizontal;
        this.width = width;
        this.height = height;
        buttons = new RadioButton[numButtons];
        imagesArray = new BufferedImage[numButtons][3];
        int imageIndex = 0;
        this.currentlyClicked = 0;
        for(int i=0; i<numButtons; i++) {
            imagesArray[i][0] = images[imageIndex];
            imageIndex++;
            imagesArray[i][1] = images[imageIndex];
            imageIndex++;
            imagesArray[i][2] = images[imageIndex];
            imageIndex = imageIndex - 2;
        }
        int currX = x;
        int currY = y;
        for(int i=0; i<numButtons; i++) {
            if(horizontal) {
                buttons[i] = new RadioButton(currX, currY, game, imagesArray[i], width, height, i, this);
                currX += (width + spacing);
            }
            if(!horizontal) {
                buttons[i] = new RadioButton(currX, currY, game, imagesArray[i], width, height, i, this);
                currY += (height + spacing);
            }

        }
    }
    public void clicked(int buttonClicked) {
        for(int i=0; i<numButtons; i++) {
            buttons[i].setClicked(false);
        }
        buttons[buttonClicked].setClicked(true);
        currentlyClicked = buttonClicked;
    }

    public void update() {
        for(int i=0; i<numButtons; i++) {
            buttons[i].update();
        }
    }

    public void render(Graphics graphics) {
        for(int i=0; i<numButtons; i++) {
            buttons[i].render(graphics);
        }
    }

    @Override
    public boolean click() {
        return false;
    }
}
