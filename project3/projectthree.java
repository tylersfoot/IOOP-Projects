/**
 * Project 3
 *
 * @author (Tyler Depa)
 * @version (v1.0, 11-1-2023)
 */
public class projectthree 
{
    public static void main(String[] args)
    {
        // P1();
        // P2();
        P3();
    }

    static void P1() {
        System.out.println("\nOutput for P3\n");

        Deck deck = new Deck();

        for (int i = 0; i < 52; i++) {
            CardP3 card = deck.DealACard();
            card.Display();
            System.out.println();
        }

        // new full deck because all cards were drawn - not in provided java file but when you
        // draw 52 cards theres none left in the deck to shuffle?
        deck = new Deck();

        deck.Shuffle(100);

        System.out.println("\nAfter Shuffle\n");

        for (int i = 0; i < 52; i++) {
            CardP3 card = deck.DealACard();
            card.Display();
            System.out.println();
        }
    }

    static void P2() {
        HighLow game = new HighLow();
    }

    static void P3() {
        GHighLow game = new GHighLow();
    }
}