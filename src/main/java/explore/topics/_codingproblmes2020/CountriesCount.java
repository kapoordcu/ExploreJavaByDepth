package explore.topics._codingproblmes2020;

import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class CountriesCount {
    private static int count = 0;
    public static void main(String[] args) {
        int[][] A = {
                {5, 5, 4},
                {4, 3, 4},
                {3, 2, 4},
                {2, 2, 2},
                {3, 3, 4},
                {1, 4, 4},
                {4, 1, 1}
        };
        CountriesCount countriesCount = new CountriesCount();
        System.out.println(countriesCount.solution(A));
    }

    public int solution(int[][] A){
        Boolean[][] auxilaryFlagArray = new Boolean[A.length][];
        for(int i=0;i<A.length;i++){
            auxilaryFlagArray[i] = new Boolean[A[i].length];
            Arrays.fill(auxilaryFlagArray[i],false);
        }

        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[i].length;j++){
                checkNeighboringCountry(A,auxilaryFlagArray, i,j);
            }
        }
        return count;
    }

    private void checkNeighboringCountry(int[][] A, Boolean[][] auxilaryFlagArray, int row, int column) {
        if(!auxilaryFlagArray[row][column]){
            Stack<ArrayNode> stack = new Stack<>();
            ArrayNode next = new ArrayNode(row,column);
            next.setValue(A[next.getRow()][next.getCol()]);
            ++count;
            stack.push(next);

            while(!stack.empty()){
                ArrayNode stackPop = stack.pop();
                if(auxilaryFlagArray[stackPop.getRow()][stackPop.getCol()]) {
                    break;
                }
                auxilaryFlagArray[stackPop.getRow()][stackPop.getCol()] = true;

                ArrayNode right = stackPop.right();
                moveColumnDirection(stackPop, right, A, row, stack, auxilaryFlagArray);

                ArrayNode left = stackPop.left();
                moveColumnDirection(stackPop, left, A, row, stack, auxilaryFlagArray);

                ArrayNode up = stackPop.up();
                moveRowDirection(stackPop, up, A, row, stack, auxilaryFlagArray);

                ArrayNode down = stackPop.down();
                moveRowDirection(stackPop, down, A, row, stack, auxilaryFlagArray);

            }
        }
    }

    private void moveColumnDirection(ArrayNode top, ArrayNode current, int[][] A,
                                    int row, Stack<ArrayNode> stack, Boolean[][] auxilaryFlagArray) {
        if(current.getCol()>=0 && current.getCol()<A[row].length){
            current.setValue(A[current.getRow()][current.getCol()]);
            if(top.getValue()==current.getValue() && !auxilaryFlagArray[current.getRow()][current.getCol()]){
                stack.push(current);
            }
        }
    }

    private void moveRowDirection(ArrayNode top, ArrayNode current, int[][] A,
                                     int column, Stack<ArrayNode> stack, Boolean[][] auxilaryFlagArray) {
        if(current.getRow()>=0 && current.getRow()<A.length){
            current.setValue(A[current.getRow()][current.getCol()]);
            if(top.getValue()==current.getValue() && !auxilaryFlagArray[current.getRow()][current.getCol()]){
                stack.push(current);
            }
        }
    }

}

class ArrayNode {
    private int row;
    private int col;
    private int value;

    public ArrayNode(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ArrayNode right(){
        return new ArrayNode(this.row,this.col+1);
    }
    public ArrayNode left(){
        return new ArrayNode(this.row,this.col-1);
    }

    public ArrayNode up(){
        return new ArrayNode(this.row-1,this.col);
    }

    public ArrayNode down(){
        return new ArrayNode(this.row+1,this.col);
    }
}
