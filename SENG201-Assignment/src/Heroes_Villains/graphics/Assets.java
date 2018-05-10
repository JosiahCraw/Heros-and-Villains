package Heroes_Villains.graphics;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage black, purple, playerUp, playerDown, playerLeft, playerRight;
    public static Font titleFont;
    private static int widthSheet1 = 16;
    private static int heightSheet1 = 16;
    private static int widthPlayerSheet = 32;
    private static int heightPlayerSheet = 32;
    public static int buttonHeight, buttonWidth;

    //Buffered image arrays for animations
    public static BufferedImage[] walkingUp, startButton, menuButton, backButton;

    public static void init() {
        SpriteSheet sheet1 = new SpriteSheet("/textures/sheets/tiles.png");
        SpriteSheet playerSheet = new SpriteSheet("/textures/sheets/PlayerSheet.png");
        walkingUp = new BufferedImage[3];
        startButton = new BufferedImage[2];
        menuButton = new BufferedImage[2];
        backButton = new BufferedImage[2];

        //Setting default button width and height
        buttonHeight = 256;
        buttonWidth = 1024;

        //Button Frames
        startButton[0] = ImageHandler.loadImage("/textures/StartButton1.png");
        startButton[1] = ImageHandler.loadImage("/textures/StartButton2.png");

        menuButton[0] = ImageHandler.loadImage("/textures/MenuButton1.png");
        menuButton[1] = ImageHandler.loadImage("/textures/MenuButton2.png");

        backButton[0] = ImageHandler.loadImage("/textures/BackButton1.png");
        backButton[1] = ImageHandler.loadImage("/textures/BackButton2.png");

        //Player animation frame to crop
        walkingUp[0] = playerSheet.getImage(0, 0, widthPlayerSheet, heightPlayerSheet);
        walkingUp[1] = playerSheet.getImage(widthPlayerSheet, 0, widthPlayerSheet, heightPlayerSheet);
        walkingUp[2] = playerSheet.getImage(widthPlayerSheet * 2, 0, widthPlayerSheet, heightPlayerSheet);


        black = sheet1.getImage(0,0, widthSheet1, heightSheet1);
        purple = sheet1.getImage(widthSheet1, 0, widthSheet1, heightSheet1);
        playerUp = ImageHandler.loadImage("/textures/PlayerUp.png");
        playerDown = ImageHandler.loadImage("/textures/PlayerDown.png");
        playerLeft = ImageHandler.loadImage("/textures/PlayerLeft.png");
        playerRight = ImageHandler.loadImage("/textures/PlayerRight.png");

        //Fonts
        //titleFont = FontLoader.load("/res/fonts/Symtext.ttf", 48);

    }


}
