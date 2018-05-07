package Heroes_Villains;

import Heroes_Villains.display.Display;
import Heroes_Villains.graphics.Assets;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{ //Runnable allows the class to use threads

    private Display display;
    private Thread gameThread;
    private String title;
    private boolean running = false;

    public int width, height;

    //Graphics variables
    private BufferStrategy buffer;
    private Graphics graphics;

    private int x;


    private void update(){
        x++;
    }

    private void render(){
        //Creating the buffer for the output frames
        buffer = display.getCanvas().getBufferStrategy();
        if (buffer == null){ //If not buffer exists create one
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graphics = buffer.getDrawGraphics();
        //Graphics
        graphics.clearRect(0, 0, width, height);
        graphics.drawImage(Assets.purple, x, 100, null);

        //Graphics end
        buffer.show();
        graphics.dispose();

    }

    private void init(){ //Function run by run()
        display = new Display(title, width, height);
        Assets.init();

    }

    @Override
    public void run() { //Following function is run when the thread is started
        init();

        final int  FPS = 60;
        final long FPS_TIME = 1000000000 / FPS;
        long timeAtLastLoop = System.nanoTime();

        while(running){
            long timeNow = System.nanoTime();
            long updateTime = timeNow - timeAtLastLoop;
            timeAtLastLoop = timeNow;
            double changeInTime = updateTime / ((double)FPS_TIME);

            //Running game updates
            update();
            render();
            try {
                Thread.sleep( (timeAtLastLoop-System.nanoTime() + FPS_TIME)/1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stop();

    }

    public synchronized void start(){
        if (running){
            return;
        }
        running = true;
        gameThread = new Thread(this);
        gameThread.start();


    }

    public synchronized void stop(){
        if (!running){
            return;
        }
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;


        }

    }
