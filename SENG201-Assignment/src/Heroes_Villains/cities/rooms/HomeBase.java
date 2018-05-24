package Heroes_Villains.cities.rooms;

import Heroes_Villains.Game;
import Heroes_Villains.cities.City;
import Heroes_Villains.entities.DoorWay;
import Heroes_Villains.graphics.Assets;
import Heroes_Villains.graphics.DrawText;

import java.awt.*;

public class HomeBase extends Rooms{

    private DoorWay leftDoor = new DoorWay(game,0, 310, Assets.doorWay, true, 0);
    private DoorWay rightDoor = new DoorWay(game, 1230, 310, Assets.doorWay, true, 2);
    private DoorWay topDoor = new DoorWay(game, 590, 0, Assets.doorWayH, false, 1);
    private DoorWay bottomDoor = new DoorWay(game, 590, 670, Assets.doorWayH, false, 3);
    private boolean hasMap;

    public HomeBase(Game game, City city) {
        super(game);
        roomName = "Home Base";
        hasMap = city.isHasMap();
    }

    @Override
    public void update() {
        hasMap = game.gameState.masterCities.cities[game.getPlayer().getCurrentCity()].isHasMap();
        leftDoor.update();
        rightDoor.update();
        topDoor.update();
        bottomDoor.update();

    }

    @Override
    public void render(Graphics graphics) {
        if(hasMap) {
            DrawText.draw(graphics, game.gameState.masterCities.cities[game.getPlayer().getCurrentCity()].rooms[0].roomName, 100, 300, true, Color.BLACK, Assets.smallFont);
            DrawText.draw(graphics, game.gameState.masterCities.cities[game.getPlayer().getCurrentCity()].rooms[1].roomName, 640, 100, true, Color.BLACK, Assets.smallFont);
            DrawText.draw(graphics, game.gameState.masterCities.cities[game.getPlayer().getCurrentCity()].rooms[2].roomName, 1180, 300, true, Color.BLACK, Assets.smallFont);
            DrawText.draw(graphics, game.gameState.masterCities.cities[game.getPlayer().getCurrentCity()].rooms[3].roomName, 640, 620, true, Color.BLACK, Assets.smallFont);
        }
        graphics.setFont(Assets.titleFont);
        graphics.drawString("Home Base", 650, 400);
        leftDoor.render(graphics);
        rightDoor.render(graphics);
        topDoor.render(graphics);
        bottomDoor.render(graphics);

    }
}