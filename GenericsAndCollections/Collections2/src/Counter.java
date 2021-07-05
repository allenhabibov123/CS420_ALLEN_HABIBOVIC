import java.util.HashMap;
import java.util.Set;

public class Counter<E> {
    private HashMap<E, Integer> counts;

    public Counter(E[] things){
/* TODO
Loop through the elements of "things" and use the HashMap "counts"
to store the elements of things as keys, and the number of times they
appear in the array as values. Check the instructions. */
        this.counts = new HashMap<E, Integer>();
        for(int i = 0; i < things.length; i++) {
            if(this.counts.containsKey(things[i])) {
                this.counts.put(things[i], this.counts.get(things[i]) + 1);
            }else {
                this.counts.put(things[i], 1);
            }
        }
    }

    public Integer getCount(E element){
      /* TODO 
This just returns the specific count for an element. It is a wrapper
for a getting the value of the HashMap given the key "element" */
        return this.counts.get(element);
    }

    public int getSize(){
        return this.counts.size();
    }

    public E mostFrequent()/* TODO 
Returns the most frequent key in the HashMap*/ {

        int max_occurences = -1;
        E most_frequent_key = null;

        for(E key: this.counts.keySet()) {
           int curr_occurence = (int) this.counts.get(key);
           if(curr_occurence > max_occurences){
               max_occurences = curr_occurence;
               most_frequent_key = key;
           }
        }
        return most_frequent_key;
    }
}
