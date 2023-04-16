import java.util.ArrayList;
import java.util.Collections;

class Deck {
    public ArrayList<Card> cards = new ArrayList<Card>();
public int[] ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

    public Deck() {
        this.cards = new ArrayList<Card>();
        for (int rank : ranks) {
            for(int i = 0; i < 4; i++){
              Card card = new Card(rank);
              this.cards.add(card);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public Card draw() {
        return this.cards.remove(0);
    }
}


