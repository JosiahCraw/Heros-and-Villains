package Heroes_Villains.entities.items;

import Heroes_Villains.Game;
import Heroes_Villains.cities.Citys;
import Heroes_Villains.cities.rooms.PowerUpDen;
import Heroes_Villains.entities.heroes.Hero;

import java.awt.image.BufferedImage;

public class PowerUpItem extends Item {

    private String type;

    public PowerUpItem(int id, String name, BufferedImage image, Game game, Citys cityClass, String type, int cost) {
        super(id, name, image, game, cityClass);
        this.type = type;
        this.cost = cost;
    }

    @Override
    public void use(Hero hero) {
        count --;
        if (type.equals("HEALTH")) {
            hero.setMaxHealth(hero.getMaxHealth() + 50);
        } else if (type.equals("ABILITY")) {
            hero.setAbilityUsed(false);
        } else if (type.equals("SPEED")) {
            game.getPlayer().setSpeed(game.getPlayer().getSpeed() + 10);
        }
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
