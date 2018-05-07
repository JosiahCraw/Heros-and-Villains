package Heroes_Villains.graphics;


import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage black, purple;
    private static int widthSheet1 = 16;
    private static int heightSheet1 = 16;

    public static void init() {
        SpriteSheet sheet1 = new SpriteSheet("/textures/sheets/tiles.png");
        black = sheet1.crop(0,0, widthSheet1, heightSheet1);
        purple = sheet1.crop(widthSheet1, 0, widthSheet1, heightSheet1);
    }


}
