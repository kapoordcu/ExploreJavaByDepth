package explore.topics.test;

import java.io.*;
import java.util.*;

/*

Tasks 3

Most european countries do use the EURO as their currency. It has bills for 500€, 200€, 100€, 50€, 20€, 10€ & 5€ as well coins for 2€, 1€, 50ct, 20ct, 10ct, 5ct, 2ct, 1ct across the countries.

Your should write a program / function which generates the minimal numbers of bills & coins while inputting any money amount, e.g. https://rechneronline.de/geld/ (german only)

Examples:
52.54€ ⇒ 1x 50€ + 1x 2€ + 1x 50c + 2x 2ct
99ct  => 1x 50ct + 2x 20ct + 1x 5ct + 2x 2ct


 */

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minimumBills(52.54);

    }

    public int minimumBills(Double amount) {
        List<Integer> notes = Arrays.asList(500, 200, 100, 50, 20, 10 , 5);
        List<Integer> coins = Arrays.asList(200, 100, 50, 20, 10, 5, 2, 1);
        Map<Integer, Integer> countOfDenominationMap = new HashMap<>();
        String amountValue = String.valueOf(amount);
        String[] euroAndCents = amountValue.trim().split("\\.");
        if(euroAndCents.length==2) {
            String euro = euroAndCents[0];

            String cents = euroAndCents[1];
            Double finalAmount = amount;
            int closest = notes.stream().filter(i -> i< finalAmount)
                    .min(Comparator.comparingInt(i -> Math.abs(i - Integer.valueOf(euro))))
                    .orElseThrow(() -> new NoSuchElementException("No value present"));
            amount = amount - closest;
            int remaining = amount.intValue() - closest;
            while(amount!=0) {

            }

        }
        return 0;

    }
}