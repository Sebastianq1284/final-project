import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

class Player{
  public ArrayList<Card> hand;
  public Player() {
    this.hand = new ArrayList<Card>();
  }
  public void drawCard(Deck deck) {
    Card card = deck.draw();
    this.hand.add(card);
  }
  public ArrayList<Integer> getHand(){
    ArrayList<Integer> handValues = new ArrayList<Integer>();
    for (Card card : this.hand){
      handValues.add(card.getValue());
    }
    return handValues;
  }
  public int getHandValue(){
    int value = 0;
    boolean hasAce = false;
    for (Card card : this.hand){
        int cardValue = card.getValue();
        if (cardValue == 1) {
            hasAce = true;
        }
        value += cardValue;
    }
    return value;
}

}
