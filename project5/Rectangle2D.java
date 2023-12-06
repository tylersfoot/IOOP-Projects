import java.awt.*;

public class Rectangle2D extends Shape2D {

    public static final Color[] COLORS = {
        new Color(255, 0, 0),
        new Color(0, 255, 0),
        new Color(0, 0, 255),
        new Color(0, 0, 0),
        new Color(128, 128, 128),
        new Color(255, 255, 255),
        new Color(255, 255, 0),
    };

    private int width;
    private int height;
    private int xPosition;
    private int yPosition;
    private Color color;
    private int colorIndex;

    public Rectangle2D() {
        this.xPosition = 20;
        this.yPosition = 20;
        this.width = 20;
        this.height = 20;
        this.colorIndex = 0;
        this.color = COLORS[0];
    }

    public Rectangle2D(int colorIndex, int xPosition, int yPosition, int width, int height) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.colorIndex = colorIndex;
        this.color = COLORS[this.colorIndex];
        this.width = width;
        this.height = height;
    }

    public void Move(int xDelta, int yDelta) {
        this.xPosition += xDelta;
        this.yPosition += yDelta;
    }

    public int GetX() {
        return this.xPosition;
    }

    public int GetY() {
        return this.yPosition;
    }

    public void SetPos(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }

    public Color GetColor() {
        return this.color;
    }

    public int GetWidth() {
        return this.width;
    }

    public int GetHeight() {
        return this.height;
    }

    public void Draw(Graphics g) {
        g.setColor(this.color);
        g.fillRect(this.xPosition, this.yPosition, this.width, this.height);
    }
}
