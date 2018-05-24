package Heroes_Villains.cities;

import Heroes_Villains.Game;
import Heroes_Villains.cities.rooms.*;
import Heroes_Villains.entities.Player;
import Heroes_Villains.graphics.Assets;
import Heroes_Villains.utils.RandomNum;

import java.awt.*;

public class City {

    public int cityNo;
    public Rooms[] rooms;
    private boolean hasMap;

    private Game game;

    public Rooms homeBase, inn, powerUpDen, villainRoom;
    public Hospital hospital;

    public City(int cityNo, Game game, Citys cities, Player player) {
        this.cityNo = cityNo;
        this.game = game;
        rooms = new Rooms[5];
        homeBase = new HomeBase(game, this);
        hospital = new Hospital(game);
        inn = new Inn(game, cities, player);
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
        for(int i=0; i<game.getTeam().size(); i++) {
            if(game.getTeam().get(i).getType() == "Scout") {
                hasMap = true;
            }
        }
        rooms[game.getPlayer().getCurrentRoom()].update();
    }
    public void render(Graphics graphics) {
        graphics.setFont(Assets.titleFont);
        graphics.drawString("City: " + Integer.toString(cityNo+1), 300, 400);
        rooms[game.getPlayer().getCurrentRoom()].render(graphics);

    }

    public Rooms[] getRooms() {
        return rooms;
    }

    public boolean isHasMap() {
        return hasMap;
    }

    public void setHasMap(boolean hasMap) {
        this.hasMap = hasMap;
    }
}
