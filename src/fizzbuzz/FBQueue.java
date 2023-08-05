package fizzbuzz;

import java.util.concurrent.ConcurrentLinkedDeque;

public class FBQueue {
    private final ConcurrentLinkedDeque<String> fbNumbers = new ConcurrentLinkedDeque<>();

    public String getRs() {
        return fbNumbers.poll();
    }
    public void setRs(String rs) {
        this.fbNumbers.add(rs);
    }

    public int getSize() {
        return fbNumbers.size();
    }

    public ConcurrentLinkedDeque<String> getFbNumbers() {
        return fbNumbers;
    }
}
