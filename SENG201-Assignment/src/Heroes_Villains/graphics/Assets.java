package Heroes_Villains.graphics;


import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage black, purple, playerUp, playerDown, playerLeft, playerRight;
    private static int widthSheet1 = 16;
    private static int heightSheet1 = 16;

    public static void init() {
        SpriteSheet sheet1 = new SpriteSheet("/textures/sheets/tiles.png");
        black = sheet1.getImage(0,0, widthSheet1, heightSheet1);
        purple = sheet1.getImage(widthSheet1, 0, widthSheet1, heightSheet1);
        playerUp = ImageHandler.loadImage("/textures/PlayerUp.png");
        playerDown = ImageHandler.loadImage("/textures/PlayerDown.png");
        playerLeft = ImageHandler.loadImage("/textures/PlayerLeft.png");
        playerRight = ImageHandler.loadImage("/textures/PlayerRight.png");

    }


}
