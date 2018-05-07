package Heroes_Villains.graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {
    private BufferedImage sheet;
    private String fileName;

    public SpriteSheet(String fileName) {
        this.fileName = fileName;
        this.sheet = ImageHandler.loadImage("/textures/" + fileName);
    }
    public BufferedImage crop(int x, int y, int width, int height) {
        return sheet.getSubimage(x, y,  width, height);
    }
}
