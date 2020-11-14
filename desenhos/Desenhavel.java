package desenhos;

import java.awt.Graphics;

public abstract class Desenhavel {

    public abstract void tick();

    public abstract void render(Graphics g);
    
}