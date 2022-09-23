package threads;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public final class BankAccount {

    class Bank {
        private final Map<String, Integer> accountsMap = new HashMap<>(0);

        public int addMoney(String user, int amount) {
            synchronized (this.accountsMap) {
                this.accountsMap.putIfAbsent(user, 0);
                int before = this.accountsMap.get(user);
                int after = before + amount;
                this.accountsMap.put(user, after);
            }
            return this.accountsMap.getOrDefault(user, 0);
        }
    }


    @Test
    public void testAddMoney() throws InterruptedException {
        final Bank bank = new Bank();
        final String user = UUID.randomUUID().toString();
        int amount = bank.addMoney(user, 20);

        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        executorService.submit(() -> bank.addMoney(user, 10));
        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);
        assertEquals(bank.addMoney(user, 0), 10020);
    }
}
