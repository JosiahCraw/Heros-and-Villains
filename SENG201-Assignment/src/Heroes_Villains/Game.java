package Heroes_Villains;

import Heroes_Villains.display.Display;

public class Game implements Runnable{
    private Display display;
    private Thread gameThread;

    public int width, height;

    private void init(){

    }

    @Override
    public void run() {
        init();

    }

    public synchronized void start(){
        gameThread = new Thread(this);
        gameThread.start();

    }

    public synchronized void stop(){
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;

        display = new Display(title, width, height);
        }

    }
