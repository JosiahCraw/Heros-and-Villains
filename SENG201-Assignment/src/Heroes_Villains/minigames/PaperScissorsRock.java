package Heroes_Villains.minigames;

import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.RadioButtons;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.graphics.Assets;

import java.awt.*;

public class PaperScissorsRock extends MiniGame {

    private UIElement buttons;

    public PaperScissorsRock(int villainMove, Game game) {
        super(villainMove, game, "Paper, Scissors, Rock");
        buttons = new RadioButtons(100, 300, game, Assets.testRadioButton, 3, 10, true, 100, 100);
        if(villainMove == 0) {
            this.villainMoveWords = "Rock";
        }else if(villainMove == 1) {
            this.villainMoveWords = "Scissors";
        }else {
            this.villainMoveWords = "Rock";
        }
    }

    @Override
    public void update() {
        buttons.update();
    }

    @Override
    public void render(Graphics graphics) {
        buttons.render(graphics);

    }
}
