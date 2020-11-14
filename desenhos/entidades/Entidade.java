package desenhos.entidades;

import desenhos.Desenhavel;
import java.awt.*;

public abstract class Entidade extends Desenhavel{
    
    protected double x, y;
    protected double speedX, speedY;
    protected final Color color;
    private static final Color DEFAULT_COLOR_FILLED = Color.BLACK;

    public Entidade(double x,  double y, double speed){
        this.x = x;
        this.y = y;
        this.speedX = speed;
        this.speedY = speed;
        this.color = DEFAULT_COLOR_FILLED;
    }
    public Entidade(double x,  double y, double speed, Color color){
        this.x = x;
        this.y = y;
        this.speedX = speed;
        this.speedY = speed;
        this.color = color;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public void move() {
        this.x += this.speedX;
        this.y += this.speedY;
    }

    //getters setters
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getSpeedX() {
        return speedX;
    }
    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }
    public double getSpeedY() {
        return speedY;
    }
    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }
    public Color getColor() {
        return color;
    }

}