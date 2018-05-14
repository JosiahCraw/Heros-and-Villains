package Heroes_Villains.cities.rooms;

import Heroes_Villains.Game;
import Heroes_Villains.graphics.Assets;

import java.awt.*;

public class HomeBase extends Rooms{

    public HomeBase(Game game) {
        super(game);

    }

    @Override
    public void update() {
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
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setFont(Assets.titleFont);
        graphics.drawString("Home Base", 650, 400);
        graphics.drawImage(Assets.black, 1200, 360, null);
        graphics.drawImage(Assets.black, 0, 360, null);
        graphics.drawImage(Assets.black, 640, 0, null);
        graphics.drawImage(Assets.black, 640, 680, null);

    }
}