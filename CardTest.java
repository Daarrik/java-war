public class CardTest {
  public static void main(String[] args) {
    /*
     * Card card = new Card(Rank.ACE, Suit.SPADES);
     * Card card2 = new Card(Rank.THREE, Suit.SPADES);
     * System.out.println(card);
     * System.out.println(card.compareTo(card2));
     * System.out.println(card2.compareTo(card));
     * System.out.println(card.equals(card2));
     */

    Deck deck = new Deck();
    System.out.println(deck);

    deck.shuffle();
    System.out.println(deck);

    deck.shuffle();
    System.out.println(deck);

    /*
     * System.out.println(deck.deal());
     * System.out.println(deck);
     */
  }
}