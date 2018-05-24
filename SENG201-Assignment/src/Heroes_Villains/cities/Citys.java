package Heroes_Villains.cities;

import Heroes_Villains.Game;
import Heroes_Villains.entities.Player;

import java.awt.*;

public class Citys {

    public int noOfCities;
    public Game game;
    public City[] cities;
    private Player player;

    /**
     * Constructor setting the chosen number of cities to the length
     * of the city object array.
     *
     * The init method is then called.
     *
     * @param game object containing all of the objects and variables in the game.
     * @param player object containing all of the objects and variables to do with player.
     */
    public Citys(Game game, Player player) {
        this.game = game;
        this.player = player;
        noOfCities = game.noOfCities;
        cities = new City[game.noOfCities];
        init();
    }

    /**
     * Cycles through the empty City array and adds a new city
     * at each index.
     */
    public void init() {
        for(int x=0; x < noOfCities; x++) {
            City tempCity = new City(x, game, this, player);
            cities[x] = tempCity;
        }
    }

    /**
     * Calls the update method for the city at the index the
     * player is currently in.
     */
    public void update() {
        cities[game.getPlayer().getCurrentCity()].update();
    }

    /**
     * Calls the render method for the city at the index the
     * player is currently in.
     * @param graphics
     */
    public void render(Graphics graphics) {
        cities[game.getPlayer().getCurrentCity()].render(graphics);
    }
}
