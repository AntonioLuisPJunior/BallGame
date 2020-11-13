package comeco;

import java.awt.*;
import javax.swing.JFrame;

public class Tela {

    private JFrame frame;
    private Canvas canvas;
    private int width, height;

    public Tela (int width, int height){
        this.width = width;
        this.height = height;
        criaTela();
    }
    
    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    private void criaTela(){
        frame = new JFrame("Balls");
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setFocusable(false);
        frame.add(canvas);
        frame.pack();
    }
}
