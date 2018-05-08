package Heroes_Villains.States;

import Heroes_Villains.Game;
import Heroes_Villains.entities.Player;
import Heroes_Villains.graphics.Assets;

import java.awt.*;

public class GameState extends State {

    private Player player;

    public GameState(Game game) {
        super(game);
        player = new Player(100, 400, "Da Boi", Assets.player, game);
    }

    @Override
    public void update() {
        player.update();
    }

    @Override
    public void render(Graphics graphics) {
        player.render(graphics);
    }
}
