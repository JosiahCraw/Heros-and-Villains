package Heroes_Villains.States;

import java.awt.*;
import java.nio.channels.AsynchronousServerSocketChannel;

import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.RadioButtons;
import Heroes_Villains.SystemUI.UIButton;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.entities.heroes.Hero;
import Heroes_Villains.graphics.Assets;
import Heroes_Villains.SystemUI.TextField;
import Heroes_Villains.graphics.DrawText;


public class TeamBuilderState extends State {

    private UIElement backButton2;
    private UIElement startButton;

    private UIElement deleteButton;
    private RadioButtons teamDelete;

    private UIElement heroTypeA;
    private UIElement heroTypeB;
    private UIElement heroTypeC;
    private UIElement heroTypeD;
    private UIElement heroTypeE;
    private UIElement heroTypeF;

    private TextField nameinput;

    private boolean notFull;


    public TeamBuilderState(Game game) {
        super(game);
        backButton2 = new UIButton(540, 650, game, Assets.backButton, 200, 35);
        startButton = new UIButton(540, 580, game, Assets.startButton, 200, 35);

        heroTypeA = new UIButton(11, 450, game, Assets.thiefButton, 200, 35);
        heroTypeB = new UIButton(222, 450, game, Assets.tankButton, 200, 35);
        heroTypeC = new UIButton(433, 450, game, Assets.gamblerButton, 200, 35);
        heroTypeD = new UIButton(644, 450, game, Assets.psychicButton, 200, 35);
        heroTypeE = new UIButton(855, 450, game, Assets.scoutButton, 200, 35);
        heroTypeF = new UIButton(1066, 450, game, Assets.sacrificeButton, 200, 35);

        nameinput = new TextField(540, 250, 200, 25, game, Assets.textField, 10, 2);

        notFull = false;

        deleteButton = new UIButton(1000, 100, game, Assets.deleteButton, 200, 35);




    }

    @Override
    public void update() {
        backButton2.update();
        startButton.update();

        heroTypeA.update();
        heroTypeB.update();
        heroTypeC.update();
        heroTypeD.update();
        heroTypeE.update();
        heroTypeF.update();

        nameinput.update();

        deleteButton.update();




        if (game.getMouseListener().leftClicked && deleteButton.click()) {
            game.getMouseListener().leftClicked = false;
            game.getTeam().remove(game.getTeam().size()-1);
        }


        if (game.getMouseListener().leftClicked && backButton2.click()) {
            game.getMouseListener().leftClicked = false;
            game.getStateHandler().setState(game.getSetupState());
            game.getTeam().clear();
        }

        if (game.getMouseListener().leftClicked && startButton.click()) {
            game.getMouseListener().leftClicked = false;
            if (game.getTeam().size() < game.noOfHeros) {
                notFull = true;
            } else {
                notFull = false;
                game.gameState = new GameState(game);
                game.player = ((GameState) game.gameState).player;
                game.battleState = new BattleState(game);
                game.adminState = new AdminState(game, ((GameState) game.gameState).masterCities, ((BattleState) game.battleState));
                game.getStateHandler().setState(game.getGameState());

                game.getTeam().get(0).setHealth(100);
                game.getTeam().get(1).setHealth(100);
                game.getTeam().get(2).setHealth(100);
            }

        }
    }

