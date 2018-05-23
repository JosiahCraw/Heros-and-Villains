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

    private UIElement battleButton, backButton, nextCity, okButton;
    private RadioButtons heroSelect;
    public MiniGame currMiniGame;
    public boolean battling;
    private MiniGameHandler miniGameHandler;
    private static final int HEALTH_LOST_ON_LOSS = 25;
    private static final int VILLAIN_LIVES = 3;
    private int currLives;
    private boolean won, lost, battleWon;
    private int currHero, currDead;
    private int radioTotalWidth;

    public BattleState(Game game) {
        super(game);
        nextCity = new UIButton(640-Assets.buttonWidth/2, 500, game, Assets.battleStateNext, Assets.buttonWidth, Assets.buttonHeight);
        battleButton = new UIButton(640-Assets.buttonWidth/2, 200, game, Assets.battleStateBattle, Assets.buttonWidth, Assets.buttonHeight);
        okButton = new UIButton(640-Assets.buttonWidth/2, 300, game, Assets.battleStateOK, Assets.buttonWidth, Assets.buttonHeight);
        backButton = new UIButton(640-Assets.buttonWidth/2, 300, game, Assets.battleStateBack, Assets.buttonWidth, Assets.buttonHeight);
        radioTotalWidth = (game.noOfHeros-1)*10 + 50*game.noOfHeros;
        heroSelect = new RadioButtons(1070-(radioTotalWidth/2), 211, game, Assets.invRadioButton, game.noOfHeros, 10, true, 50, 50);
        heroSelect.clicked(0);
        battling = false;
        miniGameHandler = new MiniGameHandler(game);
        currMiniGame = null;
        currDead = 0;
        won = false;
        lost = false;
    }

    @Override
    public void update() {
        currHero = heroSelect.currentlyClicked;
        if(!battling) {
            battleButton.update();
            backButton.update();
            if (game.getMouseListener().isLeftClicked() && backButton.click()) {
                game.getMouseListener().leftClicked = false;
                game.getStateHandler().setState(game.getGameState());
                return;
            }
            if (game.getMouseListener().isLeftClicked() && battleButton.click()) {
                won = false;
                lost = false;
                currLives = VILLAIN_LIVES;
                battleWon = false;
                game.getMouseListener().leftClicked = false;
                currMiniGame = miniGameHandler.getGame();
                battling = true;
            }
            return;
        }
        if(battleWon) {
            nextCity.update();
            if(nextCity.click() && game.getMouseListener().leftClicked) {
                battling = false;
                battleWon = false;
                won = false;
                lost = false;
                currLives = VILLAIN_LIVES;
                game.getMouseListener().leftClicked = false;
                game.getPlayer().setCurrentRoom(4);
                game.getPlayer().setCurrentCity(game.getPlayer().getCurrentCity()+1);
                game.getStateHandler().setState(game.getGameState());
                return;
            }
            return;
        }
        if(won || lost) {
            okButton.update();
            if(okButton.click() && game.getMouseListener().leftClicked) {
                game.getMouseListener().leftClicked = false;
                this.nextGame();
                won = false;
                lost = false;
            }
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
        if(battleWon) {
            graphics.drawImage(Assets.battlePopup, 384, 168, null);
            nextCity.render(graphics);
            return;
        }
        DrawText.draw(graphics, currMiniGame.gameName, 1070, 80, true, Color.WHITE, Assets.battleFont);
        DrawText.draw(graphics, "Hero: " + game.getTeam().get(currHero).getName(), 1065, 347, true, Color.WHITE, Assets.smallFont);
        DrawText.draw(graphics, "Health: " + Integer.toString(game.getTeam().get(currHero).getHealth()), 1065, 407, true, Color.WHITE, Assets.smallFont);
        heroSelect.render(graphics);
        currMiniGame.render(graphics);
        if(won) {
            graphics.drawImage(Assets.battlePopup, 384, 168, null);
            okButton.render(graphics);
            DrawText.draw(graphics, "The villain played:", 640, 350,true, Color.WHITE, Assets.invFont);
            DrawText.draw(graphics, currMiniGame.villainMoveWords, 640, 400,true, Color.WHITE, Assets.invFont);
            DrawText.draw(graphics, " and you beat him", 640, 450,true, Color.WHITE, Assets.invFont);
        }
        if(lost) {
            graphics.drawImage(Assets.battlePopup, 384, 168, null);
            okButton.render(graphics);
            DrawText.draw(graphics, "The villain played:", 640, 350,true, Color.WHITE, Assets.invFont);
            DrawText.draw(graphics, currMiniGame.villainMoveWords, 640, 400,true, Color.WHITE, Assets.invFont);
            DrawText.draw(graphics, " and you lost", 640, 450,true, Color.WHITE, Assets.invFont);
        }

        DrawText.draw(graphics, "Villain lives remaining: " + Integer.toString(currLives), 376, 97, true, Color.WHITE, Assets.smallFont);
    }

    public void won(int hero) {
        currLives -= 1;
        if(currLives <= 0) {
            currLives = 0;
            battleWon = true;
            return;
        }
        won = true;
    }

    public void lost(int hero) {
        game.getTeam().get(hero).setHealth(game.getTeam().get(hero).getHealth()-HEALTH_LOST_ON_LOSS);
        battleWon = false;
        lost = true;
        if(game.getTeam().get(hero).getHealth() <= 0) {
            game.getTeam().get(currHero).setHealth(0);
            game.getTeam().get(hero).setDead(true);
            currDead++;
            if(currDead == game.getNoOfHeros()) {
                //TODO game.endGame();
            }
        }

    }

    public void nextGame() {
        MiniGameHandler tempHandler = new MiniGameHandler(game);
        currMiniGame = tempHandler.getGame();
    }

    public void winBattle() {

    }

    public void loseBattle() {

    }

    public MiniGame getCurrMiniGame() {
        return currMiniGame;
    }

    public int getCurrHero() {
        return currHero;
    }
}
