package explore.topics._dynamicprog;

public class MinimumOperations {
    public static void main(String[] args) {
        MinimumOperations mi = new MinimumOperations();
        System.out.println(mi.findMinOps(21));
        System.out.println(mi.findMinOps(38));
        System.out.println(mi.findMinOps(8));
        System.out.println(mi.findMinOps(7));
    }

    private int findMinOps(int number) {
        int cost = 0;
        while (number!=0) {
            if(number%2==0) {
                cost += findMinOption(number-1);
            } else {
                cost +=  1 + findMinOption(number-1);
            }
            number = number/2;
        }

        return cost;
    }

    private int findMinOption(int number) {
        int diff = number - number/2;
        return Math.min(1, diff);
    }
}
