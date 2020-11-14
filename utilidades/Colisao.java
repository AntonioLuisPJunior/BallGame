package utilidades;

import desenhos.entidades.estaticas.Retangulo;
import desenhos.entidades.moveis.Bola;

public class Colisao {
    public static void colisao(Retangulo quadra, Bola bola) {
        //posicao minima da coordenada x e y do centro do circulo para a parede
        double bolaMinX = quadra.getX() + bola.getRadius();
        double bolaMinY = quadra.getY() + bola.getRadius();
        //posicao maxima da coordenada x e y do centro do circulo para a parede
        double bolaMaxX = quadra.getWidth() - bola.getRadius();
        double bolaMaxY = quadra.getHeight() - bola.getRadius();
        //verifica a coordenada x
        if (bola.getX() < bolaMinX) {
            bola.setSpeedX(-bola.getSpeedX());// inverte a velocidade
            bola.setX(bolaMinX);
        } else if (bola.getX() > bolaMaxX) {
            bola.setSpeedX(-bola.getSpeedX());// inverte a velocidade
            bola.setX(bolaMaxX);
            
        }
        //verifica a coordenada y
        if (bola.getY() < bolaMinY) {
            bola.setSpeedY(-bola.getSpeedY());// inverte a velocidade
            bola.setY(bolaMinY);
        } else if (bola.getY() > bolaMaxY) {
            bola.setSpeedY(-bola.getSpeedY());// inverte a velocidade
            bola.setY(bolaMaxY);
        }
    }

    public static void colisao(Bola a, Bola b) {
        double distanciaX, distanciaY;
        distanciaX = a.getX() - b.getX();
        distanciaY = a.getY() - b.getY();
        double distanciaQuad = distanciaX * distanciaX + distanciaY * distanciaY;
        if (distanciaQuad <= (a.getRadius() + b.getRadius()) * (a.getRadius() + b.getRadius())) {
            double speedXocity = b.getSpeedX() - a.getSpeedX();
            double speedYocity = b.getSpeedY() - a.getSpeedY();
            double dotProduct = distanciaX * speedXocity + distanciaY * speedYocity;
            if (dotProduct > 0) {
                double collisionScale = dotProduct / distanciaQuad;
                double xCollision = distanciaX * collisionScale;
                double yCollision = distanciaY * collisionScale;
                double combinedMass = a.getMass() + b.getMass();
                double collisionWeightA = 2 * b.getMass() / combinedMass;
                double collisionWeightB = 2 * a.getMass() / combinedMass;
                a.setSpeedX(a.getSpeedX()+(collisionWeightA * xCollision));
                a.setSpeedY(a.getSpeedY()+(collisionWeightA * yCollision));
                b.setSpeedX(b.getSpeedX()-(collisionWeightB * xCollision));
                b.setSpeedY(b.getSpeedY()-(collisionWeightB * yCollision));
            }
        }
    }


}