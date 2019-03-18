package explore.topics.hackerrank;

public class LinkeListByIndexLength {
    public static void main(String[] args) {
        LinkeListByIndexLength linkeListByIndexLength = new LinkeListByIndexLength();
        int[] array = {1, -1, -1, 2, 5, 2, 4};
        System.out.println(linkeListByIndexLength.solution(array));
    }

    public int solution(int[] A) {
        int length = A.length;
        int linkedListLength = 0;
        for (int i = 0; i < length ; i=i) {
            if(A[i] != -1) {
                i = A[i];
                linkedListLength++;
            } else {
                linkedListLength++;
                return linkedListLength;
            }

        }
        return linkedListLength;
    }
}
