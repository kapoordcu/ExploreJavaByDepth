package explore.topics._ds.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class JobSequencingProblem {
    public static void main(String[] args) {
        JobSequencingProblem js = new JobSequencingProblem();
        List<Job> jobs = Arrays.asList(new Job("j1", 2, 100),
                new Job("j2", 1, 19),
                new Job("j3", 2, 27),
                new Job("j4", 1, 25),
                new Job("j5", 3, 15)
        );
        System.out.println(js.findMaxProfit(jobs, 5));
    }

    private int findMaxProfit(List<Job> jobs, int n) {
        int profit = 0;
        List<Job> sortedByProfit = jobs.stream()
                .sorted(Comparator.comparing(Job::getProfit).reversed()
                        .thenComparing(Comparator.comparing(Job::getDeadline).reversed()))
                .collect(Collectors.toList());
        // Creating TreeSet Object
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            ts.add(i);
        }
        for (int i = 0; i < sortedByProfit.size(); i++) {
            Job selectedJob = sortedByProfit.get(i);
            Integer floor = ts.floor(selectedJob.deadline-1);
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