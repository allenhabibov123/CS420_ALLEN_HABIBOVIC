import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Deck implements Iterable<Card>{
    private List<Card> deck;
    private String[] suits = {"Hearts","Clubs","Diamonds","Spades"};
    public Deck() {
/* TODO 
This constructor initializes the deck variable with
all the cards of a deck, except a joker.
The suits array may help you.*/
            this.deck = new LinkedList<Card>();
            Integer[] number_values = {2, 3, 4, 5, 6, 7, 8, 9, 10};
            String[] face_values = {"Ace", "Jack", "Queen", "King"};

            int k = 0;

            //Add number value cards Card<Integer, String> to list object deck

            for(int i = 0; i < number_values.length; i++) {
                for(int j = 0; j < this.suits.length; j++) {
                    this.deck.add(k++, new Card<Integer, String>(number_values[i], this.suits[j]));
                }
            }

            //Add face value cards Card<String, String> to list object deck

            for(int i = 0; i < face_values.length; i++) {
                for(int j = 0; j < this.suits.length; j++) {
                    this.deck.add(k++, new Card<String, String>(face_values[i], this.suits[j]));
                }
            }
    }

    public Card dealCard(){
        int index = (int) (Math.random() * this.deck.size());
        return this.deck.remove(index);
    }

    public int size(){/* TODO: Return the size of the deck (number of cards left in it)*/
        return this.deck.size();
    }
    @Override
    public Iterator<Card> iterator() {
       /* TODO 
Return a new DeckIterator with this instance in the constructor.*/
        return (Iterator<Card>) new DeckIterator<Card>(this);
    }
}
