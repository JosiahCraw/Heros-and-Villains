package Heroes_Villains.States;

import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.UIButton;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.graphics.Assets;

import java.awt.*;

public class MenuState extends State {

    private UIElement startButton;

    public MenuState(Game game) {
        super(game);
        startButton = new UIButton(200, 300, game, Assets.testButton, 1024, 256);

    }

    @Override
    public void update() {
        startButton.update();
        if(game.getMouseListener().isLeftClicked() && startButton.click()){
            game.getStateHandler().setState(game.getGameState());
        }

    }

    @Override
    public void render(Graphics graphics) {
        startButton.render(graphics);
    }
}