    @Override
    public void render(Graphics graphics) {
        backButton2.render(graphics);
        startButton.render(graphics);

        heroTypeA.render(graphics);
        heroTypeB.render(graphics);
        heroTypeC.render(graphics);
        heroTypeD.render(graphics);
        heroTypeE.render(graphics);
        heroTypeF.render(graphics);

        deleteButton.render(graphics);


        graphics.setFont(Assets.smallFont);

        if (heroTypeA.click()) {
            DrawText.draw(game.getGraphics(), "Thief: Steals extra gold from villains", game.width/2, game.height/2, true, Color.BLACK, Assets.smallFont);
            boolean dontAdd = false;
            if (game.getMouseListener().leftClicked) {
                game.getMouseListener().leftClicked = false;
                if (game.getTeam().size() < game.noOfHeros && nameinput.getInput().length() >= 2) {
                    for (Hero h : game.getTeam()) {
                        if (h.getName().equals(nameinput.getInput())) {
                            dontAdd = true;
                        }
                    }
                    if (!dontAdd) {
                        game.getTeam().add(new Hero(100, "Thief", nameinput.getInput()));
                        nameinput.setInput("");
                    }

                }

            }
        }

        if (heroTypeB.click()) {
            DrawText.draw(game.getGraphics(), "Tank: Has extra health", game.width/2, game.height/2, true, Color.BLACK, Assets.smallFont);
            boolean dontAdd = false;
            if (game.getMouseListener().leftClicked) {
                game.getMouseListener().leftClicked = false;
                if (game.getTeam().size() < game.noOfHeros && nameinput.getInput().length() >= 2) {
                    for (Hero h : game.getTeam()) {
                        if (h.getName().equals(nameinput.getInput())) {
                            dontAdd = true;
                        }
                    }
                    if (!dontAdd) {
                        game.getTeam().add(new Hero(200, "Tank", nameinput.getInput()));

                        nameinput.setInput("");
                    }

                }

            }
        }

        if (heroTypeC.click()) {
            DrawText.draw(game.getGraphics(), "Gambler: Has an extra go if he loses", game.width/2, game.height/2, true, Color.BLACK, Assets.smallFont);
            boolean dontAdd = false;
            if (game.getMouseListener().leftClicked) {
                game.getMouseListener().leftClicked = false;
                if (game.getTeam().size() < game.noOfHeros && nameinput.getInput().length() >= 2) {
                    for (Hero h : game.getTeam()) {
                        if (h.getName().equals(nameinput.getInput())) {
                            dontAdd = true;
                        }
                    }
                    if (!dontAdd) {
                        game.getTeam().add(new Hero(100, "Gambler", nameinput.getInput()));
                        nameinput.setInput("");
                    }

                }

            }
        }

        if (heroTypeD.click()) {
            DrawText.draw(game.getGraphics(), "Psychic: Can see the outcome of a game", game.width/2, game.height/2, true, Color.BLACK, Assets.smallFont);
            boolean dontAdd = false;
            if (game.getMouseListener().leftClicked) {
                game.getMouseListener().leftClicked = false;
                if (game.getTeam().size() < game.noOfHeros && nameinput.getInput().length() >= 2) {
                    for (Hero h : game.getTeam()) {
                        if (h.getName().equals(nameinput.getInput())) {
                            dontAdd = true;
                        }
                    }
                    if (!dontAdd) {
                        game.getTeam().add(new Hero(100, "Psychic", nameinput.getInput()));
                        nameinput.setInput("");
                    }

                }

            }
        }

        if (heroTypeE.click()) {
            DrawText.draw(game.getGraphics(), "Scout: Comes with a map but has low health", game.width/2, game.height/2, true, Color.BLACK, Assets.smallFont);
            boolean dontAdd = false;
            if (game.getMouseListener().leftClicked) {
                game.getMouseListener().leftClicked = false;
                if (game.getTeam().size() < game.noOfHeros && nameinput.getInput().length() >= 2) {
                    for (Hero h : game.getTeam()) {
                        if (h.getName().equals(nameinput.getInput())) {
                            dontAdd = true;
                        }
                    }
                    if (!dontAdd) {
                        game.getTeam().add(new Hero(40, "Scout", nameinput.getInput()));
                        nameinput.setInput("");
                    }

                }

            }
        }

        if (heroTypeF.click()) {
            DrawText.draw(game.getGraphics(), "Sacrifice: Can instantly defeat a villain but will die", game.width/2, game.height/2, true, Color.BLACK, Assets.smallFont);
            boolean dontAdd = false;
            if (game.getMouseListener().leftClicked) {
                game.getMouseListener().leftClicked = false;
                if (game.getTeam().size() < game.noOfHeros && nameinput.getInput().length() >= 2) {
                    for (Hero h : game.getTeam()) {
                        if (h.getName().equals(nameinput.getInput())) {
                            dontAdd = true;
                        }
                    }
                    if (!dontAdd) {
                        game.getTeam().add(new Hero(100, "Sacrifice", nameinput.getInput()));
                        nameinput.setInput("");
                    }

                }

            }
        }


        DrawText.draw(game.getGraphics(), "Current Team: " + game.teamName, 640, 50, true, Color.BLACK, Assets.invFont);
        graphics.setFont(Assets.smallFont);

        int i = 0;
        for (Hero hero : game.getTeam()) {
            DrawText.draw(game.getGraphics(), hero.getName() + ": " + hero.getType(), 640, 100 + i, true, Color.BLACK, Assets.smallFont);
            i += 40;
        }



        if (notFull) {
            DrawText.draw(graphics,"Team not full...", game.width/2,  625, true, Color.RED, Assets.smallFont);
        }

        nameinput.render(graphics);


    }
}
