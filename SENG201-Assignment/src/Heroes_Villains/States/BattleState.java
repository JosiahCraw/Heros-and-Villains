package Heroes_Villains.States;

import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.UIButton;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.graphics.Assets;
import Heroes_Villains.minigames.MiniGame;
import Heroes_Villains.minigames.MiniGameHandler;

import java.awt.*;

public class BattleState extends State {

    private UIElement battleButton, backButton;
    public MiniGame currMiniGame;
    public boolean battling;
    private MiniGameHandler miniGameHandler;

    public BattleState(Game game) {
        super(game);
        battleButton = new UIButton(900, 500, game, Assets.battleButton, Assets.buttonWidth, Assets.buttonHeight);
        backButton = new UIButton(900, 600, game, Assets.backButton, Assets.buttonWidth, Assets.buttonHeight);
        battling = false;
        miniGameHandler = new MiniGameHandler(game);
        currMiniGame = null;

    }

    @Override
    public void update() {
        if(!battling) {
            battleButton.update();
            backButton.update();
            if (game.getMouseListener().isLeftClicked() && backButton.click()) {
                game.getMouseListener().leftClicked = false;
                game.getStateHandler().setState(game.getGameState());
                return;
            }
            if (game.getMouseListener().isLeftClicked() && battleButton.click()) {
                game.getMouseListener().leftClicked = false;
                currMiniGame = miniGameHandler.getGame();
                battling = true;
                return;
                /*try {
                    game.getPlayer().setCurrentCity(game.getPlayer().getCurrentCity()+1);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("You won!!");
                }
                game.getPlayer().setCurrentRoom(4);
                game.getPlayer().setY(296);
                game.getPlayer().setX(576);
                game.getStateHandler().setState(game.getGameState());*/
            }
            return;
        }
        currMiniGame.update();
    }

    @Override
    public void render(Graphics graphics) {
        if(!battling){
            graphics.setFont(Assets.titleFont);
            graphics.drawString("Battle State!!!", 550, 400);
            battleButton.render(graphics);
            backButton.render(graphics);
            return;
        }
        currMiniGame.render(graphics);
    }

    public MiniGame getCurrMiniGame() {
        return currMiniGame;
    }
}
