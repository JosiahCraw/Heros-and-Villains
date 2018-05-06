package Heroes_Villains;

import Heroes_Villains.display.Display;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{

    private Display display;
    private Thread gameThread;
    private String title;
    private boolean running = false;

    public int width, height;

    //Graphics variables
    private BufferStrategy buffer;
    private Graphics graphics;

    private void update(){

    }

    private void render(){
        buffer = display.getCanvas().getBufferStrategy();
        if (buffer == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graphics = buffer.getDrawGraphics();


    }

    private void init(){
        display = new Display(title, width, height);

    }

    @Override
    public void run() {
        init();
        while(running){
            update();
            render();
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
