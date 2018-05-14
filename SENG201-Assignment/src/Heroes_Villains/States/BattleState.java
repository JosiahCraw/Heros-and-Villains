package Heroes_Villains.States;

import Heroes_Villains.Game;
import Heroes_Villains.graphics.Assets;

import java.awt.*;

public class BattleState extends State {

    public BattleState(Game game) {
        super(game);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.setFont(Assets.titleFont);
        graphics.drawString("Battle State!!!", 550, 400);
    }
}
