package explore.topics.testlive;

public class EquilibriumArray2019 {
    public static void main(String[] args) {
        int[] arrayEq1 = {4, 1, 1, 1, 1};
        int[] arrayEq2 = {4, -1, 1, 1, 1};
        int[] arrayEq3 = {2, 1, 1, 3, 1};
        int[] arrayEq4 = {2, 1, 2, 3, 1};
        //System.out.println(isBalancedArray(arrayEq1));
        //System.out.println(isBalancedArray(arrayEq2));
        System.out.println(isBalancedArray(arrayEq3));
       // System.out.println(isBalancedArray(arrayEq4));
    }

    private static boolean isBalancedArray(int[] arrayEq) {
        for (int i = 0; i < arrayEq.length - 1; i++) {
            for (int j = i+1; j < arrayEq.length; j++) {
                int left = sumLeft(arrayEq, i);
                int right = sumRightPart(arrayEq, j);

                System.out.println(left);
                System.out.println(right);
                if(left==right) {
                    return true;
                }
            }
            System.out.println("----");
        }
        return false;
    }

    private static int sumLeft(int[] arrayEq, int endIndex) {
        int sum = 0;
        for (int i = 0; i <=endIndex ; i++) {
            sum+= arrayEq[i];
        }
        return sum;
    }

    private static int sumRightPart(int[] arrayEq, int startIndex) {
        int sum = 0;
        for (int i = startIndex; i < arrayEq.length; i++) {
            sum+= arrayEq[i];
        }
        return sum;
    }
}
