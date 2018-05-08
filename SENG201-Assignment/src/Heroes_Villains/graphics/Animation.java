package Heroes_Villains.graphics;

import java.awt.image.BufferedImage;

public class Animation {

    private BufferedImage[] images;
    private int index;

    public Animation(BufferedImage[] images) {
        this.images = images;
    }

    public BufferedImage getCurrentImage() {
        return images[index];
    }
}
