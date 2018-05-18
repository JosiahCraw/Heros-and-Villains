package Heroes_Villains.inventory;

import Heroes_Villains.Game;
import Heroes_Villains.entities.items.Item;
import Heroes_Villains.graphics.Assets;
import Heroes_Villains.graphics.DrawText;

import java.awt.*;
import java.awt.event.KeyEvent;
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
    private int centreX = inventoryX + 267, centreY = inventoryY + inventoryHeight / 2 + 5;
    private int imageX = 1026, imageY = 101, imageWidth = 100, imageHeight = 100;
    private int countX = 1076, countY = 241;
    private int listSpacing = 47;
    private int currentIndex = 0;

    public Inventory(Game game) {
        this.game = game;
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        for(Iterator<Item> iterator = items.listIterator(); iterator.hasNext();){
            Item currItem = iterator.next();
            if(currItem.getId() == item.getId()) {
                currItem.setCount(currItem.getCount()+1);
                return;
            }
        }
        items.add(item);
    }


    public void update() {
        if(game.getKeyboardListener().keyJustPressed(KeyEvent.VK_E)) {
            open = !open;
        }
        if(!open) {
            return;
        }
        for(Iterator<Item> iterator = items.listIterator(); iterator.hasNext();) {
            Item currItem = iterator.next();
            if (currItem.getCount() <= 0) {
                iterator.remove();
            }
        }
        if(game.getKeyboardListener().keyJustPressed(KeyEvent.VK_UP)) {
            currentIndex--;
        }
        if(game.getKeyboardListener().keyJustPressed(KeyEvent.VK_DOWN)) {
            currentIndex++;
        }

        if(currentIndex < 0) {
            currentIndex = items.size() - 1;
        }else if(currentIndex >= items.size()) {
            currentIndex = 0;
        }
    }

    public void render(Graphics graphics) {
        if(!open) {
            return;
        }
        int length = items.size();

        if(items.size() == 0) {
            return;
        }
        graphics.drawImage(Assets.inventory, inventoryX, inventoryY, inventoryWidth, inventoryHeight, null);
        for(int i=-5; i<6; i++) {
            if (currentIndex + i < 0 || currentIndex + i >= length) {
                continue;
            }
            if (i == 0) {
                DrawText.draw(graphics, "> " + items.get(currentIndex + i).getName() + " <", centreX, centreY + i * listSpacing, true, Color.YELLOW, Assets.invFont);
            } else {
                DrawText.draw(graphics, items.get(currentIndex + i).getName(), centreX, centreY + i * listSpacing, true, Color.WHITE, Assets.invFont);




            }
        }
        graphics.drawImage(items.get(currentIndex).image, imageX, imageY, imageWidth, imageHeight, null);
        DrawText.draw(graphics, Integer.toString(items.get(currentIndex).getCount()), countX, countY, true, Color.WHITE, Assets.invFont);
        if(items.get(currentIndex).isUseable() && game.getMouseListener().isHovering(inventoryX+583, inventoryY+258, 144, 64)) {
            DrawText.draw(graphics, ">USE<", 655+inventoryX, 290+inventoryY,true, Color.WHITE, Assets.invFont);
            if(game.getMouseListener().isLeftClicked()) {
                game.getMouseListener().leftClicked = false;
                items.get(currentIndex).use();
            }
        }else if(items.get(currentIndex).isUseable()) {
            DrawText.draw(graphics, ">USE<", 655+inventoryX, 290+inventoryY,true, Color.YELLOW, Assets.invFont);
        }else {
            DrawText.draw(graphics, ">USE<", 655+inventoryX, 290+inventoryY,true, Color.GRAY, Assets.invFont);
        }


        /*for(Item i: items) {
            DrawText.draw(graphics, i.getName(), centreX, centreY, true, Color.WHITE, Assets.invFont);

        }*/

    }
}
