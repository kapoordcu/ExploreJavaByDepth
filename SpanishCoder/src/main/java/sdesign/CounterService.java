package sdesign;

import java.util.concurrent.atomic.AtomicLong;

public class CounterService {
    private static AtomicLong seed = new AtomicLong(10000L);

    public static long generateUniqueKey() {
        return seed.incrementAndGet();
    }
}
