package Heroes_Villains.minigames;

import Heroes_Villains.Game;
import Heroes_Villains.States.BattleState;
import Heroes_Villains.SystemUI.RadioButtons;
import Heroes_Villains.SystemUI.UIButton;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.graphics.Assets;

import java.awt.*;

public class GuessTheNumber extends MiniGame {

    private UIElement numberSelector, playButton;
    public int numMoves;

    public GuessTheNumber(int villainMove, Game game) {
        super(villainMove, game, "Guess the number");
        numberSelector = new RadioButtons(100, 300, game, Assets.testRadioButton, 10, 20, true, 50, 50);
        ((RadioButtons) numberSelector).currentlyClicked = 0;
        playButton = new UIButton(150, 500, game, Assets.backButton, Assets.buttonWidth, Assets.buttonHeight);
        this.villainMoveWords = Integer.toString(villainMove);
        numMoves = 2;
    }

    @Override
    public void update() {
        numberSelector.update();
        playButton.update();
        if(playButton.click() && game.getMouseListener().leftClicked && numMoves > 0) {
            numMoves--;
            game.getMouseListener().leftClicked = false;
            if(((RadioButtons) numberSelector).currentlyClicked+1 == villainMove) {
                System.out.println("You Won!");
                game.getPlayer().setCurrentCity(game.getPlayer().getCurrentCity()+1);
                game.getPlayer().setCurrentRoom(4);
                ((BattleState) game.getBattleState()).battling = false;
                game.getStateHandler().setState(game.getGameState());
            }else if(((RadioButtons) numberSelector).currentlyClicked+1 > villainMove) {
                if(numMoves>1){System.out.println("Less");}
            }else if(((RadioButtons) numberSelector).currentlyClicked+1 < villainMove) {
                if(numMoves>1){System.out.println("More");}
            }
        }else if(numMoves <= 0) {
            System.out.println("Out of attempts");
        }
    }

    @Override
    public void render(Graphics graphics) {
        numberSelector.render(graphics);
        playButton.render(graphics);
    }
}
