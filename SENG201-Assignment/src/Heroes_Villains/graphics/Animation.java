package Heroes_Villains.graphics;

import java.awt.image.BufferedImage;

public class Animation {

    private BufferedImage[] images;
    private int index, speed;
    private long lastTime;

    public Animation(BufferedImage[] images, int speed) {
        this.images = images;
        this.speed = speed;
        index = 0;
        lastTime = System.currentTimeMillis();
    }

    public void update() {
        if ((System.currentTimeMillis() - lastTime) >= speed) {
            index++;
            lastTime = System.currentTimeMillis();
            if(index >= images.length) {
                index = 0;
            }
        }

    }

    public BufferedImage getCurrentImage() {
        return images[index];
    }
}
