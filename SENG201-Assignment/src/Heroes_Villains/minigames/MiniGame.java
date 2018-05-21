package Heroes_Villains.minigames;

import Heroes_Villains.Game;

import java.awt.*;

public abstract class MiniGame {

    public int trys;
    public int villainLives;
    public int villainMove;
    protected Game game;

    public MiniGame(int trys, int villainLives, int villainMove, Game game) {
        this.trys = trys;
        this.villainLives = villainLives;
        this.villainMove = villainMove;
        this.game = game;
    }

    public abstract void update();

    public abstract void render(Graphics graphics);
}
