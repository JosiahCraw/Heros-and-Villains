package Heroes_Villains.States;

import Heroes_Villains.Game;
import Heroes_Villains.cities.Citys;
import Heroes_Villains.entities.Player;

import java.awt.*;

public class GameState extends State {

    public Player player;
    public Citys masterCities;

    public GameState(Game game) {
        super(game);
        player = new Player(100, 400, "Da Boi", game);
        masterCities = new Citys(game);
        player.setCurrentCity(0);
        player.setCurrentRoom(4);
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
    }
}
