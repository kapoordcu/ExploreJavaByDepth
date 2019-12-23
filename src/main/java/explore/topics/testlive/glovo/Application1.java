package explore.topics.testlive.glovo;// you can also use imports, for example:

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class Application1 {


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
        Application1 application1 = new Application1();
        System.out.println(application1.solution(A));
    }

    public int solution(int[][] A){
        Boolean[][] boolBitMap = new Boolean[A.length][];
        CountriesCount countriesCount = new CountriesCount();

        for(int i=0;i<A.length;i++){
            boolBitMap[i] = new Boolean[A[i].length];
            Arrays.fill(boolBitMap[i],false);
        }

        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[i].length;j++){
                checkNeighbours(A,boolBitMap,countriesCount, i,j);
            }
        }
        return countriesCount.count;
    }

    private void checkColumnBoundry(MapArea stackTop, MapArea mapSection, int[][] A, int row, Stack<MapArea>  stack, Boolean[][] boolBitMap) {
        if(mapSection.col>=0 && mapSection.col<A[row].length){
            mapSection.value = A[mapSection.row][mapSection.col];
            if(stackTop.value==mapSection.value && !boolBitMap[mapSection.row][mapSection.col]){
                stack.push(mapSection);
            }
        }
    }

    private void checkRowBoundry(MapArea stackTop, MapArea mapSection, int[][] A, int row, Stack<MapArea>  stack, Boolean[][] boolBitMap) {
        if(mapSection.row>=0 && mapSection.row<A.length &&
                mapSection.col>=0 && mapSection.col<A[mapSection.row].length){
            mapSection.value = A[mapSection.row][mapSection.col];
            if(stackTop.value==mapSection.value && !boolBitMap[mapSection.row][mapSection.col]){
                stack.push(mapSection);
            }
        }
    }


    private void checkNeighbours(int[][] A, Boolean[][] boolBitMap,
                                 CountriesCount countriesCount, int row, int col){
        if(!boolBitMap[row][col]){
            Stack<MapArea> stack = new Stack<>();
            MapArea currentIndex = new MapArea(row,col);
            currentIndex.value = A[currentIndex.row][currentIndex.col];

            countriesCount.count++;

            stack.push(currentIndex);

            while(!stack.empty()){
                MapArea stackTop = stack.pop();
                if(boolBitMap[stackTop.row][stackTop.col]) {
                    break;
                }
                boolBitMap[stackTop.row][stackTop.col] = true;

                MapArea right = stackTop.right();
                checkColumnBoundry(stackTop, right, A, row, stack, boolBitMap);

                MapArea left = stackTop.left();
                checkColumnBoundry(stackTop, left, A, row, stack, boolBitMap);

                MapArea top = stackTop.top();
                checkRowBoundry(stackTop, top, A, row, stack, boolBitMap);

                MapArea down = stackTop.bottom();
                checkRowBoundry(stackTop, down, A, row, stack, boolBitMap);

            }
        }
    }
}


class MapArea {
    public int row;
    public int col;
    public int value;
    public MapArea(int row, int col){
        this.row = row;
        this.col = col;
    }
    public MapArea right(){
        return new MapArea(this.row,this.col+1);
    }
    public MapArea left(){
        return new MapArea(this.row,this.col-1);
    }

    public MapArea top(){
        return new MapArea(this.row-1,this.col);
    }

    public MapArea bottom(){
        return new MapArea(this.row+1,this.col);
    }
}

class CountriesCount {
    public int count;
}