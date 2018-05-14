package Heroes_Villains.cities;

import Heroes_Villains.Game;
import Heroes_Villains.cities.rooms.*;
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
        HomeBase homeBase = new HomeBase(game);
        Hospital hospital = new Hospital(game);
        Inn inn = new Inn(game);
        PowerUpDen powerUpDen = new PowerUpDen(game);
        VillainRoom villainRoom = new VillainRoom(game);
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
        rooms[game.getPlayer().currentRoom].update();
    }
    public void render(Graphics graphics) {
        rooms[game.getPlayer().currentRoom].render(graphics);

    }
}
