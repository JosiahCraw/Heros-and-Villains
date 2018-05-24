package Heroes_Villains.entities;

import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.RadioButtons;
import Heroes_Villains.SystemUI.UIButton;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.graphics.Animation;
import Heroes_Villains.graphics.Assets;
import Heroes_Villains.graphics.DrawText;
import Heroes_Villains.inventory.Inventory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player extends Living {


    public String name;
    public BufferedImage up, down, left, right;
    public Game game;
    public Animation animUp, animDown, animLeft, animRight;

    public String teamName;
    public int money;
    public Rectangle bounds;

    //City and room location information
    private int currentCity;
    private int currentRoom;

    private int width;
    private int height;
    private int speed;

    //Inventory
    private Inventory inventory;

    //Team checking
    private UIElement okButton;
    private RadioButtons heroSelector1, heroSelector2, heroSelector3;
    private int radioWidth1, radioWidth2, radioWidth3, currentlyClicked;
    private boolean atributes;


    @Override
    public void update() {
        bounds.x = (int) x;
        bounds.y = (int) y;
        animUp.update();
        animDown.update();
        animLeft.update();
        animRight.update();
        if(game.getKeyboardListener().up) {
            y-=speed;
        }
        if(game.getKeyboardListener().left) {
            x-=speed;
        }
        if(game.getKeyboardListener().down) {
            y+=speed;
        }
        if(game.getKeyboardListener().right) {
            x+=speed;
        }
        inventory.update();

        if (game.getPlayer().getX() < 0) {
            game.getPlayer().setX(0);
        }
        if (game.getPlayer().getX() > game.width - game.getPlayer().getWidth()) {
            game.getPlayer().setX(game.width - game.getPlayer().getWidth());
        }
        if (game.getPlayer().getY() < 0) {
            game.getPlayer().setY(0);
        }
        if (game.getPlayer().getY() > game.height - game.getPlayer().getHeight()) {
            game.getPlayer().setY(game.height - game.getPlayer().getHeight());
        }
        if(currentRoom == 4 && game.getKeyboardListener().keyJustPressed(KeyEvent.VK_H)) {
            atributes = !atributes;
            heroSelector1.clicked(0);
            heroSelector2.clicked(0);
            heroSelector3.clicked(0);

        }
        if(atributes) {
            okButton.update();
            if(okButton.click() && game.getMouseListener().leftClicked) {
                game.getMouseListener().leftClicked = false;
                atributes = false;
            }
            if(game.getTeam().size() == 1) {
                heroSelector1.update();
            }
            if(game.getTeam().size() == 2) {
                heroSelector2.update();
            }
            if(game.getTeam().size() == 3) {
                heroSelector3.update();
            }
        }

    }



    @Override
    public void render(Graphics graphics) {
        //graphics.drawImage(Assets.playerDown, (int) x, (int) y, null);

        if(game.getKeyboardListener().up || game.getKeyboardListener().arrowUp) {
            graphics.drawImage(getCurrentImage(animUp), (int) x, (int) y, 128, 128, null);
            //graphics.drawImage(up, (int) x, (int) y, null);
        }
        else if(game.getKeyboardListener().left || game.getKeyboardListener().arrowLeft) {
            graphics.drawImage(getCurrentImage(animLeft), (int) x, (int) y, 128, 128, null);
            //graphics.drawImage(left, (int) x, (int) y, null);
        }
        else if(game.getKeyboardListener().down || game.getKeyboardListener().arrowDown) {
            graphics.drawImage(getCurrentImage(animDown), (int) x, (int) y, 128, 128, null);
            //graphics.drawImage(down, (int) x, (int) y, null);
        }
        else if(game.getKeyboardListener().right || game.getKeyboardListener().arrowRight) {
            graphics.drawImage(getCurrentImage(animRight), (int) x, (int) y, 128, 128, null);
            //graphics.drawImage(right, (int) x, (int) y, null)
        }
        else {
            graphics.drawImage(getCurrentImage(animDown), (int) x, (int) y, 128, 128, null);
        }
        inventory.render(graphics);
        if(atributes) {
            graphics.drawImage(Assets.battlePopup, 384, 168, null);
            if(game.getTeam().size() == 1) {
                heroSelector1.render(graphics);
                attributeDraw(heroSelector3, graphics);
            }
            if(game.getTeam().size() == 2) {
                heroSelector2.render(graphics);
                attributeDraw(heroSelector3, graphics);
            }
            if(game.getTeam().size() == 3) {
                heroSelector3.render(graphics);
                attributeDraw(heroSelector3, graphics);
            }
        }
    }

    public Player(float x, float y, String name, Game game) {
        super(x, y);
        speed = 20;
        this.name = name;
        this.width = 128;
        this.height = 128;
        this.bounds = new Rectangle((int) x, (int) y, width, height);
        inventory = new Inventory(game);
        animUp = new Animation(Assets.batUp, 300);
        animDown = new Animation(Assets.batDown, 300);
        animLeft = new Animation(Assets.batLeft, 300);
        animRight = new Animation(Assets.batRight, 300);
        radioWidth1 = 50;
        radioWidth2 = 120;
        radioWidth3 = 190;
        okButton = new UIButton(640-Assets.buttonWidth/2, 450, game, Assets.battleStateOK, Assets.buttonWidth, Assets.buttonHeight);
        heroSelector1 = new RadioButtons(450, 360-radioWidth1/2, game, Assets.invRadioButton, 1, 20, false,50, 50);
        heroSelector2 = new RadioButtons(450, 360-radioWidth2/2, game, Assets.invRadioButton, 2, 20, false,50, 50);
        heroSelector3 = new RadioButtons(450, 360-radioWidth3/2, game, Assets.invRadioButton, 3, 20, false,50, 50);
        up = Assets.playerUp;
        down = Assets.playerDown;
        left = Assets.playerLeft;
        right = Assets.playerRight;
        this.game = game;
        currentRoom = 0;
        currentCity = 0;
        money = 100;

        atributes = false;
    }

    public void attributeDraw(RadioButtons selector, Graphics graphics) {
        selector.render(graphics);
        DrawText.draw(graphics, game.getTeam().get(selector.currentlyClicked).getName(), 640, 300, true, Color.WHITE, Assets.invFont);
        DrawText.draw(graphics, game.getTeam().get(selector.currentlyClicked).getType(), 640, 350, true, Color.WHITE, Assets.smallFont);
        DrawText.draw(graphics, "Health: " + Integer.toString(game.getTeam().get(selector.currentlyClicked).getHealth()), 640, 400, true, Color.WHITE, Assets.smallFont);
        DrawText.draw(graphics, "Ability used: " + Boolean.toString(game.getTeam().get(selector.currentlyClicked).isAbilityUsed()), 640, 450, true, Color.WHITE, Assets.smallFont);
    }

    private BufferedImage getCurrentImage(Animation tempAnim) {
        return tempAnim.getCurrentImage();
    }

    public int getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(int currentCity) {
        this.currentCity = currentCity;
    }

    public int getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(int currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

