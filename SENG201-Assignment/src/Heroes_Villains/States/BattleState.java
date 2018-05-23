package Heroes_Villains.States;

import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.RadioButtons;
import Heroes_Villains.SystemUI.UIButton;
import Heroes_Villains.SystemUI.UIElement;
import Heroes_Villains.graphics.Assets;
import Heroes_Villains.graphics.DrawText;
import Heroes_Villains.minigames.MiniGame;
import Heroes_Villains.minigames.MiniGameHandler;
import Heroes_Villains.utils.RandomNum;

import java.awt.*;

public class BattleState extends State {

    private UIButton battleButton, backButton, nextCity, okButton, okButton2;
    private RadioButtons heroSelect;
    public MiniGame currMiniGame;
    public boolean battling;
    private MiniGameHandler miniGameHandler;
    private static final int HEALTH_LOST_ON_LOSS = 25;
    private static final int VILLAIN_LIVES = 3;
    private int currLives;
    private boolean won, lost, battleWon, taunting;
    private int currHero, currDead;
    private int radioTotalWidth, taunt;
    private String[] villainNames, villainTaunts;

    public BattleState(Game game) {
        super(game);
        nextCity = new UIButton(640-Assets.buttonWidth/2, 500, game, Assets.battleStateNext, Assets.buttonWidth, Assets.buttonHeight);
        battleButton = new UIButton(640-Assets.buttonWidth/2, 200, game, Assets.battleStateBattle, Assets.buttonWidth, Assets.buttonHeight);
        okButton = new UIButton(640-Assets.buttonWidth/2, 250, game, Assets.battleStateOK, Assets.buttonWidth, Assets.buttonHeight);
        okButton2 = new UIButton(640-Assets.buttonWidth/2, 475, game, Assets.battleStateOK, Assets.buttonWidth, Assets.buttonHeight);
        backButton = new UIButton(640-Assets.buttonWidth/2, 300, game, Assets.battleStateBack, Assets.buttonWidth, Assets.buttonHeight);
        radioTotalWidth = (game.noOfHeros-1)*10 + 50*game.noOfHeros;
        heroSelect = new RadioButtons(1070-(radioTotalWidth/2), 211, game, Assets.invRadioButton, game.noOfHeros, 10, true, 50, 50);
        heroSelect.clicked(0);
        battling = false;
        miniGameHandler = new MiniGameHandler(game);
        villainNames = new String[6];
        villainNames[0] = "Clarence the Vile";
        villainNames[1] = "Snugget the cruel";
        villainNames[2] = "PotatoWhale the scavenger";
        villainNames[3] = "Maccas the temptress";
        villainNames[4] = "Smirnoff the foul";
        villainNames[5] = "Spaceman the pointless";
        villainTaunts = new String[10];
        villainTaunts[0] = "'Just why do you suck?'";
        villainTaunts[1] = "'Wait who?'";
        villainTaunts[2] = "'You are going to be as easy as SENG201'";
        villainTaunts[3] = "'Wait why are you a bat?'";
        villainTaunts[4] = "'Am I just in a pokemon ripoff?'";
        villainTaunts[5] = "'I can just feel how inefficient your code is'";
        villainTaunts[6] = "'You deserve to fail with this'";
        villainTaunts[7] = "'You know software engineering is computer science'";
        villainTaunts[8] = "'I bet you use Mac OS, and you think you know computers'";
        villainTaunts[9] = "'Who uses potions in a hospital?'";
        currMiniGame = null;
        currDead = 0;
        taunting = false;
        won = false;
        lost = false;
    }

    @Override
    public void update() {
        currHero = heroSelect.currentlyClicked;
        if(!battling) {
            battleButton.update();
            backButton.update();
            if (game.getMouseListener().leftClicked && backButton.click()) {
                game.getMouseListener().leftClicked = false;
                game.getStateHandler().setState(game.getGameState());
                return;
            }
            if (game.getMouseListener().leftClicked && battleButton.click()) {
                game.getMouseListener().leftClicked = false;
                won = false;
                lost = false;
                currLives = VILLAIN_LIVES;
                battleWon = false;
                currMiniGame = miniGameHandler.getGame();
                taunt = RandomNum.getNum(10);
                battling = true;
                taunting = true;
            }
            return;
        }
        if(taunting) {
            okButton2.update();
            if(okButton2.click() && game.getMouseListener().leftClicked) {
                game.getMouseListener().leftClicked = false;
                taunting = false;
                battling = true;
                return;
            }
        }
        if(battleWon) {
            nextCity.update();
            if(nextCity.click() && game.getMouseListener().leftClicked) {
                game.getMouseListener().leftClicked = false;
                battling = false;
                battleWon = false;
                won = false;
                lost = false;
                currLives = VILLAIN_LIVES;
                game.getPlayer().setCurrentRoom(4);
                game.getPlayer().setCurrentCity(game.getPlayer().getCurrentCity()+1);
                game.getStateHandler().setState(game.getGameState());
                return;
            }
            return;
        }
        currMiniGame.update();
        heroSelect.update();

        if(won || lost) {
            okButton.update();
            if(okButton.click() && game.getMouseListener().leftClicked) {
                game.getMouseListener().leftClicked = false;
                this.nextGame();
                won = false;
                lost = false;
            }
        }
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
            DrawText.draw(graphics,villainNames[game.getPlayer().getCurrentCity()] + " was defeated", 640, 400, true, Color.WHITE, Assets.smallFont);
            nextCity.render(graphics);
            return;
        }
        if(taunting) {
            graphics.drawImage(Assets.battlePopup, 384, 168, null);
            okButton2.render(graphics);
            DrawText.draw(graphics, "Battling: " + villainNames[game.getPlayer().getCurrentCity()], 640, 350, true, Color.WHITE, Assets.tinyFont);
            DrawText.draw(graphics, villainTaunts[taunt], 640, 400, true, Color.WHITE, Assets.tinyFont);
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

            DrawText.draw(graphics, villainNames[game.getPlayer().getCurrentCity()] + " played:", 640, 350,true, Color.WHITE, Assets.invFont);
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
