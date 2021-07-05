import java.util.Iterator;

public class DeckIterator<E> implements Iterator {
    Deck d;
    public DeckIterator(Deck d){
/* TODO
initialize the variable d */
        this.d = d;
    }


    public boolean hasNext() {
       /* TODO
Return true if there are elements left in the Deck */
        return (this.d.size() == 0) ? false : true;
    }


    public E next() {
        /* TODO
Deal a card and return it. */
        return (E)this.d.dealCard();
    }
}
