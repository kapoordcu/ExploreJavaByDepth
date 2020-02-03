package explore.topics._arrays;

import java.util.ArrayList;
import java.util.List;

public class StockProfit {
    public static void main(String[] args) {
        int[] arr7 = {100, 180, 260, 310, 40, 535, 695};
        int[] arr10 = {10, 23, 13, 25, 29, 33, 19, 34, 45, 65, 67};
                        //(0 3) (4 6)
                        //(1 4) (5 9)
        findMaxProfitDays(arr7).stream().forEach(System.out::println);
        findMaxProfitDays(arr10).stream().forEach(System.out::println);
    }

    private static List<Stock> findMaxProfitDays(int[] arr) {
        List<Stock> days = new ArrayList<>();
        int start = 0;
        for (int j = 0; j < arr.length; j++) {
            while(j+1<arr.length && arr[j] < arr[j+1]) {
                j++;
            }
            days.add(new Stock(start, j));
            start = j+1;
        }
        return days;
    }
}

class Stock {
    private Integer buy;
    private Integer sell;

    public Stock(Integer buy, Integer sell) {
        this.buy = buy;
        this.sell = sell;
    }

    @Override
    public String toString() {
        return "("+buy +
                ", " + sell +
                ')';
    }
}