package comeco;

import desenhos.status.*;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import inputs.KeyManager;

public class Game implements Runnable {
    private Tela tela;

    private int width, height;

    private boolean running;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    private KeyManager keyManager;
    
    private Status gameStatus;
    private Status menuStatus;

    public Game(int width, int height){
        this.width = width;
        this.height = height;
        keyManager = new KeyManager();
    }

    public KeyManager getKeyManager(){
        return keyManager;
    }

    private void init(){
        tela = new Tela(width, height);
        tela.getFrame().addKeyListener(keyManager);
        gameStatus = new GameStatus(this);
        menuStatus = new MenuStatus(this);
        Status.setStatus(menuStatus);
    }

    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();     
    }
    
    // atualizacoes dentro do jogo
    private void tick(){
        keyManager.tick();
        if(Status.getStatus() != null){
            Status.getStatus().tick();
        }
    }

    //exibiçao dentro do jogo
    private void render(){
        bs = tela.getCanvas().getBufferStrategy();
        if(bs == null){
            tela.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);
        // inicio do desenho
        if(Status.getStatus() != null){
            Status.getStatus().render(g);
        }
        //fim do desenho
        bs.show();
        g.dispose();
    }

    //inicio do jogo
    public void run(){
        init();
        int fps = 60;
        double timePerTick = 1000000000/fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        while(running){
            now = System.nanoTime();
            delta += (now - lastTime)/timePerTick;
            lastTime = now;
            // mesma velocidade para todos pcs
            if(delta >= 1){
                tick();
                render();
                delta--;
            }
        }
        stop();
    }

    //parar o jogo
    public synchronized void stop(){
        if(!running)
            return;
        running = false;             
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public Status getGameStatus() {
        return gameStatus;
    }
    public Status getMenuStatus() {
        return menuStatus;
    }
    
}
