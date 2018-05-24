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
            timeRemaining = 0;
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
        graphics.drawImage(images[0], x, y, 150, 150, null);
        DrawText.draw(graphics, hero.getName(), x + 75, y+30, true, Color.BLACK, Assets.smallFont);
        DrawText.draw(graphics, "Heal Time:", x + 75, y+70, true, Color.BLACK, Assets.smallFont);
        DrawText.draw(graphics, Integer.toString(timeRemaining), x + 75, y+110, true, Color.BLACK, Assets.titleFont);

    }

    @Override
    public boolean click() {
        return false;
    }
}
