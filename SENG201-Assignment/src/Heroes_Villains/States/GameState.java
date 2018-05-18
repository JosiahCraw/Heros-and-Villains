package Heroes_Villains.States;

import Heroes_Villains.Game;
import Heroes_Villains.cities.Citys;
import Heroes_Villains.entities.Player;
import Heroes_Villains.entities.items.HealingItem;
import Heroes_Villains.entities.items.ItemHandler;
import Heroes_Villains.graphics.Assets;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameState extends State {

    public Player player;
    public Citys masterCities;
    public HealingItem potion;
    public ItemHandler itemHandler;

    public GameState(Game game) {
        super(game);
        player = new Player(100, 400, "Da Boi", game);
        masterCities = new Citys(game);
        player.setCurrentCity(0);
        player.setCurrentRoom(4);
        potion = new HealingItem(0, "Basic Potion", Assets.purple, game, masterCities);
        itemHandler = new ItemHandler(game, masterCities);
        player.getInventory().addItem(itemHandler.basicPotion);
        player.getInventory().addItem(itemHandler.advancedPotion);
        player.getInventory().addItem(itemHandler.advancedPotion);
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void update() {
        masterCities.update();
        player.update();
        potion.update();
        if(game.getKeyboardListener().keyJustPressed(KeyEvent.VK_ESCAPE)) {
            game.getStateHandler().setState(game.getPauseState());
        }
    }

    @Override
    public void render(Graphics graphics) {
        masterCities.render(graphics);
        player.render(graphics);
    }

    public Citys getCities() {
        return masterCities;
    }
}
