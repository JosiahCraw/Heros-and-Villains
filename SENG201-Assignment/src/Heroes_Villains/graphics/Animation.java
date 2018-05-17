package Heroes_Villains.graphics;

import java.awt.image.BufferedImage;

public class Animation {

    private BufferedImage[] images;
    private int index, speed;
    private long lastTime;

    public Animation(BufferedImage[] images, int speed) {
        this.images = images;
        this.speed = speed * 1000000;
        index = 0;
        lastTime = System.nanoTime();
    }

    public void update() {
        if ((System.nanoTime() - lastTime) >= speed) {
            index++;
            lastTime = System.nanoTime();
            if(index >= images.length) {
                index = 0;
            }
        }

    }

    public BufferedImage getCurrentImage() {
        return images[index];
    }
}
