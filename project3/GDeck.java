import java.util.Random;

public class GDeck {

    private GCard [] deck = null;
    private int topCard = 0;

    public GDeck() {
        deck = new GCard[52];

        GCard.Suit[] suits = GCard.Suit.values();
        int index = 0;
        for (GCard.Suit suit : suits) {
            for (int value = 1; value <= 13; value++) {
                String filePath = "cards/" + value + suit.toString() + ".png";
                deck[index] = new GCard(value, suit, filePath);
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
            GCard temp = deck[index1];
            deck[index1] = deck[index2];
            deck[index2] = temp;
        }
    }

    public GCard DealACard() {
        if (topCard >= 0 && topCard <= deck.length-1) {
            GCard card = deck[topCard];
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
