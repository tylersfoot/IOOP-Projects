import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class CanvasPanel extends JPanel {
    private final static int X_CORNER = 25;
    private final static int Y_CORNER = 25;
    private final static int CANVAS_WIDTH = 600;
    private final static int CANVAS_HEIGHT = 600;

    private final static int RED_CIRCLE = 0;
    private final static int BLUE_CIRCLE = 1;
    private final static int BLUE_RECT = 6;
    List<Shape2D> shapesList;
    boolean action;
    private int frameNumber;

    public CanvasPanel() {
        shapesList = new ArrayList<>();
        action = false;
        shapesList.add(new Circle2D()); // Circle shape
        // color xpos ypos diamater
        shapesList.add(new Circle2D(2, 20, 20, 50)); // Circle shape 1
        // Grass and road
        shapesList.add(new Rectangle2D(1, 25, 575, 600, 50));
        // Green rectangle, shape 2
        shapesList.add(new Rectangle2D(3, 25, 525, 600, 50));
        // Black rectangle, shape 3
        shapesList.add(new Rectangle2D(5, 25, 520, 600, 10));
        // White rectangle, shape 4
        shapesList.add(new Rectangle2D(3, 25, 490, 600, 30));
        // Black rectangle, shape 5
        shapesList.add(new Rectangle2D(2, 100, 470, 100, 50));
        // A blue reactangle, shape 6
        shapesList.add(new Oval2D(6, 400, 100, 40, 30));
        // Yellow Oval shape 7
        // Callback for keyboard events
        this.setFocusable(true);
        this.addKeyListener(new myActionListener());
        System.out.println("keyboard event registered");
        // Create a render loop
        // Create a Swing Timer that will tick 30 times a second
        // At each tick the ActionListener that was registered via the lambda expression will be invoked
        Timer renderLoop = new Timer(30, (ActionEvent ev) -> {frameNumber++; Simulate(); repaint();}); 
        // lambda expression for ActionListener implements actionPerformed
        renderLoop.start();
    }

    public void Simulate() {
        if (action) {
            Shape2D shape = null;
            shapesList.get(RED_CIRCLE).Move(1, 2); // move the shape along via a delta in x(1) and y(2)
            shapesList.get(BLUE_CIRCLE).Move(2, 1); // move the shape along via a delta in x(2) and y(1)
            shape = shapesList.get(BLUE_RECT);
            shape.Move(2, 0); // move car along road in x direction
            int x = shape.GetX();
            if (x > 800) {
                int y = shape.GetY();
                shape.SetPos(-50, y);
            }
        }
    }

    // This method is called by renderloop
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
        // Set window background to black
        g.setColor(Color.BLACK);
        g.fillRect(0,0,CANVAS_WIDTH + 2 * X_CORNER, CANVAS_HEIGHT + 2 *
        Y_CORNER); //draw the black border
        // Set canvas background to grey
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(X_CORNER, Y_CORNER, CANVAS_WIDTH, CANVAS_HEIGHT); //make the canvas white
        // Display frame number
        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas", Font.PLAIN, 30));
        g.drawString(Integer.toString(frameNumber), 300, 70);
        // Render all the shapes in the shapes list
        for (Shape2D shape : shapesList) {
            shape.Draw(g);
        }
    }

    public static int getCanvasWidth() {
        return CANVAS_WIDTH;
    }

    public static int getCanvasHeight() {
        return CANVAS_HEIGHT;
    }

    public static int getCanvasXBorder() {
        return X_CORNER;
    }

    public static int getCanvasYBorder() {
        return Y_CORNER;
    }

    public class myActionListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                System.out.println("press up arrow");
                break;
                case KeyEvent.VK_DOWN:
                System.out.println("press down arrow");
                break;
                case KeyEvent.VK_LEFT:
                System.out.println("press left arrow");
                break;
                case KeyEvent.VK_RIGHT:
                System.out.println("press right arrow");
                break;
                case KeyEvent.VK_A:
                action = true;
                break;
                case KeyEvent.VK_S:
                action = false;
                break;
                default:
                System.out.println("press some other key besides the arrow keys");
            }
        }
        public void keyReleased(KeyEvent e) {
            //System.out.println("released");
        }
    }
}
