package Heroes_Villains.States;

import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.RadioButtons;
import Heroes_Villains.SystemUI.UIButton;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.graphics.Assets;
import Heroes_Villains.graphics.DrawText;
import Heroes_Villains.minigames.MiniGame;
import Heroes_Villains.minigames.MiniGameHandler;

import java.awt.*;

public class BattleState extends State {

    private UIElement battleButton, backButton, nextCity;
    private RadioButtons heroSelect;
    public MiniGame currMiniGame;
    public boolean battling;
    private MiniGameHandler miniGameHandler;
    private static final int HEALTH_LOST_ON_LOSS = 25;
    private static final int VILLAIN_LIVES = 3;
    private int currLives;
    private boolean battleWon;
    private int currHero;
    private int radioTotalWidth;

    public BattleState(Game game) {
        super(game);
        battleButton = new UIButton(640-Assets.buttonWidth/2, 200, game, Assets.battleStateBattle, Assets.buttonWidth, Assets.buttonHeight);
        backButton = new UIButton(640-Assets.buttonWidth/2, 300, game, Assets.battleStateBack, Assets.buttonWidth, Assets.buttonHeight);
        nextCity = new UIButton(game.width/2-Assets.buttonWidth, 150, game, Assets.backButton, Assets.buttonWidth, Assets.buttonHeight);
        radioTotalWidth = (game.noOfHeros-1)*10 + 50*game.noOfHeros;
        heroSelect = new RadioButtons(1070-(radioTotalWidth/2), 236, game, Assets.testRadioButton, game.noOfHeros, 10, true, 100, 100);
        battling = false;
        miniGameHandler = new MiniGameHandler(game);
        currMiniGame = null;
    }

    @Override
    public void update() {
        if(!battling) {
            battleButton.update();
            backButton.update();
            if (game.getMouseListener().isLeftClicked() && backButton.click()) {
                game.getMouseListener().leftClicked = false;
                game.getStateHandler().setState(game.getGameState());
                return;
            }
            if (game.getMouseListener().isLeftClicked() && battleButton.click()) {
                currLives = VILLAIN_LIVES;
                battleWon = false;
                game.getMouseListener().leftClicked = false;
                currMiniGame = miniGameHandler.getGame();
                battling = true;
                /*try {
                    game.getPlayer().setCurrentCity(game.getPlayer().getCurrentCity()+1);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("You won!!");
                }
                game.getPlayer().setCurrentRoom(4);
                game.getPlayer().setY(296);
                game.getPlayer().setX(576);
                game.getStateHandler().setState(game.getGameState());*/
            }
            return;
        }
        currMiniGame.update();
        heroSelect.update();
    }

    @Override
    public void render(Graphics graphics) {
        heroSelect.render(graphics);
        graphics.drawImage(Assets.battleState, 0, 0, null);
        if(!battling){
            graphics.drawImage(Assets.battlePopup, 384, 168, null);
            battleButton.render(graphics);
            backButton.render(graphics);
            return;
        }
        DrawText.draw(graphics, currMiniGame.gameName, 1070, 80, true, Color.WHITE, Assets.invFont);
        DrawText.draw(graphics, "Hero: " + game.getTeam().get(currHero).getName(), 1065, 347, true, Color.WHITE, Assets.smallFont);
        DrawText.draw(graphics, "Health: " + Integer.toString(game.getTeam().get(currHero).getHealth()), 1065, 407, true, Color.WHITE, Assets.smallFont);
        heroSelect.render(graphics);
        currMiniGame.render(graphics);
    }

    public void won(int hero) {
        currLives--;
        if(currLives <= 0) {
            battleWon = true;
        }
        currMiniGame = miniGameHandler.getGame();
    }

    public void lost(int hero) {
        game.getTeam().get(hero).setHealth(game.getTeam().get(hero).getHealth()-HEALTH_LOST_ON_LOSS);
        battleWon = false;
        if(game.getTeam().get(hero).getHealth() <= 0) {
            game.getTeam().get(hero).setDead(true);
        }
        currMiniGame = miniGameHandler.getGame();
    }

    public MiniGame getCurrMiniGame() {
        return currMiniGame;
    }
}
