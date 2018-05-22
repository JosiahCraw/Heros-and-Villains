package Heroes_Villains.cities.rooms;

import Heroes_Villains.Game;
import Heroes_Villains.cities.Citys;
import Heroes_Villains.entities.DoorWay;
import Heroes_Villains.entities.items.Item;
import Heroes_Villains.entities.items.ItemHandler;
import Heroes_Villains.graphics.Assets;
import Heroes_Villains.shop.Shop;

import java.awt.*;
import java.util.ArrayList;

public class Inn extends Rooms{

    private DoorWay exit = new DoorWay(game,1230, 310, Assets.doorWay, true, 4);
    private Shop shop;
    private ArrayList<Item> items;
    private ItemHandler itemHandler;

    public Inn(Game game, Citys cities) {
        super(game);
        roomName = "Inn";
        items = new ArrayList<>();
        itemHandler = new ItemHandler(game, cities, game.getPlayer());
        items.add(itemHandler.basicPotion);
        items.add(itemHandler.advancedPotion);
        items.add(itemHandler.masterPotion);
        shop = new Shop(game, items);
    }

    @Override
    public void update() {
        /*
        if(game.getMouseListener().isHovering(1200, 360, 16, 16) && game.getMouseListener().leftClicked) {
            game.getMouseListener().leftClicked = false;
            game.getPlayer().setX(576);
            game.getPlayer().setY(296);
            game.getPlayer().setCurrentRoom(4);
        }
        */
        exit.update();
        shop.update();

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.innFloor, 0, 0, null);
        graphics.drawImage(Assets.inn, 0, 0, null);
        graphics.setColor(Color.WHITE);
        graphics.setFont(Assets.titleFont);
        graphics.drawString("Inn", 650, 400);
        //graphics.drawImage(Assets.purple, 1200, 360, null);
        graphics.drawImage(Assets.innkeep, 576, 70, 72, 100, null);
        if(!game.getPlayer().getInventory().open) {
            if(game.getMouseListener().isHovering(576, 70, 72, 100) && game.getMouseListener().leftClicked) {
                game.getMouseListener().leftClicked = false;
                shop.open = !shop.open;
            }
            shop.render(graphics);
        }
        exit.render(graphics);
    }
}
