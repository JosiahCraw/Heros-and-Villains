package Heroes_Villains.States;

import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.UIButton;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.graphics.Assets;

import java.awt.*;

public class ControlsState extends State {

    private UIElement backButton;

    public ControlsState(Game game) {
        super(game);
        backButton = new UIButton(540, 483, game, Assets.backButton, 200, 35);

    }

    @Override
    public void update() {
        backButton.update();
        if(game.getMouseListener().isLeftClicked() && backButton.click()){
            game.getMouseListener().leftClicked = false;
            game.getStateHandler().setState(game.getMenuState());
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawString("List controls on this page." , 200, 200);
        backButton.render(graphics);
    }
}

