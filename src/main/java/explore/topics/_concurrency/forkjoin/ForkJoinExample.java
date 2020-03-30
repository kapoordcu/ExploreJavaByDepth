package explore.topics._concurrency.forkjoin;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class ForkJoinExample extends RecursiveTask<BigInteger> {
    private int start = 1;
    private int n;
    private int THRESHOLD = 20;

    public ForkJoinExample(int start, int n) {
        this.start = start;
        this.n = n;
    }

    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        System.out.println(pool.invoke(new ForkJoinExample(1, 10000)));
    }

    //join the result of each subtasks
    @Override
    protected BigInteger compute() {
        if((n-start)>=THRESHOLD) {
            return ForkJoinTask.invokeAll(createSubtasks())
                    .stream()
                    .map(ForkJoinTask::join)
                    .reduce(BigInteger.ONE, BigInteger::multiply);
        } else {
            return calculateTasksWithoutForking(n, start);
        }
    }

    private BigInteger calculateTasksWithoutForking(int n, int start) {
        return IntStream.rangeClosed(start, n)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);
    }

    private Collection<ForkJoinExample> createSubtasks() {
        List<ForkJoinExample> subtaskList = new ArrayList<>();
        int mid = (start+n)/2;
        subtaskList.add(new ForkJoinExample(start, mid));
        subtaskList.add(new ForkJoinExample(mid+1, n));
        return subtaskList;
    }
}
