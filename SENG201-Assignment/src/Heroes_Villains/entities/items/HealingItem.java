package Heroes_Villains.entities.items;

import Heroes_Villains.Game;
import Heroes_Villains.cities.Citys;
import Heroes_Villains.cities.rooms.Hospital;

import java.awt.image.BufferedImage;

public class HealingItem extends Item {

    private int healthAmount;

    public HealingItem(int id, String name, BufferedImage image, Game game, Citys cityClass, int healthAmount) {
        super(id, name, image, game, cityClass);
        this.healthAmount = healthAmount;
    }

    @Override
    public void use() {
        System.out.println("Used " + name);
        count--;
    }

    public boolean isUseable() {
        try {

            if (cityClass.cities[game.getPlayer().getCurrentCity()].getRooms()[game.getPlayer().getCurrentRoom()] instanceof Hospital) {
                return true;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return false;
    }
}
