package chapter4;

/**
 * @author z
 */
public class Counter {
    private int count;

    public Counter(int count) {
        this.count = count;
    }

    public Counter() {
        this(0);
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void add(int step) {
        count += step;
    }
}
