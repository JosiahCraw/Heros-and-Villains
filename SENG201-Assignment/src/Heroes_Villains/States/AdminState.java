package Heroes_Villains.States;

import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.RadioButtons;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.graphics.Assets;
import Heroes_Villains.graphics.DrawText;

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
        buttonClicked = ((RadioButtons) cityInfoRadio).currentlyClicked;
    }

    @Override
    public void render(Graphics graphics) {
        cityInfoRadio.render(graphics);
        DrawText.draw(graphics, game.miniGameHandler.miniGames[buttonClicked].gameName, 600, 300, true, Color.BLACK, Assets.invFont);
        DrawText.draw(graphics, game.miniGameHandler.miniGames[buttonClicked].villainMoveWords, 600, 400, true, Color.BLACK, Assets.invFont);

    }
}
