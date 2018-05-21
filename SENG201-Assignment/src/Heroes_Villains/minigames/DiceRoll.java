package Heroes_Villains.minigames;

import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.UIButton;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.graphics.Assets;

import java.awt.*;

public class DiceRoll extends MiniGame {

    private UIElement rollButton;

    public DiceRoll(int villainMove, Game game) {
        super(villainMove, game, "Dice Roll");
        rollButton = new UIButton(100, 300, game, Assets.backButton, Assets.buttonWidth, Assets.buttonHeight);
        this.villainMoveWords = Integer.toString(villainMove);
    }

    @Override
    public void update() {
        rollButton.update();
    }

    @Override
    public void render(Graphics graphics) {
        rollButton.render(graphics);
    }
}
