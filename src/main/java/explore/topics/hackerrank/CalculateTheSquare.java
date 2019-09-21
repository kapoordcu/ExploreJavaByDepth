package explore.topics.hackerrank;

public class CalculateTheSquare {
    public static void main(String[] args) {
        CalculateTheSquare square = new CalculateTheSquare();
        System.out.println(square.solutionOsqrtBA(0, 1));
    }

    public int solution(int A, int B) {
        int repeatedSquareRootOperations = 0;
        for (int i = A; i <= B; i++) {
            if(isWholeNumber(i) && i!=1) {
                int currentNumberCount = countRecursiveSquares(i);
                repeatedSquareRootOperations = (repeatedSquareRootOperations > currentNumberCount) ?
                        repeatedSquareRootOperations : currentNumberCount;
            }
        }
        return repeatedSquareRootOperations;
    }

    public int solutionOsqrtBA(int A, int B) {
        int repeatedSquareRootOperations = 0;
        int currNumber = (int) Math.ceil(Math.sqrt(A));
        int squareValue = 0;
        while((squareValue = currNumber*currNumber) <= B) {
            int currentNumberCount = countRecursiveSquares(squareValue);
            repeatedSquareRootOperations = (repeatedSquareRootOperations > currentNumberCount) ?
                    repeatedSquareRootOperations : currentNumberCount;
            currNumber++;
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
        double sqrt = Math.sqrt(number);
        return ((sqrt - Math.floor(sqrt)) == 0);
    }


}
