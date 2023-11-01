import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class GHighLow {
    private JFrame frame;
    private JPanel panel;
    private JLabel iconLabelOne, iconLabelTwo;
    private GDeck deck;
    private ImageIcon image;

    public GHighLow() {
        this.frame = new JFrame("High Low");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = new JPanel();
        this.panel.setBackground(Color.cyan);
        this.panel.setPreferredSize(new Dimension(350, 275));

        this.image = new ImageIcon("cards/cardBack.png");
        this.iconLabelOne = new JLabel(null, this.image, SwingConstants.CENTER);
        this.iconLabelTwo = new JLabel(null, this.image, SwingConstants.CENTER);
        
        this.panel.add(this.iconLabelOne);
        this.panel.add(this.iconLabelTwo);

        this.frame.getContentPane().add(this.panel);
        this.frame.pack();
        this.frame.setVisible(true);

        this.deck = new GDeck();
        Play();
    }

    private void Play() {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        int totalScore = 0;
        int totalRounds = 0;

        while (loop) {
            totalScore += PlayARound(scanner);
            totalRounds++;

            char input = 'a';
            while (input != 'Y' && input != 'N') {
                System.out.println("Play again? (Y/N)");
                input = Character.toUpperCase(scanner.next().charAt(0));
            }

            if (input == 'N') {
                loop = false;
            }
        }

        double averageScore = (double) totalScore / totalRounds;
        System.out.println("Average score of " + averageScore + " for " + totalRounds + " rounds played.");
        scanner.close();
        frame.dispose();
    }

    private int PlayARound(Scanner scanner) {
        deck.Shuffle(200);
        int correctGuesses = 0;
        GCard currentCard = deck.DealACard();
        boolean loop = true;

        while (loop) {
            
            iconLabelOne.setIcon(image);
            iconLabelTwo.setIcon(image);
            mySleep(500);

            char userGuess = 'a';
            while (userGuess != 'H' && userGuess != 'L') {
                System.out.println("The current card is " + currentCard);

                currentCard.SetActiveJLabel(this.iconLabelOne);
                currentCard.Display();

                System.out.println("Will the next card be higher (H) or lower (L)?");
                userGuess = Character.toUpperCase(scanner.next().charAt(0));
            }

            mySleep(1000);

            GCard nextCard = deck.DealACard();
            if (nextCard == null) {
                // if ran out of cards
                deck = new GDeck();
                deck.Shuffle(200);
                nextCard = deck.DealACard();
            }

            nextCard.SetActiveJLabel(this.iconLabelTwo);
            nextCard.Display();

            int difference = currentCard.getValue() - nextCard.getValue();
            if ((userGuess == 'H' && difference <= 0) || (userGuess == 'L' && difference >= 0)) {
                System.out.println("Your prediction was correct.");
                correctGuesses++;
            } else {
                System.out.println("Your prediction was incorrect.");
                loop = false;
            }

            mySleep(1000);

            currentCard = nextCard;
        }

        System.out.println("The game is over.");
        System.out.println("You made " + correctGuesses + " correct predictions.");
        return correctGuesses;
    }

    private void mySleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
