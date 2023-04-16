import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Deck deck = new Deck();
    deck.shuffle();
    Player player = new Player();
    Player dealer = new Player();
    player.drawCard(deck);
    dealer.drawCard(deck);
    player.drawCard(deck);
    dealer.drawCard(deck);
    System.out.println("Your hand: " + player.getHand());
    System.out.println("Dealer's hand: " + dealer.getHand());
    boolean playerDone = false;
    boolean dealerDone = false;
    int id = 0;
    while (true) {

      if (!playerDone) {
        System.out.println("Do you want to hit or stand?\n");
        String choice = input.nextLine();
        if (choice.equalsIgnoreCase("hit")) {
          player.drawCard(deck);
          System.out.println("\nYour hand: " + player.getHand());
          System.out.println("Dealer's hand: " + dealer.getHand() + "\n");
          if (player.getHandValue() > 21) {
            System.out.println("Busted, you lose.");
            return;
          }
          id++;
        } else if (choice.equalsIgnoreCase("stand")) {
          playerDone = true;
          id++;
        }
      }

      if (!dealerDone) {
        if (dealer.getHandValue() < 16) {
          dealer.drawCard(deck);
        } else {
          dealerDone = true;
        }
        if (dealer.getHandValue() > 21) {
          dealerDone = true;
        } 
        id++;
      }

      if (playerDone && dealerDone) {
        break;
      }
    }

    System.out.println("Your hand: " + player.getHand());
    System.out.println("Dealer's hand: " + dealer.getHand() + "\n");
    if (player.getHandValue() > 21) {
      System.out.println("Busted, you lose.");
    } else if (dealer.getHandValue() > 21) {
      System.out.println("Dealer busted, you win.");
    } else if (player.getHandValue() == 21) {
      System.out.println("Blackjack! You win!");
    } else if (dealer.getHandValue() == 21) {
      System.out.println("Dealer has Blackjack. You lose.");
    } else if (player.getHandValue() > dealer.getHandValue()) {
      System.out.println("You win!");
    } else if (dealer.getHandValue() > player.getHandValue()) {
      System.out.println("Dealer wins.");
    } else if (player.getHandValue() == dealer.getHandValue()) {
      System.out.println("It's a tie.");
    } else {
      System.out.println("This event should never happen.");
    }
  }
}
