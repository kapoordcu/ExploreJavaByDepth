package explore.topics.hackerrank;

public class CalculateTheSquare {
    public static void main(String[] args) {
        CalculateTheSquare square = new CalculateTheSquare();
        System.out.println(square.solution(6000, 7000));

    }

    public int solution(int lowLimit, int higherLimit) {
        int repeatedSquareRootOperations = 0;
        for (int i = lowLimit; i < higherLimit; i++) {
            if(isWholeNumber(i)) {
                int currentNumberCount = countRecursiveSquares(i);
                repeatedSquareRootOperations = (repeatedSquareRootOperations > currentNumberCount) ?
                        repeatedSquareRootOperations : currentNumberCount;
            }
        }
        return repeatedSquareRootOperations;
    }

    public int countRecursiveSquares(double number) {
        int recursiveOps = 0;
        while (number>0 && isWholeNumber(number)) {
            number = Math.sqrt(number);
            recursiveOps++;
        }
        return recursiveOps;
    }

    public boolean isWholeNumber(double number) {
        double sr = Math.sqrt(number);
        return ((sr - Math.floor(sr)) == 0);
    }


}
