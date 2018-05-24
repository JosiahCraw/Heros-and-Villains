package Heroes_Villains.entities.items;

import Heroes_Villains.Game;
import Heroes_Villains.cities.Citys;
import Heroes_Villains.entities.heroes.Hero;

import java.awt.image.BufferedImage;

public class Map extends Item {

    public Map(int id, String name, BufferedImage image, Game game, Citys cityClass, int cost) {
        super(id, name, image, game, cityClass);
        this.cost = cost;
    }

    @Override
    public void use(Hero hero) {
        count--;
        cityClass.cities[game.getPlayer().getCurrentCity()].setHasMap(true);
    }

    @Override
    public boolean isUseable() {
        return true;
    }
}
