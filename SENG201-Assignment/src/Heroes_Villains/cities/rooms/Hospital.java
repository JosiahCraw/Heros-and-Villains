package Heroes_Villains.cities.rooms;

import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.PotionTimer;
import Heroes_Villains.entities.DoorWay;
import Heroes_Villains.graphics.Assets;

import java.awt.*;
import java.util.ArrayList;

public class Hospital extends  Rooms{

    private DoorWay exit = new DoorWay(game,1230, 310, Assets.doorWay, true, 4);

    public ArrayList<PotionTimer> getTimerList() {
        return  timerList;
    }

    public ArrayList<PotionTimer> timerList = new ArrayList<PotionTimer>();

    public Hospital(Game game) {
        super(game);
        roomName = "Hospital";
        int offSet = 0;
        for (int i = 0; i < game.getTeam().size(); i++) {
            timerList.add(new PotionTimer(50, 100 + offSet, game.getTeam().get(i), game, Assets.blankButton));
            offSet += 170;
        }
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
        for (PotionTimer timer : timerList) {
            timer.update();
        }
        exit.update();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setFont(Assets.titleFont);
        graphics.drawString("Hospital", 650, 400);
        //graphics.drawImage(Assets.purple, 1200, 360, null);

        for (PotionTimer timer : timerList) {
            if (timer.getTimeRemaining() > 0) {
                timer.render(graphics);
            }
        }


        exit.render(graphics);
    }
}
