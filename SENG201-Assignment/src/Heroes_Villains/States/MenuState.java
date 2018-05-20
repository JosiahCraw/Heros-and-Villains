package Heroes_Villains.States;

import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.UIButton;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.graphics.Assets;

import java.awt.*;

public class MenuState extends State {

    private UIElement startButton;
    private UIElement exitButton;
    private UIElement controlsButton;
    private UIElement testButton;

    public MenuState(Game game) {
        super(game);
        startButton = new UIButton(540, 343, game, Assets.startButton, Assets.buttonWidth, Assets.buttonHeight);
        controlsButton = new UIButton(540, 413, game, Assets.controlsButton, Assets.buttonWidth, Assets.buttonHeight);
        exitButton = new UIButton(540, 483, game, Assets.exitButton, Assets.buttonWidth, Assets.buttonHeight);
        testButton = new UIButton(540, 600, game, Assets.exitButton, Assets.buttonWidth, Assets.buttonHeight);
    }

    @Override
    public void update() {
        startButton.update();
        controlsButton.update();
        exitButton.update();
        testButton.update();
        if(game.getMouseListener().isLeftClicked() && startButton.click()){
            game.getStateHandler().setState(game.getGameState());
        }
        if(game.getMouseListener().isLeftClicked() && exitButton.click()){
            System.exit(0);
        }
        if(game.getMouseListener().isLeftClicked() && controlsButton.click()){
            game.getStateHandler().setState(game.getControlsState());
        }
        if(game.getMouseListener().isLeftClicked() && testButton.click()) {
            game.getStateHandler().setState(game.getSetupState());
        }

    }

    @Override
    public void render(Graphics graphics) {
        startButton.render(graphics);
        exitButton.render(graphics);
        controlsButton.render(graphics);
        testButton.render(graphics);
        graphics.setFont(Assets.titleFont);
        graphics.drawString("Heroes And Villains" , 200, 200);
    }
}
