package Heroes_Villains.entities;

import Heroes_Villains.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Living {


    public String name;
    public BufferedImage image;
    public Game game;


    @Override
    public void update() {
        if(game.getKeyboardListener().up || game.getKeyboardListener().arrowUp) {
            y-=1;
        }
        if(game.getKeyboardListener().left || game.getKeyboardListener().arrowLeft) {
            x-=1;
        }
        if(game.getKeyboardListener().down || game.getKeyboardListener().arrowDown) {
            y+=1;
        }
        if(game.getKeyboardListener().right || game.getKeyboardListener().arrowRight) {
            x+=1;
        }

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(image, (int) x, (int) y, null);
    }

    public Player(float x, float y, String name, BufferedImage image, Game game) {
        super(x, y);
        this.name = name;
        this.image = image;
        this.game = game;
    }
}
