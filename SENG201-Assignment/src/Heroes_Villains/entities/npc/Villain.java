package Heroes_Villains.entities.npc;

import Heroes_Villains.Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Villain extends NPC {

    private BufferedImage image;
    private Rectangle bounds;
    private int width, height;
    private Game game;

    public Villain(float x, float y, BufferedImage image, int width, int height, Game game) {
        super(x, y, "Villain");
        this.image = image;
        this.width = width;
        this.height = height;
        this.game = game;
        bounds = new Rectangle((int) x, (int) y, width, height);
    }

    public void update() {
        if(game.getPlayer().bounds.intersects(bounds) && game.getKeyboardListener().keyJustPressed(KeyEvent.VK_F)) {
            game.getStateHandler().setState(game.getBattleState());
        }
    }

    public void render(Graphics graphics) {
        graphics.drawImage(image, (int) x, (int) y, width, height, null);
    }

}
