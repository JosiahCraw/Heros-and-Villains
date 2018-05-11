package Heroes_Villains.cities.rooms;

import java.awt.*;

public abstract class Rooms {

    public int roomNo;

    public Rooms(int roomNo) {
        this.roomNo = roomNo;
    }

    public abstract void update();

    public abstract void render(Graphics graphics);
}
