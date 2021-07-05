public class BingoChip<T, S> {/* TODO
Implement this class.
Use the instructions and check how it is used in Task.java*/
    T col;
    S num;

    public BingoChip(T col, S num) {
        this.col = col;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Chip:" + col + "-" + num;
    }
}

