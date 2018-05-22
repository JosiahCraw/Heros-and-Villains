package Heroes_Villains.States;

import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.RadioButton;
import Heroes_Villains.SystemUI.RadioButtons;
import Heroes_Villains.SystemUI.TextField;
import Heroes_Villains.SystemUI.UIButton;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.graphics.Assets;
import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;

import javax.swing.*;
import java.awt.*;

public class SetupState extends State{

    private UIElement backButton;
    private UIElement citySelect;
    private UIElement heroSelect;
    private UIElement entry;


    public SetupState(Game game) {
        super(game);
        backButton = new UIButton(540, 483, game, Assets.backButton, 200, 35);
        citySelect = new RadioButtons(900, 268, game, Assets.testRadioButton, 4, 25, true, 32, 32);
        heroSelect = new RadioButtons(900, 368, game, Assets.testRadioButton, 3, 25, true, 32, 32);
        entry = new TextField(500, 175, 200, 25, game, Assets.textField, 10, 2);

    }

    @Override
    public void update() {
        backButton.update();
        citySelect.update();
        heroSelect.update();
        entry.update();

        if(game.getMouseListener().isLeftClicked() && backButton.click()){
            game.getMouseListener().leftClicked = false;
            game.getStateHandler().setState(game.getMenuState());
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setFont(Assets.smallFont);
        graphics.drawString("Enter Team Name: " , 200, 200);
        graphics.drawString("Pick the number of cities:" , 200, 300);
        graphics.drawString("Pick the amount of heros on your team:", 200, 400);



        backButton.render(graphics);
        citySelect.render(graphics);
        heroSelect.render(graphics);
        entry.render(graphics);
    }
    //pass
}
