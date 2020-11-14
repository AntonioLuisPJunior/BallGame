package utils;
import desenhos.entidades.estaticas.Retangulo;
import desenhos.entidades.moveis.Bola;

public class Colisao {
    public static void colisao(Retangulo cerca, Bola bola) {
        //posicao minima da coordenada x e y do centro do circulo para a parede
        double bolaMinX = cerca.x + bola.radius;
        double bolaMinY = cerca.y + bola.radius;
        //posicao maxima da coordenada x e y do centro do circulo para a parede
        double bolaMaxX = cerca.getWidth() - bola.radius;
        double bolaMaxY = cerca.getHeight() - bola.radius;
        //verifica a coordenada x
        if (bola.x < bolaMinX) {
            bola.speedX = -bola.speedX; // inverte a velocidade
            bola.x = bolaMinX; // reposiciona
        } else if (bola.x > bolaMaxX) {
            bola.speedX = -bola.speedX;
            bola.x = bolaMaxX;
        }
        //verifica a coordenada y
        if (bola.y < bolaMinY) {
            bola.speedY = -bola.speedY;
            bola.y = bolaMinY;
        } else if (bola.y > bolaMaxY) {
            bola.speedY = -bola.speedY;
            bola.y = bolaMaxY;
        }
    }

    public static void colisao(Bola a, Bola b) {
        double distanciaX, distanciaY;
        distanciaX = a.x - b.x;
        distanciaY = a.y - b.y;
        double distanciaQuad = distanciaX * distanciaX + distanciaY * distanciaY;
        // Check the squared distances instead of the the distances, same
        // result, but avoids a square root.
        if (distanciaQuad <= (a.radius + b.radius) * (a.radius + b.radius)) {
            double speedXocity = b.speedX - a.speedX;
            double speedYocity = b.speedY - a.speedY;
            double dotProduct = distanciaX * speedXocity + distanciaY * speedYocity;
            // Neat vector maths, used for checking if the objects moves towards
            // one another.
            if (dotProduct > 0) {
                double collisionScale = dotProduct / distanciaQuad;
                double xCollision = distanciaX * collisionScale;
                double yCollision = distanciaY * collisionScale;
                // The Collision vector is the speed difference projected on the
                // Dist vector,
                // thus it is the component of the speed difference needed for
                // the collision.
                double combinedMass = a.getMass() + b.getMass();
                double collisionWeightA = 2 * b.getMass() / combinedMass;
                double collisionWeightB = 2 * a.getMass() / combinedMass;
                a.speedX += (collisionWeightA * xCollision);
                a.speedY += (collisionWeightA * yCollision);
                b.speedX -= (collisionWeightB * xCollision);
                b.speedY -= (collisionWeightB * yCollision);
            }
        }
    }


}