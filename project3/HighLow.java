import java.util.Scanner;

public class HighLow {
    private Deck deck;

    public HighLow() {
        deck = new Deck();
        Play();
    }

    private void Play() {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        int totalScore = 0;
        int totalRounds = 0;

        while (loop) {
            totalScore += PlayARound();
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
    }

    private int PlayARound() {
        deck.Shuffle(200);
        Scanner scanner = new Scanner(System.in);
        int correctGuesses = 0;
        CardP3 currentCard = deck.DealACard();
        boolean loop = true;

        while (loop) {
            System.out.println("The current card is " + currentCard);

            char userGuess = 'a';
            while (userGuess != 'H' && userGuess != 'L') {
                System.out.println("Will the next card be higher (H) or lower (L)?");
                userGuess = Character.toUpperCase(scanner.next().charAt(0));
            }

            CardP3 nextCard = deck.DealACard();
            if (nextCard == null) {
                // if ran out of cards
                deck = new Deck();
                deck.Shuffle(200);
                nextCard = deck.DealACard();
            }
            System.out.println("The next card is " + nextCard);

            int difference = currentCard.getValue() - nextCard.getValue();
            if ((userGuess == 'H' && difference <= 0) || (userGuess == 'L' && difference >= 0)) {
                System.out.println("Your prediction was correct.");
                correctGuesses++;
            } else {
                System.out.println("Your prediction was incorrect.");
                loop = false;
            }

            currentCard = nextCard;
        }

        System.out.println("The game is over.");
        System.out.println("You made " + correctGuesses + " correct predictions.");
        return correctGuesses;
    }
}
