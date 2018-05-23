package Heroes_Villains.minigames;

import Heroes_Villains.Game;
import Heroes_Villains.States.BattleState;
import Heroes_Villains.SystemUI.UIButton;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.graphics.Assets;
import Heroes_Villains.graphics.DrawText;
import Heroes_Villains.utils.RandomNum;

import java.awt.*;


public class DiceRoll extends MiniGame {

    private UIElement nextButton;
    public int playerRoll, currHero;

    public DiceRoll(int villainMove, Game game) {
        super(villainMove, game, "Dice Roll");
        nextButton = new UIButton(100, 400, game, Assets.battleStateNext, Assets.buttonWidth, Assets.buttonHeight);
        this.villainMoveWords = Integer.toString(villainMove);
        playerRoll = RandomNum.getNum(6)+1;
        currHero = battleState.getCurrHero();
    }

    @Override
    public void update() {
        currHero = battleState.getCurrHero();
        if (game.getMouseListener().isHovering(55, 520, 150, 66) && game.getMouseListener().leftClicked) {
            game.getMouseListener().leftClicked = false;
            if (villainMove > playerRoll) {
                battleState.lost(currHero);
            }
        }
        if (villainMove == playerRoll) {
            battleState.currMiniGame = new DiceRoll(RandomNum.getNum(6), game);
            return;
        }
        if (playerRoll > villainMove) {
            battleState.won(currHero);
        }
    }

    @Override
    public void render(Graphics graphics) {
        nextButton.render(graphics);
        DrawText.draw(graphics, "Go", 130, 552, true, Color.WHITE, Assets.invFont);
        if(game.getMouseListener().isHovering(55, 520, 150, 66)) {
            DrawText.draw(graphics, "Go", 130, 552, true, Color.YELLOW, Assets.invFont);
        }
    }
}
