package Heroes_Villains.graphics;


import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage black, purple, playerUp, playerDown, playerLeft, playerRight;
    private static int widthSheet1 = 16;
    private static int heightSheet1 = 16;
    private static int widthPlayerSheet = 32;
    private static int heightPlayerSheet = 32;

    //Buffered image arrays for animations
    public static BufferedImage[] walkingUp;

    public static void init() {
        SpriteSheet sheet1 = new SpriteSheet("/textures/sheets/tiles.png");
        SpriteSheet playerSheet = new SpriteSheet("/textures/sheets/PlayerSheet.png");
        walkingUp = new BufferedImage[3];

        //Player animation frame cropping
        walkingUp[0] = playerSheet.getImage(0, 0, widthPlayerSheet, heightPlayerSheet);
        walkingUp[1] = playerSheet.getImage(widthPlayerSheet, 0, widthPlayerSheet, heightPlayerSheet);
        walkingUp[2] = playerSheet.getImage(widthPlayerSheet * 2, 0, widthPlayerSheet, heightPlayerSheet);


        black = sheet1.getImage(0,0, widthSheet1, heightSheet1);
        purple = sheet1.getImage(widthSheet1, 0, widthSheet1, heightSheet1);
        playerUp = ImageHandler.loadImage("/textures/PlayerUp.png");
        playerDown = ImageHandler.loadImage("/textures/PlayerDown.png");
        playerLeft = ImageHandler.loadImage("/textures/PlayerLeft.png");
        playerRight = ImageHandler.loadImage("/textures/PlayerRight.png");

    }


}
