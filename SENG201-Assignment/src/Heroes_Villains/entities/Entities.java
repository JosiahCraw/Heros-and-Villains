package Heroes_Villains.entities;

import java.awt.*;

public abstract class Entities {

    protected float x, y;

    public Entities(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public abstract void update();

    public abstract void render(Graphics graphics);
}

