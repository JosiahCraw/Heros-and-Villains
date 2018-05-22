package Heroes_Villains.entities.items;

import Heroes_Villains.Game;
import Heroes_Villains.cities.Citys;
import Heroes_Villains.entities.Player;
import Heroes_Villains.graphics.Assets;

public class ItemHandler {

    public Item basicPotion, advancedPotion, masterPotion, coins;

    public ItemHandler(Game game, Citys citys, Player player) {

        basicPotion = new HealingItem(0, "Basic Potion", Assets.basicPotion, game, citys, 25, 25);
        advancedPotion = new HealingItem(1, "Advanced Potion", Assets.advancedPotion, game, citys, 50, 50);
        masterPotion = new HealingItem(2, "Master Potion", Assets.masterPotion, game, citys, 75, 75);
        //coins = new Coins(3, "Coins", Assets.coin, game, citys, player);
    }
}
