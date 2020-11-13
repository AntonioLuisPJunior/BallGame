package desenhos.entidades.moveis;

import desenhos.entidades.Entidade;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class Bola extends Entidade {

    public final double radius;
    public static List<Bola> bolas = new ArrayList<>();

    public Bola(double x, double y, double radius, double speed, double angleInDegree) {
        super(x, y, speed);
        this.speedX = speed * Math.cos(Math.toRadians(angleInDegree));
        this.speedY = -speed * Math.sin(Math.toRadians(angleInDegree));
        this.radius = radius;
    }
    public Bola(double x, double y, double radius, double speed, double angleInDegree, Color color) {
        super(x, y, speed, color);
        this.speedX = speed * Math.cos(Math.toRadians(angleInDegree));
        this.speedY = -speed * Math.sin(Math.toRadians(angleInDegree));
        this.radius = radius;
    }

    public void move() {
        this.x += this.speedX;
        this.y += this.speedY;
    }

    public void checkColision(){
        
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillOval((int) (x - radius), (int) (y - radius), (int) (2 * radius), (int) (2 * radius));
    }

    @Override
    public void tick() {
        checkColision();
    }

    @Override
    public void resize(int width, int heigth) {
        
    }
    public double getMass() {
        return 2 * radius * radius * radius / 1000f;
    }

}
