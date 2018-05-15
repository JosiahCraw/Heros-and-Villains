package Heroes_Villains.cities;

import Heroes_Villains.Game;
import Heroes_Villains.cities.rooms.*;
import Heroes_Villains.graphics.Assets;
import Heroes_Villains.utils.RandomNum;

import java.awt.*;

public class City {

    public int cityNo;
    public Rooms[] rooms;

    private Game game;

    public Rooms homeBase, hospital, inn, powerUpDen, villainRoom;

    public City(int cityNo, Game game) {
        this.cityNo = cityNo;
        this.game = game;
        rooms = new Rooms[game.noOfCities];
        homeBase = new HomeBase(game);
        hospital = new Hospital(game);
        inn = new Inn(game);
        powerUpDen = new PowerUpDen(game);
        villainRoom = new VillainRoom(game);
        rooms[4] = homeBase;
        init(hospital);
        init(inn);
        init(powerUpDen);
        init(villainRoom);
    }

    public void init(Rooms room) {
        int index = RandomNum.getNum(4);
        while(rooms[index] != null) {
            index = RandomNum.getNum(4);
        }
        rooms[index] = room;
    }

    public void update() {
        rooms[game.getPlayer().getCurrentRoom()].update();
    }
    public void render(Graphics graphics) {
        graphics.setFont(Assets.titleFont);
        graphics.drawString("City: " + Integer.toString(cityNo), 300, 400);
        rooms[game.getPlayer().getCurrentRoom()].render(graphics);

    }
}
