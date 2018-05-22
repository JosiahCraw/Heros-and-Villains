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

        /*
        if(game.getMouseListener().isHovering(0, 360, 16, 16) && game.getMouseListener().leftClicked) {
            game.getMouseListener().leftClicked = false;
            game.getPlayer().setX(1150);
            game.getPlayer().setY(300);
            game.getPlayer().setCurrentRoom(0);
        }



        if(game.getMouseListener().isHovering(640, 0, 16, 16) && game.getMouseListener().leftClicked) {
            game.getMouseListener().leftClicked = false;
            game.getPlayer().setX(1150);
            game.getPlayer().setY(300);
            game.getPlayer().setCurrentRoom(1);
        }
        if(game.getMouseListener().isHovering(1200, 360, 16, 16) && game.getMouseListener().leftClicked) {
            game.getMouseListener().leftClicked = false;
            game.getPlayer().setX(1150);
            game.getPlayer().setY(300);
            game.getPlayer().setCurrentRoom(2);
        }
        if(game.getMouseListener().isHovering(640, 680, 16, 16) && game.getMouseListener().leftClicked) {
            game.getMouseListener().leftClicked = false;
            game.getPlayer().setX(1150);
            game.getPlayer().setY(300);
            game.getPlayer().setCurrentRoom(3);
        }

        */

        //Edge Bounds

        if (game.getPlayer().getX() < 0) {
            game.getPlayer().setX(0);
        }
        if (game.getPlayer().getX() > game.width - game.getPlayer().getWidth()) {
            game.getPlayer().setX(game.width - game.getPlayer().getWidth());
        }
        if (game.getPlayer().getY() < 0) {
            game.getPlayer().setY(0);
        }
        if (game.getPlayer().getY() > game.height - game.getPlayer().getHeight()) {
            game.getPlayer().setY(game.height - game.getPlayer().getHeight());
        }


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