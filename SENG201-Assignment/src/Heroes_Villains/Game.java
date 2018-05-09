package Heroes_Villains;

import Heroes_Villains.Listener.KeyboardListener;
import Heroes_Villains.States.GameState;
import Heroes_Villains.States.MenuState;
import Heroes_Villains.States.State;
import Heroes_Villains.States.StateHandler;
import Heroes_Villains.display.Display;
import Heroes_Villains.graphics.Assets;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{ //Runnable allows the class to use threads

    private Display display;
    private Thread gameThread;
    private String title;
    private boolean running = false;

    //State Variables
    private State gameState, menuState;
    private StateHandler stateHandler = new StateHandler();

    //Keyboard Listener
    private KeyboardListener keyboardListener;

    public int width, height;

    //Graphics variables
    private BufferStrategy buffer;
    private Graphics graphics;

    private void update(){
        keyboardListener.update();
        if(stateHandler.state != null) {
            stateHandler.state.update();
        }
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
        if(stateHandler.state != null) {
            stateHandler.state.render(graphics);
        }


        //Graphics end
        buffer.show();
        graphics.dispose();

    }

    private void init(){ //Function run by run()
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyboardListener);
        Assets.init();
        gameState = new GameState(this);
        menuState = new MenuState(this);
        stateHandler.setState(gameState);
    }

    @Override
    public void run() { //Following function is run when the thread is started
        init();

        final int  FPS = 60;
        final long FPS_TIME = 1000000 / FPS;
        long timeAtLastLoop;

        while(running){
            long timeNow = System.currentTimeMillis();
            timeAtLastLoop = timeNow;

            //Running game updates
            update();
            render();
            try {
                Thread.sleep((timeAtLastLoop - System.currentTimeMillis() + FPS_TIME)/1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            catch (IllegalArgumentException e) {
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
        keyboardListener = new KeyboardListener();
        }

    public KeyboardListener getKeyboardListener() {
        return keyboardListener;
    }
}
