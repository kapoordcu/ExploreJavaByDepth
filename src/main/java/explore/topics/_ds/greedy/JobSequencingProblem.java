package explore.topics._ds.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class JobSequencingProblem {
    public static void main(String[] args) {
        JobSequencingProblem js = new JobSequencingProblem();
        List<Job> jobs = Arrays.asList(new Job("a", 2, 100),
                new Job("b", 1, 19),
                new Job("c", 2, 27),
                new Job("d", 1, 25),
                new Job("e", 3, 15)
        );
        System.out.println(js.findMaxProfitNaive(jobs));
        System.out.println(js.findMaxProfitUsingTreeSet(jobs));
    }

//    1. sort job according to decresing order of deadline =  O(nlogn)
//
//    2.for each job find slot in array of size n = O(n^2)
//
//    total time  = O(nlogn) + O(n^2) =O(n^2)

    private int findMaxProfitNaive(List<Job> jobs) {

        List<Job> sortedByProfit = jobs.stream()
                .sorted(Comparator.comparing(Job::getProfit).reversed()
                        .thenComparing(Job::getDeadline))
                .collect(Collectors.toList());
        int maxDeadLine = jobs.stream()
                .mapToInt(Job::getDeadline)
                .max().getAsInt();
        int[] slots = new int[maxDeadLine];

        for (int i = 0; i < maxDeadLine; i++) {
            slots[i] = i + 1;
        }
        int profit = 0;
        for (int i = 0; i < sortedByProfit.size(); i++) {
            Job currentJob = sortedByProfit.get(i);
            for (int j = 0; j < maxDeadLine; j++) {
                if(currentJob.getDeadline()>=slots[j] && slots[j]!=-1) {
                    slots[j] = -1;
                    profit += currentJob.getProfit();
                    break;
                }
            }
        }
        return profit;
    }


    //Time Complexity: O(N*log(N))
    //Auxiliary Space: O(N)
    private int findMaxProfitUsingTreeSet(List<Job> jobs) {
        int profit = 0;
        List<Job> sortedByProfit = jobs.stream()
                        .sorted(Comparator.comparing(Job::getProfit).reversed()
                        .thenComparing(Job::getDeadline))
                .collect(Collectors.toList());
        int maxDeadLine = jobs.stream()
                            .mapToInt(Job::getDeadline)
                            .max().getAsInt();
        // Creating TreeSet Object
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 1; i <= maxDeadLine; i++) {
            ts.add(i);
        }

        for (int i = 0; i < sortedByProfit.size(); i++) {
            Job selectedJob = sortedByProfit.get(i);
            Integer floor = ts.floor(selectedJob.deadline);
            if(floor!=null) {
                System.out.println("Job " + selectedJob.getId() + " is selected with profit " + selectedJob.profit);
                profit += selectedJob.getProfit();
                ts.remove(floor);
            }
        }
        return profit;
    }

    private boolean findPossibleSlot(int deadline, boolean[] assigned) {
        for (int i = assigned.length; i >=0 ; i--) {
            if(!assigned[i-1]) {
                return true;
            }
        }
        return false;
    }

    public static class Job {
        String id;
        int deadline;
        int profit;

        public Job(String id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }

        public int getProfit() {
            return profit;
        }

        public String getId() {
            return id;
        }

        public int getDeadline() {
            return deadline;
        }
    }
}


/**
 * Given an array of jobs where every job has a deadline and associated profit (if the job is finished before the deadline). It is also given that every job takes a single unit of time, so the minimum possible deadline for any job is 1. How to maximize total profit if only one job can be scheduled at a time.
 *
 * Examples:
 *
 * Input : Four Jobs with following deadlines and profits
 *   JobID    Deadline      Profit
 *     a        4            20
 *     b        1            10
 *     c        1            40
 *     d        1            30
 * Output : Following is maximum profit sequence of jobs
 *          c, a
 *
 *
 *
 * Input : Five Jobs with following deadlines and profits
 *    JobID     Deadline     Profit
 *      a         2           100
 *      b         1           19
 *      c         2           27
 *      d         1           25
 *      e         3           15
 * Output : Following is maximum profit sequence of jobs
 *          c, a, e
 */