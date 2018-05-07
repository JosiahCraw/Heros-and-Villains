package Heroes_Villains.graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private String fileName;
    private BufferedImage sheet;
    public SpriteSheet(String fileName) {
        this.fileName = fileName;
        this.sheet = ImageHandler.loadImage(fileName);
    }
    public BufferedImage getImage(int x, int y, int width, int height) {
        return sheet.getSubimage(x, y,  width, height);
    }
}
