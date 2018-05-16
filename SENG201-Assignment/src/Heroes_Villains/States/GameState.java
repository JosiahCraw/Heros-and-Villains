package Heroes_Villains.States;

import Heroes_Villains.Game;
import Heroes_Villains.cities.Citys;
import Heroes_Villains.entities.Player;
import Heroes_Villains.entities.items.HealingItem;
import Heroes_Villains.graphics.Assets;

import java.awt.*;

public class GameState extends State {

    public Player player;
    public Citys masterCities;
    public HealingItem potion;

    public GameState(Game game) {
        super(game);
        player = new Player(100, 400, "Da Boi", game);
        masterCities = new Citys(game);
        player.setCurrentCity(0);
        player.setCurrentRoom(4);
        potion = new HealingItem(0, "Basic Potion", Assets.purple, game, masterCities);
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void update() {
        masterCities.update();
        player.update();
        if(game.getKeyboardListener().esc) {
            game.getStateHandler().setState(game.getPauseState());
        }
    }

    @Override
    public void render(Graphics graphics) {
        masterCities.render(graphics);
        player.render(graphics);
        System.out.println(potion.isUseable());
    }

    public Citys getCities() {
        return masterCities;
    }
}
