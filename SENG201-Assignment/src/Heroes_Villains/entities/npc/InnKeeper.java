package Heroes_Villains.entities.npc;

import Heroes_Villains.Game;
import Heroes_Villains.cities.Citys;
import Heroes_Villains.entities.Player;
import Heroes_Villains.entities.items.Item;
import Heroes_Villains.entities.items.ItemHandler;
import Heroes_Villains.shop.Shop;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Represents the innkeeper NPC used for assessing the shop.
 * Extends NPC
 */
public class InnKeeper extends NPC {

    private BufferedImage image;
    private int width, height;
    private Game game;
    private Shop shop;
    private Rectangle bounds;
    private ArrayList<Item> items;
    private ItemHandler itemHandler;

    /**
     * Constructs the InnKeeper.
     *
     * @param x the x position of the innkeeper in pixels.
     * @param y the y position of the innkeeper in pixels.
     * @param name the name of the innkeeper.
     * @param image the image of the innkeeper.
     * @param game the object that contains all the objects and variables in the game.
     * @param cities the object containing the array of city objects.
     * @param player the object containg all of the player objects and methods.
     * @param width the with in pixels of the innkeeper.
     * @param height the height of the innkeeper.
     */
    public InnKeeper(float x, float y, String name, BufferedImage image, Game game, Citys cities, Player player, int width, int height) {
        super(x, y, name);
        this.game = game;
        this.width = width;
        this.height = height;
        bounds = new Rectangle((int) x, (int) y, width, height);
        this.image = image;
        items = new ArrayList<>();
        itemHandler = new ItemHandler(game, cities, player);
        items.add(itemHandler.basicPotion);
        items.add(itemHandler.advancedPotion);
        items.add(itemHandler.masterPotion);
        items.add(itemHandler.abilityScroll);
        items.add(itemHandler.healthScroll);
        items.add(itemHandler.speedScroll);
        items.add(itemHandler.map);
        shop = new Shop(game, items);
    }

    @Override
    public void update() {
        if(bounds.intersects(game.getPlayer().bounds) && game.getKeyboardListener().keyJustPressed(KeyEvent.VK_F)) {
            shop.open = !shop.open;
        }else if(shop.open && game.getKeyboardListener().keyJustPressed(KeyEvent.VK_F)) {
            shop.open = false;
        }
        shop.update();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(image, (int) x, (int) y, width, height, null);
        shop.render(graphics);
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
