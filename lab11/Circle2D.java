import java.awt.*;

public class Circle2D extends Shape2D {

    public static final Color[] COLORS = {
        new Color(255, 0, 0),
        new Color(0, 255, 0),
        new Color(0, 0, 255),
        new Color(0, 0, 0),
        new Color(128, 128, 128),
        new Color(255, 255, 255),
        new Color(255, 255, 0),
    };

    private int diameter;
    private double xPosition;
    private double yPosition;
    private Color color;
    private int colorIndex;

    public Circle2D() {
        this.diameter = 40;
        this.xPosition = 20;
        this.yPosition = 20;
        this.colorIndex = 0;
        this.color = COLORS[0];
    }

    public Circle2D(int colorIndex, double xPosition, double yPosition, int diameter) {
        this.diameter = diameter;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.colorIndex = colorIndex;
        this.color = COLORS[this.colorIndex];
    }

    public void Move(double xDelta, double yDelta) {
        this.xPosition += xDelta;
        this.yPosition += yDelta;
    }

    public int GetX() {
        return (int)this.xPosition;
    }

    public int GetY() {
        return (int)this.yPosition;
    }

    public void SetPos(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }

    public Color GetColor() {
        return this.color;
    }

    public int GetDiameter() {
        return this.diameter;
    }

    public void Draw(Graphics g) {
        g.setColor(this.color);
        g.fillOval((int)this.xPosition, (int)this.yPosition, this.diameter, this.diameter);
    }
}
