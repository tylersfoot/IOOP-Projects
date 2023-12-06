import java.awt.*;

public class Polygon2D extends Shape2D {

    public static final Color[] COLORS = {
        new Color(255, 0, 0),
        new Color(0, 255, 0),
        new Color(0, 0, 255),
        new Color(0, 0, 0),
        new Color(128, 128, 128),
        new Color(255, 255, 255),
        new Color(255, 255, 0),
    };

    private int[] xCoords;
    private int[] yCoords;
    private int[] txCoords;
    private int[] tyCoords;
    private int nPoints;
    private Color color;
    private int colorIndex;

    public Polygon2D() {
        this.colorIndex = 0;
        this.color = COLORS[0];
    }

    public Polygon2D(int colorIndex, int xPosition, int yPosition, int[] xCoords, int[] yCoords) {
        super(colorIndex, xPosition, yPosition);
        // construct (allocate memory)
        this.xCoords = new int[xCoords.length];
        this.yCoords = new int[yCoords.length];
        this.txCoords = new int[xCoords.length];
        this.tyCoords = new int[yCoords.length];

        // deep copy
        for (int i = 0; i < xCoords.length; i++) {
            this.xCoords[i] = xCoords[i];
            this.txCoords[i] = xCoords[i] + xPosition;
        }
        for (int i = 0; i < yCoords.length; i++) {
            this.yCoords[i] = yCoords[i];
            this.tyCoords[i] = yCoords[i] + yPosition;
        }
    }

    public void Move(double xDelta, double yDelta) {
        this.xPoints += xDelta;
        this.yPoints += yDelta;
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

    private void Transform() {
        double degs = super.GetZRotate();
        double rads = Math.toRadians(degs);
        double Sx = super.GetScaleX();
        double Sy = super.GetScaleY();
        for (int i = 0; i < xCoords.size(); i++)
        {
        double x = Sx * this.xCoords.get(i); // scale in x
        double y = Sy * this.yCoords.get(i); // scale in y
        // Rotate and then translate
        this.txCoords[i] = (int)(((x * Math.cos(rads) - y * Math.sin(rads)) + super.GetX()) + 0.5);
        this.tyCoords[i] = (int)(((x * Math.sin(rads) + y * Math.cos(rads)) + super.GetY()) + 0.5);
    }

    @Override
    public void Draw(Graphics g) {
        Transform(); // Scale, Rotate, Translate
        if (GetFill()) {
            g.setColor(super.GetFillColor());
            g.fillPolygon(txCoords, tyCoords, xCoords.length);
        }
        if (GetOutline()) {
            g.setColor(super.GetOutlineColor());
            g.drawPolygon(txCoords, tyCoords, xCoords.length);
        }
    }

    // public void Draw(Graphics g) {
    //     g.setColor(this.color);
    //     g.fillPolygon(this.xPoints, this.yPoints, this.nPoints);
    // }
//     fillPolygon(int[] xPoints, int[] yPoints, int nPoints)
// Fills a closed polygon defined by arrays of x and y coordinates.
}
