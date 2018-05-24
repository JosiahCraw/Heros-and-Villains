package Heroes_Villains.cities;

import Heroes_Villains.Game;
import Heroes_Villains.entities.Player;

import java.awt.*;

public class Citys {

    public int noOfCities;
    public Game game;
    public City[] cities;
    private Player player;

    public Citys(Game game, Player player) {
        this.game = game;
        this.player = player;
        noOfCities = game.noOfCities;
        cities = new City[game.noOfCities];
        init();
    }

    public void init() {
        for(int x=0; x < noOfCities; x++) {
             City tempCity = new City(x, game, this, player);
             cities[x] = tempCity;
        }
    }

    public void update() {
        cities[game.getPlayer().getCurrentCity()].update();
    }

    public void render(Graphics graphics) {
        cities[game.getPlayer().getCurrentCity()].render(graphics);
    }
}
