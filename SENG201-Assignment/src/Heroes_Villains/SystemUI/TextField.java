package Heroes_Villains.SystemUI;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.ArrayList;

import Heroes_Villains.Game;
import Heroes_Villains.graphics.Assets;
import Heroes_Villains.graphics.DrawText;


public class TextField extends UIElement {

    private int width, height;
    private String input;
    private boolean editing;
    private char[] toLoop = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' '};
    private ArrayList<Character> acceptedCharacters;
    private int maxInput, minInput;
    private boolean underLimit;


    public TextField(int x, int y, int width, int height, Game game, BufferedImage[] images, int maxInput, int minInput) {
        super(x,y,game,images);
        this.x = x;
        this.y = y;
        this.images = images;
        this.width = width;
        this.height = height;
        this.input = "";
        this.editing = false;
        this.acceptedCharacters = new ArrayList<Character>();
        for (char c : toLoop) {
            acceptedCharacters.add(new Character(c));
        }
        this.maxInput = maxInput;
        this.minInput = minInput;
        this.underLimit = true;


    }

    @Override
    public void update() {
        this.render(game.getGraphics());
        if (game.getMouseListener().isHovering(x, y, width, height) && game.getMouseListener().isLeftClicked() || editing) {
            game.getMouseListener().leftClicked = false;
            //System.out.println(input + "clicked");
            editing = true;
                game.getKeyboardListener().update();
                for (int i = 0; i < game.getKeyboardListener().keys.length; i++) {
                    if (game.getKeyboardListener().keys[i]) {
                        game.getKeyboardListener().keys[i] = false;
                        if (game.getKeyboardListener().delete && input.length() > 0) {
                            game.getKeyboardListener().delete = false;
                            input = input.substring(0, input.length() - 1);
                        } else if (acceptedCharacters.contains((char)i) && input.length() < maxInput) {
                            input = input + (char)i;
                        }
                    }


                }
                if (game.getKeyboardListener().enter) {
                    if (input.length() < minInput) {
                        input = "";
                        underLimit = true;

                        //game.getGraphics().drawString("Minimum name length 2", x + width, y);
                    } else {
                        underLimit = false;
                    }
                    //System.out.println("Enter");
                    //System.out.println(input);
                    //input = input.substring(0, input.length() - 1);
                    editing = false;
                    //break;
                }

        }
    }

    @Override
    public void render(Graphics graphics) {

        if(game.getMouseListener().isHovering(x, y, width, height)) {
            graphics.drawImage(images[1], x, y, width, height,null);
        }else if(editing){
            graphics.drawImage(images[1], x, y, width, height,null);
        }else{
            graphics.drawImage(images[0], x, y, width, height,null);
        }
        DrawText.draw(game.getGraphics(), input, x+width/2, y+height/2, true, Color.WHITE, Assets.smallFont);
        if (underLimit) {
            DrawText.draw(graphics,"Minimum name length: " + minInput , x+width+30, y + 25, false, Color.BLACK, Assets.smallFont);
        }
        //System.out.println("Just drew " + input + input.length());

    }

    @Override
    public boolean click() {
        return false;
    }


    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
