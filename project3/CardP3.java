public class CardP3 {
    public enum Suit {SPADES, HEARTS, DIAMONDS, CLUBS};

    public final static int ACE = 1; // static final data member, global to all objects
    public final static int JACK = 11; // static final data member, global to all objects
    public final static int QUEEN = 12; // static final data member, global to all objects
    public final static int KING = 13; // static final data member, global to all objects

    private final Suit suit; // final suit, the suit of a card can not change
    private final int value; // final value, the value of the card can not change

    public CardP3(int value, CardP3.Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    // using System.out.print(toString) this method displays the card as a String without going to the next line
    public void Display() {
        System.out.print(this.toString());
    }

    // Returns the suit of this card
    public Suit getSuit() {
        return this.suit;
    }

    // returns a String representation of the card's suit
    public String getSuitAsString() {
        String suitString = this.suit.toString().toLowerCase();
        return Character.toUpperCase(suitString.charAt(0)) + suitString.substring(1);
    }

    // returns the value of this card
    public int getValue() {
        return this.value;
    }

    // returns a String representation of the card's value
    public String getValueAsString() {
        switch(this.value) {
            case 1:
              return "Ace";
            case 11:
              return "Jack";
            case 12:
              return "Queen";
            case 13:
              return "King";
            default:
              return this.value + "";
        }
    }

    // returns a string representation of this card, including both its suit and its value
    // Sample return values are: "Queen of Hearts", "10 of Diamonds", "Ace of Spades"
    @Override
    public String toString() {
        return getValueAsString() + " of " + getSuitAsString();
    }
}
