package Heroes_Villains.SystemUI;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import Heroes_Villains.Game;
import Heroes_Villains.graphics.Assets;
import Heroes_Villains.graphics.DrawText;


public class TextField extends UIElement {

    private int width, height;
    private String input;
    private boolean editing;


    public TextField(int x, int y, int width, int height, Game game, BufferedImage[] images) {
        super(x,y,game,images);
        this.x = x;
        this.y = y;
        this.images = images;
        this.width = width;
        this.height = height;
        this.input = "";
        this.editing = false;

    }

    @Override
    public void update() {
        this.render(game.getGraphics());
        if (game.getMouseListener().isHovering(x, y, width, height) && game.getMouseListener().isLeftClicked() || editing) {
            game.getMouseListener().leftClicked = false;
            System.out.println(input + "clicked");
            editing = true;
            //if (editing) {
            //while (!game.getKeyboardListener().enter) {
                game.getKeyboardListener().update();
                for (int i = 0; i < game.getKeyboardListener().keys.length; i++) {
                    if (game.getKeyboardListener().keys[i]) {
                        game.getKeyboardListener().keys[i] = false;
                        input = input + (char)i;
                        this.render(game.getGraphics());

                        //break;
                    }
                    //break;

                }
                if (game.getKeyboardListener().enter) {

                    System.out.println("Enter");
                    System.out.println(input);
                    editing = false;
                    //break;
                }
                //break;


                /*for (int i = 0; i < game.getKeyboardListener().keys.length; i++) {
                    if (game.getKeyboardListener().keys[i]) {
                        input = input + (char)i;
                    }
                }*/
            //}


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
    }

    @Override
    public boolean click() {
        return false;
    }
}
