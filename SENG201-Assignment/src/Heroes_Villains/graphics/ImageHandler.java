package Heroes_Villains.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageHandler {

    public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(ImageHandler.class.getResource(path));
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;

    }
}
