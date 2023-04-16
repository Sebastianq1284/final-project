import java.util.ArrayList;
import java.util.Scanner;

class Card {
    private int value;
    public int rank;

    public Card(int value) {
        this.value = value;
    }

   public int getValue() {
    if (this.value >= 2 && this.value <= 11 || this.value >= 12 && this.value <= 13) {
        return this.value;
    }
     
    System.err.println("");
    return 0;
  }
}