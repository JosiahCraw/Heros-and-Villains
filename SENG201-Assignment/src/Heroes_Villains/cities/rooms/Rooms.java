package Heroes_Villains.cities.rooms;

import Heroes_Villains.Game;

import java.awt.*;

public abstract class Rooms {

    protected Game game;

    public Rooms(Game game) {
        this.game = game;
    }

    public abstract void update();

    public abstract void render(Graphics graphics);
}
