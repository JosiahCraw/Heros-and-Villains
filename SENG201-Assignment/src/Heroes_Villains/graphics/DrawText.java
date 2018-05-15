package Heroes_Villains.graphics;

import java.awt.*;

public class DrawText {

    public static void draw(Graphics graphics, String string, int xPos, int yPos, boolean centre, Color colour, Font font) {
        graphics.setColor(colour);
        graphics.setFont(font);
        int x = xPos;
        int y = yPos;
        if(centre) {
            FontMetrics metrics = graphics.getFontMetrics(font);
            x = xPos - metrics.stringWidth(string) / 2;
            y = (yPos - metrics.getHeight() / 2) + metrics.getAscent();
        }
        graphics.drawString(string, x, y);
    }
}
