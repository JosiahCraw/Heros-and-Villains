package Heroes_Villains.SystemUI;

import Heroes_Villains.Game;
import Heroes_Villains.entities.heroes.Hero;
import Heroes_Villains.graphics.Assets;
import Heroes_Villains.graphics.DrawText;

import java.awt.*;
import java.awt.image.BufferedImage;


public class PotionTimer extends UIElement {

    private Hero hero;
    private int previousCount;

    public void setTimeRemaining(int timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    public int getTimeRemaining() {
        return timeRemaining;
    }

    private int timeRemaining;

    public PotionTimer(int x, int y, Hero hero, Game game, BufferedImage[] images) {
        super(x,y,game, images);
        this.hero = hero;
        previousCount = game.count;
        //this.timeRemaining = timeRemaining;
    }

    @Override
    public void update() {
        if (!hero.getUsingPotion()) {
            previousCount = game.count;
        }
        if (timeRemaining > 0) {

            if (previousCount < game.count) {
                timeRemaining -= game.count - previousCount;


                previousCount = game.count;
            }
        }

    }

    @Override
    public void render(Graphics graphics) {
        DrawText.draw(graphics, "Time Remaining for Hero: " + hero.getName() + " = " + timeRemaining, 200, 200, true, Color.BLACK, Assets.smallFont);
    }

    @Override
    public boolean click() {
        return false;
    }
}
