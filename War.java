import java.util.Scanner;
import java.util.ArrayList;

public class War {

  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    System.out.println("Welcome to War\n--------------");

    // Initialize players
    System.out.print("Player 1 Name: ");
    Player player1 = new Player(kb.next());
    System.out.print("Player 2 Name: ");
    Player player2 = new Player(kb.next());

    // Initialize deck
    Deck deck = new Deck();
    System.out.println("Shuffling the deck and dealing to " + player1.getName() + " and " + player2.getName() + "...");
    deck.shuffle();
    while (deck.report() != 0) {
      player1.addCardToHand(deck.deal());
      player2.addCardToHand(deck.deal());
    }

    // Start of the game
    System.out.println("Cards have been dealt, start!");
    boolean finished = false;
    while (!finished) {
      // Check if both players have cards to play
      if (checkEmpty(player1) || checkEmpty(player2)) {
        break;
      }
      // Play cards
      Card card1 = player1.playCard();
      Card card2 = player2.playCard();
      System.out.println(player1.getName() + " played: " + card1);
      System.out.println(player2.getName() + " played: " + card2);

      // Trick list is initially an ArrayList for easier expansion
      ArrayList<Card> trickL = new ArrayList<>();
      trickL.add(card1);
      trickL.add(card2);

      // Check for War
      if (card1.equals(card2)) {
        System.out.println("\t" + "We have War!");
        boolean warWon = false;
        while (!warWon) {
          // Check if both players have cards to play
          if (checkEmpty(player1) || checkEmpty(player2)) {
            break;
          }
          trickL.add(player1.playCard());
          trickL.add(player2.playCard());
          System.out.println("\t" + "Two cards have been placed face down. Two more will be placed face up.");

          // Check if both players have cards to play for the war
          if (checkEmpty(player1) || checkEmpty(player2)) {
            break;
          }
          // Play current cards for the war
          Card warCard1 = player1.playCard();
          Card warCard2 = player2.playCard();
          System.out.println("\t" + player1.getName() + " played: " + warCard1);
          System.out.println("\t" + player2.getName() + " played: " + warCard2);
          // Add current cards trick list
          trickL.add(warCard1);
          trickL.add(warCard2);

          // Convert trickL (ArrayList) to trickA (Array)
          Card[] trickA = new Card[trickL.size()];
          trickA = trickL.toArray(trickA);

          if (warCard1.equals(warCard2)) {
            System.out.println("\t" + "Another tie, War continues!");
          } else {
            if (warCard1.compareTo(warCard2) > 0) {
              System.out
                  .println("\t" + player1.getName() + " won the War! They get collect all the cards on the table.");
              player1.collectTrick(trickA);
              warWon = true;
            } else {
              System.out
                  .println("\t" + player2.getName() + " won the War! They get collect all the cards on the table.");
              player2.collectTrick(trickA);
              warWon = true;
            }
          }
        }
      } else {
        // If not war:
        // Convert trickL (ArrayList) to trickA (Array)
        Card[] trickA = new Card[trickL.size()];
        trickA = trickL.toArray(trickA);

        if (card1.compareTo(card2) > 0) {
          System.out.println("\t" + player1.getName() + " won the " + card1 + " and the " + card2 + "!");
          player1.collectTrick(trickA);
        } else {
          System.out.println("\t" + player2.getName() + " won the " + card2 + " and the " + card1 + "!");
          player2.collectTrick(trickA);
        }
      }

      System.out.println(player1.getName() + " has " + player1.report() + " cards.");
      System.out.println(player2.getName() + " has " + player2.report() + " cards.");

      if (player1.report() == 52 || player1.report() == 52) {
        finished = true;
      }
      pressEnter();
    }

    if (player1.report() == 52 && player2.report() == 0) {
      System.out.println(player1.getName() + " won the game!");
    }

    if (player2.report() == 52 && player1.report() == 0) {
      System.out.println(player2.getName() + " won the game!");
    }
  }

  public static void pressEnter() {
    Scanner kb = new Scanner(System.in);
    System.out.println("Press ENTER to continue.");
    kb.nextLine();
  }

  public static boolean checkEmpty(Player player) {
    if (player.report() == 0) {
      System.out.println(player.getName() + " ran out of cards!");
      return true;
    }
    return false;
  }
}