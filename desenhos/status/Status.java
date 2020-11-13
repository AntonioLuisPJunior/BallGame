package desenhos.status;

import java.awt.Graphics;
import desenhos.Desenhavel;
import comeco.Game;

public abstract class Status extends Desenhavel {

    protected Game game;
    
    public Status(Game game){
        this.game = game;
    }

    public static Status currentStatus = null;

    public static void setStatus(Status status){
        currentStatus = status;
    }
    public static Status getStatus(){
        return currentStatus;
    }
    
    public abstract void tick();

    public abstract void render(Graphics g);
    
}
