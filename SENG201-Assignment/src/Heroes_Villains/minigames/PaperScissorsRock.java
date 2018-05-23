package Heroes_Villains.minigames;

import Heroes_Villains.Game;
import Heroes_Villains.States.BattleState;
import Heroes_Villains.SystemUI.RadioButton;
import Heroes_Villains.SystemUI.RadioButtons;
import Heroes_Villains.SystemUI.UIButton;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.graphics.Assets;
import Heroes_Villains.graphics.DrawText;
import Heroes_Villains.utils.RandomNum;

import java.awt.*;

public class PaperScissorsRock extends MiniGame {

    private UIElement buttons, goButton, nextCityButton;
    private int playerChoice;
    private boolean draw, goHovering, played;
    private int currHero, radioTotalWidth;

    public PaperScissorsRock(int villainMove, Game game) {
        super(villainMove, game, "Paper, Scissors, Rock");
        radioTotalWidth = (game.noOfHeros-1)*25 + 100*game.noOfHeros;
        buttons = new RadioButtons(516-(radioTotalWidth/2), 509, game, Assets.invRadioButton, 3, 25, true, 100, 100);
        nextCityButton = new UIButton(600, 600, game, Assets.backButton, Assets.buttonWidth, Assets.buttonHeight);
        ((RadioButtons) buttons).clicked(0);
        //goButton = new UIButton(100, 400, game, Assets.battleStatePlay, Assets.buttonWidth, Assets.buttonHeight);
        villainLives = 3;
        currHero = battleState.getCurrHero();
        battleWon = false;
        draw = false;
        goHovering = false;
        played = false;
        if(villainMove == 0) {
            this.villainMoveWords = "Paper";
        }else if(villainMove == 1) {
            this.villainMoveWords = "Scissors";
        }else {
            this.villainMoveWords = "Rock";
        }
    }

    @Override
    public void update() {
        currHero = battleState.getCurrHero();
        buttons.update();
        //goButton.update();
        if(played) {
            played = false;
            playerChoice = ((RadioButtons) buttons).currentlyClicked;
            if(villainMove == playerChoice) {
                draw = true;
                ((RadioButtons) buttons).clicked(0);
            }else if(villainMove == 0 && playerChoice == 1) {
                ((BattleState) game.getBattleState()).won(currHero);
            }else if(villainMove == 1 && playerChoice == 2) {
                ((BattleState) game.getBattleState()).won(currHero);
            }else if(villainMove == 2 && playerChoice == 1) {
                ((BattleState) game.getBattleState()).won(currHero);
            }else {
                ((BattleState) game.getBattleState()).lost(currHero);
            }
            played = false;
        }
        if(game.getMouseListener().isHovering(55, 520, 150, 66)) {
            if(game.getMouseListener().leftClicked) {
                game.getMouseListener().leftClicked = false;
                played = true;
            }
        }
        if(draw) {
            played = false;
            battleState.currMiniGame = new PaperScissorsRock(RandomNum.getNum(3), game);
        }
    }

    @Override
    public void render(Graphics graphics) {
        buttons.render(graphics);
        //goButton.render(graphics);
        DrawText.draw(graphics, "Go", 130, 552, true, Color.WHITE, Assets.invFont);
        if(game.getMouseListener().isHovering(55, 520, 150, 66)) {
            DrawText.draw(graphics, "Go", 130, 552, true, Color.YELLOW, Assets.invFont);
        }
        if(draw) {
            DrawText.draw(graphics, "You Both played: " + villainMoveWords + ", Try again", 522, 405, true, Color.WHITE, Assets.invFont);
        }
    }
}
