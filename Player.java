public class Player {

  private String name;
  private Card[] hand;

  public Player(String playerName) {
    name = playerName;
    hand = new Card[0];
  }

  public String getName() {
    return name;
  }

  public void addCardToHand(Card c) {
    Card[] newHand = new Card[hand.length + 1];
    for (int i = 0; i < hand.length; i++) {
      newHand[i] = hand[i];
    }
    newHand[newHand.length - 1] = c;
    hand = newHand;
  }

  public void collectTrick(Card[] list) {
    for (int i = 0; i < list.length; i++) {
      addCardToHand(list[i]);
    }
  }

  public Card playCard() {
    if (hand.length == 0)
      return null;

    Card card = hand[0];
    Card[] newHand = new Card[hand.length - 1];
    for (int i = 0; i < newHand.length; i++) {
      newHand[i] = hand[i + 1];
    }
    hand = newHand;
    return card;
  }

  public int report() {
    return hand.length;
  }
}