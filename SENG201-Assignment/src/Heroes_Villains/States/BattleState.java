package Heroes_Villains.States;

import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.UIButton;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.graphics.Assets;

import java.awt.*;

public class BattleState extends State {

    private UIElement battleButton;

    public BattleState(Game game) {
        super(game);
        battleButton = new UIButton(100, 500, game, Assets.battleButton, Assets.buttonWidth, Assets.buttonHeight);
    }

    @Override
    public void update() {
        battleButton.update();
        if(game.getMouseListener().isLeftClicked() && battleButton.click()) {
            try {
                game.getPlayer().setCurrentCity(game.getPlayer().getCurrentCity()+1);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("You won!!");
            }
            game.getPlayer().setCurrentRoom(4);
            game.getPlayer().setY(296);
            game.getPlayer().setX(576);
            game.getStateHandler().setState(game.getGameState());
        }
        game.miniGameHandler.miniGames[game.getPlayer().getCurrentCity()].update();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setFont(Assets.titleFont);
        graphics.drawString("Battle State!!!", 550, 400);
        battleButton.render(graphics);
        game.miniGameHandler.miniGames[game.getPlayer().getCurrentCity()].render(graphics);
    }
}
