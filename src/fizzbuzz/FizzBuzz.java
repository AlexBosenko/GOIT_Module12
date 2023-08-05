package fizzbuzz;

import java.util.concurrent.atomic.AtomicBoolean;

public class FizzBuzz extends Thread{
    private int number;
    private AtomicBoolean processed = new AtomicBoolean(true);
    private final FBQueue fbQueue;
    private final int id;
    private boolean finalNumber;

    public FizzBuzz(int id, FBQueue fbQueue) {
        this.id = id;
        this.fbQueue = fbQueue;
    }

    public synchronized void setNumber(int n, boolean finalNumber) {
        this.number = n;
        this.finalNumber = finalNumber;
        processed.set(false);
    }

    private void fizz() {
        if (number % 3 == 0 && number % 5 != 0) {
            fbQueue.setRs("Fizz");
        }
    }
    private void buzz() {
        if (number % 3 != 0 && number % 5 == 0) {
            fbQueue.setRs("Buzz");
        }
    }
    private void fizzbuzz() {
        if (number % 3 == 0 && number % 5 == 0) {
            fbQueue.setRs("FizzBuzz");
        }
    }
    private void checkNumber() {
        if (number % 3 != 0 && number % 5 != 0) {
            fbQueue.setRs(String.valueOf(number));
        }
        String coma = finalNumber ? "" : ", ";
        while (fbQueue.getSize() > 0) {
            System.out.print(fbQueue.getRs() + coma);
        }
    }
    public boolean isProcessed() {
        return processed.get();
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            if (processed.get()) {
                continue;
            }

            if (id == 0) {
                fizz();
            }
            if (id == 1) {
                buzz();
            }
            if (id == 2) {
                fizzbuzz();
            }
            if (id == 3) {
                checkNumber();
            }

            processed.set(true);
        }
    }
}
