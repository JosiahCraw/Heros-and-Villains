package Heroes_Villains.cities.rooms;

import Heroes_Villains.Game;
import Heroes_Villains.entities.DoorWay;
import Heroes_Villains.entities.npc.Villain;
import Heroes_Villains.graphics.Assets;

import java.awt.*;

public class VillainRoom extends Rooms {

    private DoorWay exit = new DoorWay(game,1230, 310, Assets.doorWay, true, 4);
    private Villain villain = new Villain(50, 328, Assets.villain, 128, 128, game);

    public VillainRoom(Game game) {
        super(game);
        roomName = "Villain's Lair";
    }

    @Override
    public void update() {
        exit.update();
        villain.update();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setFont(Assets.titleFont);
        graphics.drawString("Villain Room", 650, 400);
        exit.render(graphics);
        villain.render(graphics);
    }
}
