package Heroes_Villains.inventory;

import Heroes_Villains.Game;
import Heroes_Villains.entities.items.Item;
import Heroes_Villains.graphics.Assets;
import Heroes_Villains.graphics.DrawText;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Inventory {

    private Game game;
    public boolean open = false;
    public ArrayList<Item> items;
    private int inventoryX = 420;
    private int inventoryY = 48;
    private int inventoryWidth = 800;
    private int inventoryHeight = 600;
    private int centerX = inventoryX + 267, centreY = inventoryY + inventoryHeight / 2 + 5;
    private int imageX = 1026, imageY = 101, imageWidth = 100, imageHeight = 100;
    private int countX = 1076, countY = 241;
    private int listSpacing = 47;

    public Inventory(Game game) {
        this.game = game;
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        for(Iterator<Item> iterator = items.listIterator(); iterator.hasNext();){
            Item currItem = iterator.next();
            if(currItem.getId() == item.getId()) {
                currItem.setCount(currItem.getCount() + item.getCount());
            }
        }
        items.add(item);
    }


    public void update() {
        open = game.getKeyboardListener().invOpen;
        for(Iterator<Item> iterator = items.listIterator(); iterator.hasNext();) {
            Item currItem = iterator.next();
            if (currItem.getCount() <= 0) {
                iterator.remove();
            }
        }
    }

    public void render(Graphics graphics) {
        if(!open) {
            return;
        }
        graphics.drawImage(Assets.inventory, inventoryX, inventoryY, inventoryWidth, inventoryHeight, null);
        graphics.drawImage(Assets.purple, imageX, imageY, imageWidth, imageHeight, null);
        for(Item i: items) {
            DrawText.draw(graphics, i.getName(), centerX, centreY, true, Color.WHITE, Assets.invFont);
            DrawText.draw(graphics, Integer.toString(i.getCount()), countX, countY, true, Color.WHITE, Assets.invFont);
        }

    }
}
