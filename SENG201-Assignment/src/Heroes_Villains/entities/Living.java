package Heroes_Villains.entities;

public abstract class Living extends Entities {

    protected int health;

    public Living(float x, float y) {
        super(x, y);
        health = 100;
    }

}
