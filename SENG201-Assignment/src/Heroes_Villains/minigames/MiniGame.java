package Heroes_Villains.minigames;

import Heroes_Villains.Game;

import java.awt.*;

public abstract class MiniGame {

    public int trys;
    public int villainLives;
    protected int villainMove;
    protected Game game;
    public String gameName;
    public String villainMoveWords;

    public MiniGame(int villainMove, Game game, String gameName) {
        this.villainMove = villainMove;
        this.game = game;
        this.gameName = gameName;
    }

    public abstract void update();

    public abstract void render(Graphics graphics);
}
