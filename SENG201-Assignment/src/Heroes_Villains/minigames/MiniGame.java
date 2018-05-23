package Heroes_Villains.minigames;

import Heroes_Villains.Game;
import Heroes_Villains.States.BattleState;

import java.awt.*;

public abstract class MiniGame {

    public int trys;
    public int villainLives;
    protected int villainMove;
    protected Game game;
    public String gameName;
    public String villainMoveWords;
    public int playerTurns;
    public boolean playing;
    public boolean won, battleWon;
    public static int DAMAGE_TAKEN = 30;
    protected BattleState battleState;

    public MiniGame(int villainMove, Game game, String gameName) {
        this.villainMove = villainMove;
        this.game = game;
        this.gameName = gameName;
        this.battleState = ((BattleState) game.getBattleState());
    }

    public abstract void update();

    public abstract void render(Graphics graphics);
}
