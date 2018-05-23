package Heroes_Villains.entities.items;

import Heroes_Villains.Game;
import Heroes_Villains.cities.Citys;
import Heroes_Villains.entities.Player;
import Heroes_Villains.entities.heroes.Hero;

import java.awt.image.BufferedImage;

public class Coins extends Item {


    public Coins(int id, String name, BufferedImage image, Game game, Citys cityClass, Player player) {
        super(id, name, image, game, cityClass);
        count = game.getPlayer().money;
    }

    @Override
    public void use(Hero hero) {
        return;
    }

    @Override
    public boolean isUseable() {
        return false;
    }
}
