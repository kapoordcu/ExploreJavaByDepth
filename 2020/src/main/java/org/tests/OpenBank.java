package org.tests;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.assertTrue;

public class OpenBank {
    public int solution(String[] transactions, int customerId, String depositOpeningDate) {
        Map<Integer, Integer> accountMap = new HashMap<>();

        for (String s: transactions) {
            String[] txSingle = s.split(",");
            try {
                String income = txSingle[0].trim();
                String outcome = txSingle[1].trim();

                if(!"-".equals(income)) {
                    if(Integer.parseInt(income)==customerId &&
                            dateWithin6Months(depositOpeningDate, txSingle[5].trim())) {
                        accountMap.compute(customerId, (key, value) -> value==null ?
                                Integer.parseInt(txSingle[4].trim()):
                                value + Integer.parseInt(txSingle[4].trim()));
                    } else if(!"-".equals(outcome) && Integer.parseInt(outcome)==customerId && dateWithin6Months(depositOpeningDate, txSingle[5].trim())) {
                        accountMap.put(customerId,
                                accountMap.get(customerId) - Integer.parseInt(txSingle[4].trim()));;
                    }
                }

            } catch (Exception ex) {

            }
        }
        return accountMap.isEmpty() ? 0 : accountMap.get(customerId);
    }

    private boolean dateWithin6Months(String depositOpeningDate, String txDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = null;
        Date d2 = null;
        long diffDays = 0;
        try {
            d1 = format.parse(depositOpeningDate);
            d2 = format.parse(txDate);
            diffDays = d2.getDate() - d1.getDate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return diffDays <= 180;
    }

    @Test
    public void set1() {
        String[] Array = {
                "123456, -, 889, 583, 1300, 2019-01-24",
                "654321, 123456, 889, 162, 300, 2019-03-20"
        };
        int customerId = 123456;
        OpenBank bank = new OpenBank();
        int widest = bank.solution(Array, customerId, "2019-04-01");
        assertTrue(widest==1000);
    }

    @Test
    public void set2() {
        String[] Array = {
                "300000,700000,ES3121008658566954296565,ES6904878158275249366687,323,2018-5-4", "800000,100000,ES0814654522412615872982, ES6430041924028299968687,296,2019-8-19", "300000,200000,ES9614651697647688594899,ES6930048133763392173873,791,2017-5-16", "200000,600000,ES8414651244168229178613,ES0420953235426898657233,927,2017-8-2", "700000,500000,ES9530044593853321965115,ES8301289326076928826327,812,2018-11-23", "100000,700000,ES2130048185213129182321,ES9420952372123278133232,259,2019-5-22", "100000,600000,ES8314654911738512896259,ES6800812517606595251557,1498,2017-2-20", "900000,400000,ES4801826558032478218279,ES3501285314715133168983,1551,2018-6-18", "700000,100000,ES1001826437847872958688,ES9820959425548994486644,948,2017-4-30", "600000,400000,ES3021003449693573877282,ES7700816662075398165779,234,2018-4-13"
        };
        int customerId = 400000;
        OpenBank bank = new OpenBank();
        int widest = bank.solution(Array, customerId, "2018-3-23");
        assertTrue(widest==0);
    }
}