package timers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerTest {
    public static void main(String[] args) {
        long currentTime = System.currentTimeMillis();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
                    long duration = System.currentTimeMillis() - currentTime;
                    System.out.printf("%,9.3f сек.\n", duration / 1_000.0);
                },
                1,
                1,
                TimeUnit.SECONDS);
        scheduler.scheduleWithFixedDelay(() -> System.out.println("Минуло 5 секунд"),
                5,
                5,
                TimeUnit.SECONDS);
    }
}
