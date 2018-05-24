package Heroes_Villains.States;

import Heroes_Villains.Game;
import Heroes_Villains.SystemUI.UIButton;
import Heroes_Villains.graphics.Assets;
import Heroes_Villains.graphics.DrawText;

import java.awt.*;

public class EndState extends State {

    private UIButton exitButton = new UIButton(540, 650,game, Assets.exitButton, Assets.buttonWidth, Assets.buttonHeight);
    private UIButton playAgain = new UIButton(540, 580,game, Assets.playAgainButton, Assets.buttonWidth, Assets.buttonHeight);
    private boolean won;
    private String timeString;
    private int totalSecs;

    public EndState(Game game) {
        super(game);

    }

    @Override
    public void update() {
        exitButton.update();
        playAgain.update();



        int hours = totalSecs / 3600;
        int minutes = (totalSecs % 3600) / 60;
        int seconds = totalSecs % 60;

        timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);

        if (game.getMouseListener().isLeftClicked() && exitButton.click()) {
            System.exit(0);
        }

        if (game.getMouseListener().isLeftClicked() && playAgain.click()) {
            game.getStateHandler().setState(game.getMenuState());
            game.count = 0;
        }

    }

    @Override
    public void render(Graphics graphics) {
        exitButton.render(graphics);
        playAgain.render(graphics);

        if (won) {

            DrawText.draw(game.getGraphics(), "Congratulations " + game.teamName + ", you have won the game! ", game.width/2, game.height/2, true, Color.BLACK, Assets.smallFont);
            DrawText.draw(game.getGraphics(), "You defeated the super villain and saved the residents of " + game.getNoOfCities() + " cities!", game.width/2, (game.height/2) + 100, true, Color.BLACK, Assets.smallFont);
            DrawText.draw(game.getGraphics(), "Time Taken: " + timeString, game.width/2, (game.height/2) + 200, true, Color.BLACK, Assets.smallFont);

        } else {

            DrawText.draw(game.getGraphics(), "Game Over, you lost ;(", game.width/2, game.height/2, true, Color.BLACK, Assets.smallFont);

        }

    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public void setTotalSecs(int totalSecs) {
        this.totalSecs = totalSecs;
    }
}
