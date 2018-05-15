package Heroes_Villains.inventory;

import Heroes_Villains.Game;
import Heroes_Villains.entities.Item;
import Heroes_Villains.graphics.Assets;

import java.awt.*;
import java.util.ArrayList;

public class Inventory {

    private Game game;
    public boolean open = false;
    public ArrayList<Item> items;
    private int inventoryX = 350;
    private int inventoryY = 48;
    private int inventoryWidth = 800;
    private int inventoryHeight = 600;

    public Inventory(Game game) {
        this.game = game;
        items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        for(Item i: items){
            if(i.getId() == item.getId()) {
                i.setCount(i.getCount() + item.getCount());
            }
        }
        items.add(item);
    }

    public void update() {
        open = game.getKeyboardListener().invOpen;
    }

    public void render(Graphics graphics) {
        if(!open) {
            return;
        }
        graphics.drawImage(Assets.inventory, inventoryX, inventoryY, inventoryWidth, inventoryHeight, null);

    }
}
