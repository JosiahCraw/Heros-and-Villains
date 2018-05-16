package Heroes_Villains.entities.items;

import Heroes_Villains.Game;
import Heroes_Villains.cities.Citys;
import Heroes_Villains.cities.rooms.PowerUpDen;

import java.awt.image.BufferedImage;

public class PowerUpItem extends Item {

    public PowerUpItem(int id, String name, BufferedImage image, Game game, Citys cityClass) {
        super(id, name, image, game, cityClass);
    }

    public boolean isUseable() {
        try {
            if (cityClass.cities[game.getPlayer().getCurrentCity()].rooms[game.getPlayer().getCurrentRoom()] instanceof PowerUpDen) {
                return true;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return false;
    }
}
