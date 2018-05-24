package Heroes_Villains.cities.rooms;

import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.PotionTimer;
import Heroes_Villains.entities.DoorWay;
import Heroes_Villains.graphics.Assets;

import java.awt.*;

public class Hospital extends  Rooms{

    private DoorWay exit = new DoorWay(game,1230, 310, Assets.doorWay, true, 4);

    public PotionTimer getTest() {
        return test;
    }

    public PotionTimer test = new PotionTimer(200,200,game.getTeam().get(0),game,Assets.deleteButton);


    public Hospital(Game game) {
        super(game);
        roomName = "Hospital";
    }

    @Override
    public void update() {
        /*
        if(game.getMouseListener().isHovering(1200, 360, 16, 16) && game.getMouseListener().leftClicked) {
            game.getMouseListener().leftClicked = false;
            game.getPlayer().setX(576);
            game.getPlayer().setY(296);
            game.getPlayer().setCurrentRoom(4);
        }
        */
        test.update();
        exit.update();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setFont(Assets.titleFont);
        graphics.drawString("Hospital", 650, 400);
        //graphics.drawImage(Assets.purple, 1200, 360, null);
        test.render(graphics);
        exit.render(graphics);
    }
}
