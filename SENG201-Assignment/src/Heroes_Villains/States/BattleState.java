package Heroes_Villains.States;

import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.UIButton;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.graphics.Assets;
import Heroes_Villains.graphics.DrawText;
import Heroes_Villains.minigames.MiniGame;
import Heroes_Villains.minigames.MiniGameHandler;

import java.awt.*;

public class BattleState extends State {

    private UIElement battleButton, backButton, nextCity;
    public MiniGame currMiniGame;
    public boolean battling;
    private MiniGameHandler miniGameHandler;
    private static final int HEALTH_LOST_ON_LOSS = 25;
    private static final int VILLAIN_LIVES = 3;
    private int currLives;
    private boolean battleWon;

    public BattleState(Game game) {
        super(game);
        battleButton = new UIButton(900, 500, game, Assets.battleButton, Assets.buttonWidth, Assets.buttonHeight);
        backButton = new UIButton(900, 600, game, Assets.backButton, Assets.buttonWidth, Assets.buttonHeight);
        nextCity = new UIButton(game.width/2-Assets.buttonWidth, 150, game, Assets.backButton, Assets.buttonWidth, Assets.buttonHeight);
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
                currLives = VILLAIN_LIVES;
                battleWon = false;
                game.getStateHandler().setState(game.getGameState());
                return;
            }
            if (game.getMouseListener().isLeftClicked() && battleButton.click()) {
                game.getMouseListener().leftClicked = false;
                currMiniGame = miniGameHandler.getGame();
                battling = true;
                return;
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
        if(battleWon) {

        }
        currMiniGame.update();
    }

    @Override
    public void render(Graphics graphics) {
        if(!battling){
            graphics.setFont(Assets.titleFont);
            graphics.drawString("Battle State!!!", 550, 400);
            battleButton.render(graphics);
            backButton.render(graphics);
            return;
        }
        if(battleWon) {
            DrawText.draw(graphics, "You won the battle!!", game.width/2, 50, true, Color.BLACK, Assets.titleFont);
        }
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
