package Heroes_Villains.minigames;

import java.awt.*;

public abstract class MiniGame {

    public int trys;
    public int villainLives;
    public int villainMove;

    public MiniGame(int trys, int villainLives, int villainMove) {
        this.trys = trys;
        this.villainLives = villainLives;
        this.villainMove = villainMove;
    }

    public abstract void update();

    public abstract void render(Graphics graphics);
}
