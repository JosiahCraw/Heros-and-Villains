package Heroes_Villains.entities;

import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.RadioButtons;
import Heroes_Villains.SystemUI.UIButton;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.cities.rooms.HomeBase;
import Heroes_Villains.entities.items.Item;
import Heroes_Villains.graphics.Animation;
import Heroes_Villains.graphics.Assets;
import Heroes_Villains.graphics.DrawText;
import Heroes_Villains.inventory.Inventory;
import Heroes_Villains.utils.RandomNum;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player extends Living {


    public String name;
    public BufferedImage up, down, left, right;
    public Game game;
    public Animation animUp, animDown, animLeft, animRight;

    public int money;
    public Rectangle bounds;

    //City and room location information
    private int currentCity;
    private int currentRoom;

    private int width;
    private int height;
    private int speed;

    private boolean eventOccured;

    //Inventory
    private Inventory inventory;

    //Team checking
    private UIElement okButton, robButton, giftButton;
    private RadioButtons heroSelector1, heroSelector2, heroSelector3;
    private int radioWidth1, radioWidth2, radioWidth3, currentlyClicked;
    private boolean atributes, robbed, gifted;
    private String rob, gift;
    private Item robItem, giftItem;


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
            }else if(game.getTeam().size() == 2) {
                heroSelector2.update();
            }else if(game.getTeam().size() == 3) {
                heroSelector3.update();
            }
        }
        if(robbed) {
            robButton.update();
            if(robButton.click() && game.getMouseListener().leftClicked) {
                game.getMouseListener().leftClicked = false;
                robbed = false;
            }
        }
        if(gifted) {
            giftButton.update();
            if(giftButton.click() && game.getMouseListener().leftClicked) {
                game.getMouseListener().leftClicked = false;
                gifted = false;
            }
        }
        if (game.gameState.masterCities.cities[currentCity].rooms[currentRoom] instanceof HomeBase) {

            if (eventOccured == false) {

                int tempNum = RandomNum.getNum(10)+1;

                switch (tempNum) {
                    case 1:
                        money -= 20;
                        System.out.println("Robbed and lost 20 coins");
                        robbed = true;
                        rob = "You were robbed and lost 20 coins";
                        break;
                    case 2:
                        int testNum = RandomNum.getNum(inventory.items.size());
                        inventory.items.get(testNum).count -= 1;
                        System.out.println("You got robbed and lost a random item from your inventory");
                        robbed = true;
                        rob = "You got robbed and lost a ";
                        robItem = inventory.items.get(testNum);
                        break;
                    case 3:
                        money += 20;
                        System.out.println("You were gifted 20 coins");
                        gifted = true;
                        gift = "You were gifted 20 coins";
                        break;
                    case 4:
                        int testNum2 = RandomNum.getNum(game.gameState.masterCities.cities[currentCity].inn.getInnKeeper().getItems().size());
                        inventory.addItem(game.gameState.masterCities.cities[currentCity].inn.getInnKeeper().getItems().get(testNum2));
                        System.out.println("You got gifted a random item");
                        gifted = true;
                        gift = "You got gifted ";
                        giftItem = game.gameState.masterCities.cities[currentCity].inn.getInnKeeper().getItems().get(testNum2);
                        break;
                    default:
                        System.out.println("Nothing happened yol");
                }

                eventOccured = true;
                //System.out.println("Set event occurred to true");
            }


        } else {
            eventOccured = false;
            //System.out.println("Set event occurred to false");
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
            okButton.render(graphics);
            graphics.drawImage(Assets.battlePopup, 384, 168, null);
            if(game.getTeam().size() == 1) {
                attributeDraw(heroSelector1, graphics);
                return;
            }else if(game.getTeam().size() == 2) {
                attributeDraw(heroSelector2, graphics);
                return;
            }else if(game.getTeam().size() == 3) {
                attributeDraw(heroSelector3, graphics);
                return;
            }
        }
        if(robbed) {
            if(rob == "You were robbed and lost 20 coins") {
                graphics.drawImage(Assets.battlePopup, 384, 168, null);
                robButton.render(graphics);
                DrawText.draw(graphics, rob, 640, 360, true, Color.WHITE, Assets.smallFont);
                return;
            }
            graphics.drawImage(Assets.stolenPopup, 384, 168, null);
            robButton.render(graphics);
            graphics.drawImage(robItem.image,577,230, 128, 128, null);
            DrawText.draw(graphics,  "A " + robItem.name + " was stolen", 640, 380, true, Color.WHITE, Assets.smallFont);
        }
        if(gifted) {
            if(gift == "You were gifted 20 coins") {
                graphics.drawImage(Assets.battlePopup, 384, 168, null);
                giftButton.render(graphics);
                DrawText.draw(graphics, gift, 640, 360, true, Color.WHITE, Assets.smallFont);
                return;
            }
            graphics.drawImage(Assets.stolenPopup, 384, 168, null);
            giftButton.render(graphics);
            graphics.drawImage(giftItem.image,577,230, 128, 128, null);
            DrawText.draw(graphics, "You were gifted: "+ giftItem.name, 640, 380, true, Color.WHITE, Assets.smallFont);
        }
    }

    public Player(float x, float y, String name, Game game) {
        super(x, y);
        speed = 20;
        this.name = name;
        this.width = 128;
        this.height = 128;
        this.bounds = new Rectangle((int) x, (int) y, width, height);
        robButton = new UIButton(640-Assets.buttonWidth/2, 450, game, Assets.battleStateOK, Assets.buttonWidth, Assets.buttonHeight);
        giftButton = new UIButton(640-Assets.buttonWidth/2, 450, game, Assets.battleStateOK, Assets.buttonWidth, Assets.buttonHeight);
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
        eventOccured = false;

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

