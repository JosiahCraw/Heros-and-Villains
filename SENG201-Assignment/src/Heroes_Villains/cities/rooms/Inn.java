package Heroes_Villains.cities.rooms;

import Heroes_Villains.Game;
import Heroes_Villains.cities.Citys;
import Heroes_Villains.entities.DoorWay;
import Heroes_Villains.entities.Player;
import Heroes_Villains.entities.npc.InnKeeper;
import Heroes_Villains.graphics.Assets;

import java.awt.*;

public class Inn extends Rooms{

    private DoorWay exit = new DoorWay(game,1230, 310, Assets.doorWay, true, 4);
    private InnKeeper innKeeper;

    public Inn(Game game, Citys cities, Player player) {
        super(game);
        innKeeper = new InnKeeper(640, 120, "Innkeeper", Assets.innkeep, game, cities, player, 72, 100);
        roomName = "Inn";
    }

    @Override
    public void update() {
        exit.update();
        //shop.update();
        innKeeper.update();

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.innFloor, 0, 0, null);
        graphics.drawImage(Assets.inn, 0, 0, null);
        graphics.setColor(Color.WHITE);
        graphics.setFont(Assets.titleFont);
        graphics.drawString("Inn", 650, 400);
        exit.render(graphics);
        innKeeper.render(graphics);
    }

    public InnKeeper getInnKeeper() {
        return innKeeper;
    }
}
