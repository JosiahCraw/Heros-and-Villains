package Heroes_Villains.SystemUI;

import Heroes_Villains.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class RadioButtons extends UIElement{

    private int numButtons;
    private int spacing;
    private boolean horzizontal;
    protected RadioButton[] buttons;
    private BufferedImage[][] imagesArray;
    private int width, height;


    public RadioButtons(int x, int y, Game game, BufferedImage[] images, int numButtons, int spacing, boolean horizontal, int width, int height) {
        super(x, y, game, images);
        this.numButtons = numButtons;
        this.spacing = spacing;
        this.horzizontal = horizontal;
        this.width = width;
        this.height = height;
        buttons = new RadioButton[numButtons];
        imagesArray = new BufferedImage[3][numButtons];
        int imageIndex = 0;
        for(int i=0; i<numButtons; i++) {
            imagesArray[0][i] = images[imageIndex];
            imageIndex++;
            imagesArray[1][i] = images[imageIndex];
            imageIndex++;
            imagesArray[2][i] = images[imageIndex];
            imageIndex++;
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
        for()
        buttons[buttonClicked].setClicked(true);
    }

    public abstract void update();

    public abstract void render(Graphics graphics);

    public boolean click(int buttonNum) {
        return buttons[buttonNum].click();
    }
}
