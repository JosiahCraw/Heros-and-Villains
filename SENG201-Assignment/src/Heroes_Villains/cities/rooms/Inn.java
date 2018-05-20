package Heroes_Villains.cities.rooms;

import Heroes_Villains.Game;
import Heroes_Villains.entities.DoorWay;
import Heroes_Villains.graphics.Assets;

import java.awt.*;

public class Inn extends Rooms{

    private DoorWay exit = new DoorWay(game,1230, 310, Assets.doorWay, true, 4);

    public Inn(Game game) {
        super(game);
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

        exit.update();

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.innFloor, 0, 0, null);
        graphics.drawImage(Assets.inn, 0, 0, null);
        graphics.setColor(Color.WHITE);
        graphics.setFont(Assets.titleFont);
        graphics.drawString("Inn", 650, 400);
        //graphics.drawImage(Assets.purple, 1200, 360, null);
        graphics.drawImage(Assets.innkeep, 576, 70, 72, 100, null);
        exit.render(graphics);
    }
}
