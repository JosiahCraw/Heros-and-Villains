package Heroes_Villains.minigames;

import Heroes_Villains.Game;
import Heroes_Villains.States.BattleState;
import Heroes_Villains.SystemUI.RadioButtons;
import Heroes_Villains.SystemUI.UIButton;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.graphics.Assets;
import Heroes_Villains.graphics.DrawText;

import java.awt.*;

public class PaperScissorsRock extends MiniGame {

    private UIElement buttons, goButton, nextCityButton;
    private int playerChoice;
    private boolean youWon;
    private int currHero;

    public PaperScissorsRock(int villainMove, Game game) {
        super(villainMove, game, "Paper, Scissors, Rock");
        buttons = new RadioButtons(300, 300, game, Assets.testRadioButton, 3, 25, true, 100, 100);
        nextCityButton = new UIButton(600, 600, game, Assets.backButton, Assets.buttonWidth, Assets.buttonHeight);
        ((RadioButtons) buttons).clicked(0);
        goButton = new UIButton(100, 400, game, Assets.startButton, Assets.buttonWidth, Assets.buttonHeight);
        villainLives = 3;
        currHero = 0; //TODO make heroes choosable;
        if(villainMove == 0) {
            this.villainMoveWords = "Paper";
        }else if(villainMove == 1) {
            this.villainMoveWords = "Scissors";
        }else {
            this.villainMoveWords = "Rock";
        }
        battleWon = false;


    }

    @Override
    public void update() {
        buttons.update();
        goButton.update();
        /*if(!playing) {
            game.getPlayer().setCurrentCity(game.getPlayer().getCurrentCity()+1);
            game.getPlayer().setCurrentRoom(4);
            ((BattleState) game.getBattleState()).battling = false;
            game.getStateHandler().setState(game.getGameState());
        }*/
        if(goButton.click() && game.getMouseListener().leftClicked) {
            game.getMouseListener().leftClicked = false;
            won = false;
            game.getMouseListener().leftClicked = false;
            playerChoice = ((RadioButtons) buttons).currentlyClicked;
            if(villainMove == playerChoice) {
                playing = true;
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
        }
    }

    @Override
    public void render(Graphics graphics) {
        buttons.render(graphics);
        goButton.render(graphics);
        DrawText.draw(graphics, "Rock  Paper  Scissors", 750, 200, true, Color.BLACK, Assets.invFont);
        if(villainMove == playerChoice) {
            DrawText.draw(graphics, "You Both played: " + villainMoveWords + ", Try again", 200, 600, false, Color.BLACK, Assets.invFont);
        }
    }
}
