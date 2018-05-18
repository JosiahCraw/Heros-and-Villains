package Heroes_Villains.States;

import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.RadioButtons;
import Heroes_Villains.SystemUI.UIButton;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.graphics.Assets;

import java.awt.*;

public class PauseState extends State{

    private UIElement returnButton, menuButton, radioButtons;

    public PauseState(Game game) {
        super(game);
        radioButtons = new RadioButtons(256, 550, game, Assets.testRadioButton, 2, 25, true, 128, 128);
        returnButton = new UIButton(128, 0, game, Assets.backButton, Assets.buttonWidth, Assets.buttonHeight);
        menuButton = new UIButton(128, 257, game, Assets.menuButton, Assets.buttonWidth, Assets.buttonHeight);
    }

    @Override
    public void update() {
        returnButton.update();
        menuButton.update();
        if(game.getMouseListener().isLeftClicked() && menuButton.click()){
            game.getMouseListener().leftClicked = false;
            game.getStateHandler().setState(game.getMenuState());
        }
        if(game.getMouseListener().isLeftClicked() && returnButton.click()) {
            game.getStateHandler().setState(game.getGameState());
        }
        radioButtons.update();
    }

    @Override
    public void render(Graphics graphics) {
        returnButton.render(graphics);
        menuButton.render(graphics);
        radioButtons.render(graphics);
    }
}
