package desenhos.entidades.moveis;

import desenhos.entidades.Entidade;
import desenhos.entidades.estaticas.Retangulo;
import utilidades.Colisao;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Bola extends Entidade {

    private final double radius;
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

    public void verificarColisao(){
        for(Bola bola: bolas){
            Colisao.colisao(Retangulo.quadra, bola);
        }
        for (int i = 0; i < bolas.size(); i++) {
            for (int j = 0; j < bolas.size(); j++) {
                if (i < j) {
                    Colisao.colisao(bolas.get(i), bolas.get(j));
                }
            }
        }
        for (Bola bola : bolas) {
            bola.move();
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillOval((int) (x - radius), (int) (y - radius), (int) (2 * radius), (int) (2 * radius));
    }

    @Override
    public void tick() {
        verificarColisao();
    }
    
    public double getMass() {
        return 2 * radius * radius * radius / 1000f;
    }

    public double getRadius() {
        return radius;
    }

}
