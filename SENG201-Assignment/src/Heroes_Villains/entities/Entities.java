package Heroes_Villains.entities;

import java.awt.*;

public abstract class Entities {

    protected float x, y;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Entities(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public abstract void update();

    public abstract void render(Graphics graphics);
}

