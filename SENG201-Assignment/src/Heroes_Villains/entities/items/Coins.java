package Heroes_Villains.entities.items;

import Heroes_Villains.Game;
import Heroes_Villains.cities.Citys;
import Heroes_Villains.entities.Player;

import java.awt.image.BufferedImage;

public class Coins extends Item {

    public int count;

    public Coins(int id, String name, BufferedImage image, Game game, Citys cityClass, Player player) {
        super(id, name, image, game, cityClass);
        count = player.money;
    }

    @Override
    public void use() {
        return;
    }

    @Override
    public boolean isUseable() {
        return false;
    }
}
