package Heroes_Villains.graphics;

import java.awt.*;
import java.io.IOException;

public class FontLoader {


    public static Font load(String path, int size) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, FontLoader.class.getResourceAsStream(path)).deriveFont(Font.PLAIN, size);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
