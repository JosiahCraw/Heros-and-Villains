package Heroes_Villains.minigames;

import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.RadioButtons;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.graphics.Assets;

import java.awt.*;

public class GuessTheNumber extends MiniGame {

    private UIElement numberSelector;

    public GuessTheNumber(int trys, int villainLives, int villainMove, Game game) {
        super(trys, villainLives, villainMove, game);
        numberSelector = new RadioButtons(100, 300, game, Assets.testRadioButton, 10, 20, true, 50, 50);
    }

    @Override
    public void update() {
        numberSelector.update();
    }

    @Override
    public void render(Graphics graphics) {
        numberSelector.render(graphics);
    }
}
