package Heroes_Villains.States;

import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.RadioButtons;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.graphics.Assets;

import java.awt.*;

public class AdminState extends State{

    private UIElement cityInfoRadio;
    private int buttonClicked;

    public AdminState(Game game) {
        super(game);
        cityInfoRadio = new RadioButtons(50, 50, game, Assets.testRadioButton, game.noOfCities, 50, true, 150, 150);

    }

    @Override
    public void update() {
        cityInfoRadio.update();
        buttonClicked = cityInfoRadio.getCurrentlyClicked();
    }

    @Override
    public void render(Graphics graphics) {
        cityInfoRadio.render(graphics);

    }
}
