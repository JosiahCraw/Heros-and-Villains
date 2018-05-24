package Heroes_Villains.cities.rooms;

import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.PotionTimer;
import Heroes_Villains.entities.DoorWay;
import Heroes_Villains.graphics.Assets;

import java.awt.*;
import java.util.ArrayList;

/**
 * Represents the Hospital room of each city.
 */
public class Hospital extends Rooms{

    /**
     * Creates a new DoorWay object in the room.
     */
    private DoorWay exit = new DoorWay(game,1230, 310, Assets.doorWay, true, 4);

    /**
     * Gets the ArrayList containing the potion timers.
     * @return Returns an ArrayList containing all of the active potion timers.
     */
    public ArrayList<PotionTimer> getTimerList() {
        return  timerList;
    }

    /**
     * Creates a new ArrayList to contain the potion timers.
     */
    public ArrayList<PotionTimer> timerList = new ArrayList<PotionTimer>();

    /**
     * Constructor for the Hospital room.
     * the variable for the name of the room in the abstract room class
     * and initiates the int offset variable.
     *
     * @param game
     */
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
