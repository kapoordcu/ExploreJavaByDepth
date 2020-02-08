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
        int i = 0;
        while (Math.pow(2, i) < number) {
            i++;
        }
        int value = (int) Math.pow(2, i-1);
        int diff = number - value;
        return i + diff;
    }
}
