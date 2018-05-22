package Heroes_Villains.States;

import java.awt.*;
import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.UIButton;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.graphics.Assets;


public class TeamBuilderState extends State {

    private UIElement backButton2;

    public TeamBuilderState(Game game) {
        super(game);
        backButton2 = new UIButton(540, 553, game, Assets.backButton, 200, 35);
    }

    @Override
    public void update() {
        backButton2.update();

        if (game.getMouseListener().leftClicked && backButton2.click()) {
            game.getMouseListener().leftClicked = false;
            game.getStateHandler().setState(game.getSetupState());
        }
    }

    @Override
    public void render(Graphics graphics) {
        backButton2.render(graphics);
        graphics.drawString("working", 200, 200);
    }
}
