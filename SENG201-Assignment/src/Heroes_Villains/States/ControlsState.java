package Heroes_Villains.States;

import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.UIButton;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.graphics.Assets;
import Heroes_Villains.graphics.DrawText;

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

        DrawText.draw(game.getGraphics(), "Move player up -----------> W      ", game.width/2, (game.height/2)-200, true, Color.BLACK, Assets.smallFont);
        DrawText.draw(game.getGraphics(), "Move player down ---------> S      ", game.width/2, (game.height/2)-170, true, Color.BLACK, Assets.smallFont);
        DrawText.draw(game.getGraphics(), "Move player left ---------> A      ", game.width/2, (game.height/2)-140, true, Color.BLACK, Assets.smallFont);
        DrawText.draw(game.getGraphics(), "Move player right --------> D      ", game.width/2, (game.height/2)-110, true, Color.BLACK, Assets.smallFont);
        DrawText.draw(game.getGraphics(), "Interact -----------------> F      ", game.width/2, (game.height/2)-80, true, Color.BLACK, Assets.smallFont);
        DrawText.draw(game.getGraphics(), "Open inventory -----------> E      ", game.width/2, (game.height/2)-50, true, Color.BLACK, Assets.smallFont);
        DrawText.draw(game.getGraphics(), "Open pause menu ----------> ESCAPE ", game.width/2, (game.height/2)-20, true, Color.BLACK, Assets.smallFont);
        DrawText.draw(game.getGraphics(), "Team stats (homebase) ----> H      ", game.width/2, (game.height/2)+10, true, Color.BLACK, Assets.smallFont);
        DrawText.draw(game.getGraphics(), "Admin commands -----------> CONTROL", game.width/2, (game.height/2)+40, true, Color.BLACK, Assets.smallFont);
        backButton.render(graphics);
    }
}

