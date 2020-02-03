package explore.topics._arrays;

import java.util.ArrayList;
import java.util.List;

public class StockProfit {
    public static void main(String[] args) {
        int[] arr7 = {100, 180, 260, 310, 40, 535, 695};
        int[] arr10 = {10, 23, 13, 25, 29, 33, 19, 34, 45, 65, 67};
                        //(0 3) (4 6)
                        //(1 4) (5 9)

        List<Stock> stocks = new ArrayList<>();
        System.out.println(findMaxProfitDaysNaive(arr7, stocks));
        stocks.clear();
        System.out.println(findMaxProfitDaysNaive(arr10, stocks));
        stocks.clear();
        System.out.println(findMaxProfitDaysON(arr7, stocks));
        stocks.clear();
        System.out.println(findMaxProfitDaysON(arr10, stocks));
        stocks.clear();
    }

    private static int findMaxProfitDaysON(int[] arr, List<Stock> stocks) {
        return 0;
    }

    private static int findMaxProfitDaysNaive(int[] arr7, List<Stock> stocks) {
        return 0;
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
        return "(" + buy + ", " + sell + ')';
    }
}