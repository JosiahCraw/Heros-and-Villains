package Heroes_Villains.entities.items;

import Heroes_Villains.Game;
import Heroes_Villains.cities.Citys;
import Heroes_Villains.graphics.Assets;

public class ItemHandler {

    public Item basicPotion, advancedPotion, masterPotion;

    public ItemHandler(Game game, Citys citys) {

        basicPotion = new HealingItem(0, "Basic Potion", Assets.basicPotion, game, citys);
        advancedPotion = new HealingItem(1, "Advanced Potion", Assets.advancedPotion, game, citys);
        masterPotion = new HealingItem(2, "Master Potion", Assets.masterPotion, game, citys);
    }
}
