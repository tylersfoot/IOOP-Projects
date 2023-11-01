import java.util.Random;

public class Deck {

    private CardP3 [] deck = null;
    private int topCard = 0;

    public Deck() {
        deck = new CardP3[52];

        CardP3.Suit[] suits = CardP3.Suit.values();
        int index = 0;
        for (CardP3.Suit suit : suits) {
            for (int value = 1; value <= 13; value++) {
                deck[index] = new CardP3(value, suit);
                index++;
            }
        }
    }

    public void Shuffle(int nTimes) {
        Random random = new Random();

        for (int i = 0; i < nTimes; i++) {
            int index1 = random.nextInt(deck.length);
            int index2 = random.nextInt(deck.length);

            // Swap cards at index1 and index2
            CardP3 temp = deck[index1];
            deck[index1] = deck[index2];
            deck[index2] = temp;
        }
    }

    public CardP3 DealACard() {
        if (topCard >= 0 && topCard <= deck.length-1) {
            CardP3 card = deck[topCard];
            topCard++;
            return card;
        } else {
            return null;
        }
    }

    public int CardLeft() {
        return deck.length - topCard;
    }
}
