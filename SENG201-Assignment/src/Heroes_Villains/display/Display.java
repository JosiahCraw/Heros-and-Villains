package Heroes_Villains.display;

import javax.swing.*;
import java.awt.*;

public class Display {

    private JFrame frame;
    private Canvas canvas;

    private String title;
    int width, height;

    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        createDisplay();
    }

    private void createDisplay(){

        //JFrame creation and init
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //Canvas creations and init
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));

        //Adding canvas to frame
        frame.add(canvas);
        frame.pack();

    }
}
