package fizzbuzz;

public class FizzBuzzTest {
    public static void main(String[] args) {
        final int number = 20;
        FBQueue fbQueue = new FBQueue();

        FizzBuzz threadA = new FizzBuzz(0, fbQueue);
        FizzBuzz threadB = new FizzBuzz(1, fbQueue);
        FizzBuzz threadC = new FizzBuzz(2, fbQueue);
        FizzBuzz threadD = new FizzBuzz(3, fbQueue);

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        for (int i = 1; i <= number; i++) {
            threadA.setNumber(i, i == number);
            threadB.setNumber(i, i == number);
            threadC.setNumber(i, i == number);
            threadD.setNumber(i, i == number);

            while (true) {
                if (threadA.isProcessed()
                        && threadB.isProcessed()
                        && threadC.isProcessed()
                        && threadD.isProcessed()) {
                    break;
                }
            }
        }
        System.exit(0);
    }
}
