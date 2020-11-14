package desenhos.status;

import comeco.Game;
import desenhos.entidades.moveis.Bola; 
import desenhos.entidades.estaticas.Retangulo; 
import java.awt.Graphics;
import java.awt.*;

public class GameStatus extends Status {
    
    public GameStatus(Game game){
        super(game);
        if(Retangulo.quadra == null){
            Retangulo.quadra = new Retangulo(0, 0, game.getWidth(), game.getHeight());
        }
        Bola.bolas.add(new Bola(250, 380, 100, 2, -42, Color.BLUE));
        Bola.bolas.add(new Bola(200, 80, 50, 2, -84, Color.RED));
        Bola.bolas.add(new Bola(500, 170, 70, 2, -42, Color.YELLOW));
        Bola.bolas.add(new Bola(500, 170, 90, 2, -42, Color.GREEN));
    }

    @Override
    public void tick(){
        if (game.getKeyManager().p)
            Status.setStatus(game.getMenuStatus());
        Retangulo.quadra.tick();
        for (Bola bola : Bola.bolas) {
            bola.tick();
        }
    }

    @Override
    public void render(Graphics g){
        Retangulo.quadra.render(g);
        for (Bola bola : Bola.bolas) {
            bola.render(g);
        }
    }
    
}