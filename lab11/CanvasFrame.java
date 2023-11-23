import javax.swing.*;
import java.awt.*;

public class CanvasFrame {
    private JFrame frame; // the actual frame(window) we'll be showing
    private CanvasPanel canvas; // the canvas we'll be drawing

    public CanvasFrame() {
        frame = new JFrame("IOOP Fall 2023 CanvasFrame"); //make the JFrame, and set thw window bar title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas = new CanvasPanel(); // CanvasPanel extends a JPanel
        canvas.setPreferredSize(new Dimension(2 * CanvasPanel.getCanvasXBorder() + CanvasPanel.getCanvasWidth(), 2 * CanvasPanel.getCanvasYBorder() + CanvasPanel.getCanvasHeight()));
        frame.getContentPane().add(canvas); //put the canvas (JPanel) in the frame
        frame.pack(); //make everything the preferred size
        frame.setVisible(true); //show the frame
    }
}
