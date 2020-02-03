package explore.topics._arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StockProfit {
    public static void main(String[] args) {
        int[] arr7 = {100, 180, 260, 310, 40, 535, 695};
        int[] arr10 = {10, 23, 13, 25, 29, 33, 19, 34, 45, 65, 67};
        int[] arrRsan = {21, 5, 12, 14, 19, 18, 13, 16, 20};
                        //(0 3) (4 6)
                        //(1 4) (5 9)

        List<Stock> stocks = new LinkedList<>();
        System.out.println("Profit: " + findMaxProfitDaysON(arr7, stocks));
        printStockIndexes(stocks);
        System.out.println("Profit: " + findMaxProfitDaysON(arr10, stocks));
        printStockIndexes(stocks);
        System.out.println("Profit: " + findMaxProfitDaysON(arrRsan, stocks));
        printStockIndexes(stocks);

        findMaxProfitDaysONEASYCODE(arr7);
        findMaxProfitDaysONEASYCODE(arr10);
        findMaxProfitDaysONEASYCODE(arrRsan);
    }

    private static void printStockIndexes(List<Stock> stocks) {
        stocks.stream().forEach(System.out::println);
        stocks.clear();
    }

    private static int findMaxProfitDaysON(int[] arr, List<Stock> stocks) {
        int buy_day = 0;
        int max_profit = 0;
        int total_profit = 0;
        int buy_day_Element = arr[buy_day];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > buy_day_Element) {
                max_profit = max_profit + arr[i]-buy_day_Element;
                buy_day_Element = arr[i];
            } else {
                if(buy_day!=i-1) {
                    stocks.add(new Stock(buy_day, i-1));
                }
                buy_day = i;
                buy_day_Element = arr[buy_day];
                total_profit += max_profit;
                max_profit = 0;
            }
            if(i==arr.length-1) {
                total_profit += max_profit;
                stocks.add(new Stock(buy_day, i));
            }
        }
        return total_profit;
    }

    public static void findMaxProfitDaysONEASYCODE(int arr[]) {
        int n = arr.length;
        if (n == 1) {
            return;
        }

        List<Stock> sol = new ArrayList<Stock>();

        int i = 0;
        while (i < n - 1) {
            while ((i < n - 1) && (arr[i + 1] <= arr[i])) {
                i++;
            }
            if (i == n - 1) {
                break;
            }
            Stock e = new Stock();
            e.setBuy(i++);
            while ((i < n) && (arr[i] >= arr[i - 1])) {
                i++;
            }
            e.setSell(i-1);
            sol.add(e);

        }

        // print solution
        if (sol.size() == 0) {
            System.out.println("There is no day when buying the stock "
                    + "will make profit");
        }
        else {
            for (int j = 0; j < sol.size(); j++) {
                System.out.println(sol);
            }
        }
    }
}

class Stock {
    private Integer buy;
    private Integer sell;

    public Stock(Integer buy, Integer sell) {
        this.buy = buy;
        this.sell = sell;
    }

    public Stock() {
    }

    public void setBuy(Integer buy) {
        this.buy = buy;
    }

    public void setSell(Integer sell) {
        this.sell = sell;
    }

    @Override
    public String toString() {
        return "(" + buy + ", " + sell + ')';
    }
}