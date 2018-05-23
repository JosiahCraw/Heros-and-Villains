package Heroes_Villains.cities.rooms;

import Heroes_Villains.Game;
import Heroes_Villains.entities.DoorWay;
import Heroes_Villains.graphics.Assets;

import java.awt.*;
import java.awt.event.KeyEvent;

public class HomeBase extends Rooms{

    private DoorWay leftDoor = new DoorWay(game,0, 310, Assets.doorWay, true, 0);
    private DoorWay rightDoor = new DoorWay(game, 1230, 310, Assets.doorWay, true, 2);
    private DoorWay topDoor = new DoorWay(game, 590, 0, Assets.doorWayH, false, 1);
    private DoorWay bottomDoor = new DoorWay(game, 590, 670, Assets.doorWayH, false, 3);

    public HomeBase(Game game) {
        super(game);
        roomName = "Home Base";
    }

    @Override
    public void update() {

        leftDoor.update();
        rightDoor.update();
        topDoor.update();
        bottomDoor.update();

    }

    @Override
    public void render(Graphics graphics) {
        graphics.setFont(Assets.titleFont);
        graphics.drawString("Home Base", 650, 400);
        /*
        graphics.drawImage(Assets.black, 1200, 360, null);
        graphics.drawImage(Assets.black, 0, 360, null);
        graphics.drawImage(Assets.black, 640, 0, null);
        graphics.drawImage(Assets.black, 640, 680, null);
        */
        leftDoor.render(graphics);
        rightDoor.render(graphics);
        topDoor.render(graphics);
        bottomDoor.render(graphics);

    }
}