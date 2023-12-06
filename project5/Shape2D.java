import java.awt.*;

public abstract class Shape2D {

    public static final Color[] COLORS = {
        new Color(255, 0, 0),
        new Color(0, 255, 0),
        new Color(0, 0, 255),
        new Color(0, 0, 0),
        new Color(128, 128, 128),
        new Color(255, 255, 255),
        new Color(255, 255, 0),
    };

    private double xPosition;
    private double yPosition;
    private Color color;
    private int colorIndex;

    public Shape2D() {
        xPosition = 20;
        yPosition = 20;
        colorIndex = 0;
        color = COLORS[0];
    }

    public Shape2D(int colorIndex, double xPosition, double yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.colorIndex = colorIndex;
        color = COLORS[this.colorIndex];
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

    public abstract void Draw(Graphics g);
}
