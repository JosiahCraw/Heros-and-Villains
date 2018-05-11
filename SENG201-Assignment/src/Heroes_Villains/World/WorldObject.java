package Heroes_Villains.World;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class WorldObject {

    protected int x, y, id;
    protected boolean solid;
    protected String name;
    protected BufferedImage texture;

    public WorldObject(int x, int y, int id, boolean solid, String name, BufferedImage texture) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.solid = solid;
        this.name = name;
        this.texture = texture;
    }

    public abstract void update();

    public abstract void render(Graphics graphics);
}
