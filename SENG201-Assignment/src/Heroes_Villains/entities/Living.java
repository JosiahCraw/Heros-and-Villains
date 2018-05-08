package Heroes_Villains.entities;

import java.awt.*;

public abstract class Living extends Entities {

    protected int health;

    public Living(float x, float y) {
        super(x, y);
        health = 100;
    }
    public abstract void update();

    public abstract void render(Graphics graphics);
}
