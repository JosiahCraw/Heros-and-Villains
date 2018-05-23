package Heroes_Villains.minigames;

import Heroes_Villains.Game;
import Heroes_Villains.States.BattleState;
import Heroes_Villains.SystemUI.UIButton;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.graphics.Assets;
import Heroes_Villains.utils.RandomNum;

import java.awt.*;


public class DiceRoll extends MiniGame {

    private UIElement rollButton, nextButton;
    public int playerRoll;
    private boolean playing, played;

    public DiceRoll(int villainMove, Game game) {
        super(villainMove, game, "Dice Roll");
        playing = false;
        played = false;
        rollButton = new UIButton(100, 300, game, Assets.startButton, Assets.buttonWidth, Assets.buttonHeight);
        nextButton = new UIButton(100, 400, game, Assets.backButton, Assets.buttonWidth, Assets.buttonHeight);
        this.villainMoveWords = Integer.toString(villainMove);
        playerRoll = RandomNum.getNum(6)+1;
    }

    @Override
    public void update() {
        rollButton.update();
        nextButton.update();
        if(rollButton.click() && game.getMouseListener().leftClicked) {
            playing = true;
            game.getMouseListener().leftClicked = false;
            if(villainMove > playerRoll) {
                System.out.println("You Lose");
                playing = true;
                played = false;
                if(nextButton.click() && game.getMouseListener().leftClicked) {
                    game.getMouseListener().leftClicked = false;
                    game.getPlayer().setCurrentRoom(4);
                    game.getPlayer().setCurrentCity(game.getPlayer().getCurrentRoom()+1);
                }

            }
            if(villainMove == playerRoll) {
                System.out.println("Draw!");
                playerRoll = RandomNum.getNum(6)+1;
                villainMove = RandomNum.getNum(6)+1;
            }
            if(playerRoll > villainMove) {
                System.out.println("You Won!");
                playing = true;
                played = true;
            }

            }
            if(nextButton.click() && game.getMouseListener().leftClicked) {
                game.getMouseListener().leftClicked = false;
                game.getPlayer().setCurrentRoom(4);
                game.getPlayer().setCurrentCity(game.getPlayer().getCurrentCity()+1);
                ((BattleState) game.getBattleState()).battling = false;
                game.getStateHandler().setState(game.getGameState());
        }

    }

    @Override
    public void render(Graphics graphics) {
        rollButton.render(graphics);
        nextButton.render(graphics);
        if(playing) {
            if(villainMove == playerRoll) {
                return;
            }
            if(villainMove > playerRoll) {
                //nextButton.render(graphics);
            }
            if(playerRoll > villainMove) {
                //nextButton.render(graphics);
            }
        }
    }
}
