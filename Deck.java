import java.util.Random;

public class Deck {

  private Card[] deck;

  public Deck() {
    deck = new Card[52];
    int i = 0;
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        deck[i] = new Card(rank, suit);
        i++;
      }
    }
  }

  public void shuffle() {
    Random random = new Random();
    for (int i = deck.length - 1; i > 0; i--) {
      int rand = random.nextInt(i);
      Card temp = deck[i];
      deck[i] = deck[rand];
      deck[rand] = temp;
    }
  }

  public Card deal() {
    Card card = deck[0];
    Card[] newDeck = new Card[deck.length - 1];
    for (int i = 0; i < newDeck.length; i++) {
      newDeck[i] = deck[i + 1];
    }
    deck = newDeck;
    return card;
  }

  public int report() {
    return deck.length;
  }

  public String toString() {
    String cards = "";
    for (int i = 0; i < deck.length; i++) {
      cards += "" + (i + 1) + ": " + deck[i] + "\n";
    }
    return cards;
  }
}