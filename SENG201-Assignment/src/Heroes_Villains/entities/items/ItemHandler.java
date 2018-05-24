package Heroes_Villains.entities.items;

import Heroes_Villains.Game;
import Heroes_Villains.cities.Citys;
import Heroes_Villains.entities.Player;
import Heroes_Villains.graphics.Assets;

public class ItemHandler {

    public Item basicPotion, advancedPotion, masterPotion, coins, speedScroll, healthScroll, abilityScroll, map;

    public ItemHandler(Game game, Citys citys, Player player) {

        basicPotion = new HealingItem(0, "Basic Potion", Assets.basicPotion, game, citys, 20, 25, 40);
        advancedPotion = new HealingItem(1, "Advanced Potion", Assets.advancedPotion, game, citys, 40, 50, 20);
        masterPotion = new HealingItem(2, "Master Potion", Assets.masterPotion, game, citys, 80, 75, 4);
        //coins = new Coins(3, "Coins", Assets.coin, game, citys, player);

        map = new Map(6, "Map", Assets.map, game, citys, 30);

        speedScroll = new PowerUpItem(3, "Speed Scroll", Assets.greenScroll, game, citys,"SPEED", 25);
        healthScroll = new PowerUpItem(4, "Health Scroll", Assets.redScroll, game, citys, "HEALTH", 20);
        abilityScroll = new PowerUpItem(5, "Ability Scroll", Assets.blueScroll, game, citys, "ABILITY", 50);
    }
}
