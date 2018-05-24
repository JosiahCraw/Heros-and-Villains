package Heroes_Villains.entities;

import Heroes_Villains.Game;
import Heroes_Villains.cities.rooms.HomeBase;
import Heroes_Villains.graphics.Animation;
import Heroes_Villains.graphics.Assets;
import Heroes_Villains.inventory.Inventory;
import Heroes_Villains.utils.RandomNum;

import java.awt.*;
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

    private boolean eventOccured;

    //Inventory
    private Inventory inventory;


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

        if (game.gameState.masterCities.cities[currentCity].rooms[currentRoom] instanceof HomeBase) {

            if (eventOccured == false) {

                int tempNum = RandomNum.getNum(10)+1;

                switch (tempNum) {
                    case 1:
                        money -= 20;
                        System.out.println("Robbed and lost 20 coins");
                        break;
                    case 2:
                        int testNum = RandomNum.getNum(inventory.items.size());
                        inventory.items.get(testNum).count -= 1;
                        System.out.println("You got robbed and lost a random item from your inventory");
                        break;
                    case 3:
                        money += 20;
                        System.out.println("You were gifted 20 coins");
                        break;
                    case 4:
                        int testNum2 = RandomNum.getNum(game.gameState.masterCities.cities[currentCity].inn.getInnKeeper().getItems().size());
                        inventory.addItem(game.gameState.masterCities.cities[currentCity].inn.getInnKeeper().getItems().get(testNum2));
                        System.out.println("You got gifted a random item");
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
        up = Assets.playerUp;
        down = Assets.playerDown;
        left = Assets.playerLeft;
        right = Assets.playerRight;
        this.game = game;
        currentRoom = 0;
        currentCity = 0;
        money = 100;
        eventOccured = false;
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
    public void useMoney(int amount) {
        money += amount;
    }
    public void spendMoney(int amount) {
        money -= amount;
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

