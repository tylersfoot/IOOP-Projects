import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GCard extends CardP3 {
    private ImageIcon image;
    private JLabel label;

    public GCard(int value, Suit suit, String imgFileName) {
        super(value, suit);
        image = new ImageIcon(imgFileName);
        label = null;
    }

    public void SetActiveJLabel(JLabel label) {
        this.label = label;
    }

    @Override
    public void Display() {
        if (label != null) {
        label.setIcon(this.image);
        }
    }
}
