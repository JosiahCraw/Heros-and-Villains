package Heroes_Villains.entities;

import Heroes_Villains.Game;
import Heroes_Villains.graphics.Animation;
import Heroes_Villains.graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Living {


    public String name;
    public BufferedImage up, down, left, right;
    public Game game;
    public Animation animUp, animDown, animLeft, animRight;

    public String teamName;

    @Override
    public void update() {
        animUp.update();
        animDown.update();
        animLeft.update();
        animRight.update();
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
        graphics.drawImage(getCurrentImage(animDown), (int) x, (int) y, 128, 128, null);
        //graphics.drawImage(Assets.playerDown, (int) x, (int) y, null);

        if(game.getKeyboardListener().up || game.getKeyboardListener().arrowUp) {
            graphics.drawImage(getCurrentImage(animUp), (int) x, (int) y, 128, 128, null);
            //graphics.drawImage(up, (int) x, (int) y, null);
        }
        if(game.getKeyboardListener().left || game.getKeyboardListener().arrowLeft) {
            graphics.drawImage(getCurrentImage(animLeft), (int) x, (int) y, 128, 128, null);
            //graphics.drawImage(left, (int) x, (int) y, null);
        }
        if(game.getKeyboardListener().down || game.getKeyboardListener().arrowDown) {
            graphics.drawImage(getCurrentImage(animDown), (int) x, (int) y, 128, 128, null);
            //graphics.drawImage(down, (int) x, (int) y, null);
        }
        if(game.getKeyboardListener().right || game.getKeyboardListener().arrowRight) {
            graphics.drawImage(getCurrentImage(animRight), (int) x, (int) y, 128, 128, null);
            //graphics.drawImage(right, (int) x, (int) y, null);
        }

    }

    public Player(float x, float y, String name, BufferedImage image, Game game) {
        super(x, y);
        this.name = name;
        animUp = new Animation(Assets.batUp, 300);
        animDown = new Animation(Assets.batDown, 300);
        animLeft = new Animation(Assets.batLeft, 300);
        animRight = new Animation(Assets.batRight, 300);
        up = Assets.playerUp;
        down = Assets.playerDown;
        left = Assets.playerLeft;
        right = Assets.playerRight;
        this.game = game;
    }

    private BufferedImage getCurrentImage(Animation tempAnim) {
        return tempAnim.getCurrentImage();
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
