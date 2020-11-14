package desenhos.status;

import comeco.Game;
import desenhos.entidades.estaticas.Retangulo; 
import java.awt.*;

public class MenuStatus extends Status {

    public MenuStatus(Game game) {
        super(game);
        if (Retangulo.quadra != null) {
            Retangulo.quadra = new Retangulo(0, 0, game.getWidth(), game.getHeight());
        }
    }

    @Override
    public void tick() {
        if (game.getKeyManager().enter)
            Status.setStatus(game.getGameStatus());
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.drawString("BALL GAME", game.getWidth() / 2, game.getHeight() / 3);
        g.drawString("APERTE ENTER PARA INICIAR", game.getWidth() / 2, game.getHeight() / 3 + 20);
        g.drawString("APERTE P PARA VOLTAR AO MENU", game.getWidth() / 2, game.getHeight() / 3 + 40);
    }

}