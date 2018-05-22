package Heroes_Villains.States;

import java.awt.*;
import java.nio.channels.AsynchronousServerSocketChannel;

import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.UIButton;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.entities.heroes.Hero;
import Heroes_Villains.graphics.Assets;
import Heroes_Villains.SystemUI.TextField;


public class TeamBuilderState extends State {

    private UIElement backButton2;

    private UIElement heroTypeA;
    private UIElement heroTypeB;
    private UIElement heroTypeC;
    private UIElement heroTypeD;
    private UIElement heroTypeE;
    private UIElement heroTypeF;

    private TextField nameinput;


    public TeamBuilderState(Game game) {
        super(game);
        backButton2 = new UIButton(540, 650, game, Assets.backButton, 200, 35);

        heroTypeA = new UIButton(200, 550, game, Assets.textField, 50, 50);
        heroTypeB = new UIButton(350, 550, game, Assets.textField, 50, 50);
        heroTypeC = new UIButton(500, 550, game, Assets.textField, 50, 50);
        heroTypeD = new UIButton(650, 550, game, Assets.textField, 50, 50);
        heroTypeE = new UIButton(800, 550, game, Assets.textField, 50, 50);
        heroTypeF = new UIButton(950, 550, game, Assets.textField, 50, 50);

        nameinput = new TextField(500, 175, 200, 25, game, Assets.textField, 10, 2);



    }

    @Override
    public void update() {
        backButton2.update();

        heroTypeA.update();
        heroTypeB.update();
        heroTypeC.update();
        heroTypeD.update();
        heroTypeE.update();
        heroTypeF.update();

        nameinput.update();


        if (game.getMouseListener().leftClicked && backButton2.click()) {
            game.getMouseListener().leftClicked = false;
            game.getStateHandler().setState(game.getSetupState());
            game.getTeam().clear();
        }
    }

    @Override
    public void render(Graphics graphics) {
        backButton2.render(graphics);

        heroTypeA.render(graphics);
        heroTypeB.render(graphics);
        heroTypeC.render(graphics);
        heroTypeD.render(graphics);
        heroTypeE.render(graphics);
        heroTypeF.render(graphics);



        if (heroTypeA.click()) {
            graphics.drawString("Type A", game.width /2, game.height/2);
            if (game.getMouseListener().leftClicked) {
                game.getMouseListener().leftClicked = false;
                if (game.getTeam().size() < game.noOfHeros) {
                    game.getTeam().add(new Hero(100, nameinput.getInput()));
                    nameinput.setInput("");
                }

            }
        }

        graphics.drawString("working", 200, 200);
        int i = 0;
        for (Hero hero : game.getTeam()) {
            graphics.drawString(hero.getType(), 300, 200 + i);
            i += 20;
        }

        nameinput.render(graphics);


    }
}
