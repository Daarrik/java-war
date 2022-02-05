public class Card {

    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public int compareTo(Card other) {
        return rank.compareTo(other.rank);
    }

    public boolean equals(Card other) {
        return compareTo(other) == 0;
    }

    public String toString() {
        return rank + " of " + suit;
    }
}