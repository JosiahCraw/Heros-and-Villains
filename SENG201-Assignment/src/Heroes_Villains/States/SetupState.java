package Heroes_Villains.States;

import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.RadioButton;
import Heroes_Villains.SystemUI.RadioButtons;
import Heroes_Villains.SystemUI.UIButton;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.graphics.Assets;

import java.awt.*;

public class SetupState extends State{

    private UIElement backButton;
    private UIElement citySelect;

    public SetupState(Game game) {
        super(game);
        backButton = new UIButton(540, 483, game, Assets.backButton, 200, 35);
        citySelect = new RadioButtons(256, 550, game, Assets.testRadioButton, 2, 25, true, 128, 128);
    }

    @Override
    public void update() {
        backButton.update();
        citySelect.update();
        if(game.getMouseListener().isLeftClicked() && backButton.click()){
            game.getMouseListener().leftClicked = false;
            game.getStateHandler().setState(game.getMenuState());
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawString("Enter Team Name: " , 200, 200);
        graphics.drawString("Pick the number of cities:" , 200, 300);

        backButton.render(graphics);
        citySelect.render(graphics);
    }
    //pass
}
