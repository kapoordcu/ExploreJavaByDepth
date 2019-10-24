package explore.topics.testlive.amazon;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.*;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<ArrayList<Integer>> links = new ArrayList<>();

        ArrayList<Integer> a1 = new ArrayList<Integer>();
        a1.add(0);
        a1.add(1);
        links.add(a1);

//        List<Integer> a3 = Arrays.asList(1,3);
//        List<Integer> a4 = Arrays.asList(2,3);
//        List<Integer> a5 = Arrays.asList(2,5);
//        List<Integer> a6 = Arrays.asList(5,6);
//        List<Integer> a7 = Arrays.asList(3,4);

        ArrayList<Integer> a2 = new ArrayList<Integer>();
        a2.add(0);
        a2.add(2);
        links.add(a2);

        ArrayList<Integer> a3 = new ArrayList<Integer>();
        a3.add(1);
        a3.add(3);
        links.add(a3);

        ArrayList<Integer> a4 = new ArrayList<Integer>();
        a4.add(2);
        a4.add(3);
        links.add(a4);

        ArrayList<Integer> a5 = new ArrayList<Integer>();
        a5.add(2);
        a5.add(5);
        links.add(a5);

        ArrayList<Integer> a6 = new ArrayList<Integer>();
        a6.add(5);
        a6.add(6);
        links.add(a6);

        ArrayList<Integer> a7 = new ArrayList<Integer>();
        a7.add(3);
        a7.add(4);
        links.add(a7);




        solution.criticalRouters(7, 7, links);
    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<Integer> criticalRouters(int numRouters, int numLinks,
                                  ArrayList<ArrayList<Integer>> links) {
        // WRITE YOUR CODE HERE
        List<Integer> mustPresent = new ArrayList<Integer>();
        for (int routerNumber = 0; routerNumber < numRouters; routerNumber++) {
            ArrayList<ArrayList<Integer>> newLinkNodes = removeRouter(routerNumber, links);
            if(isMandatoryInNetwork(newLinkNodes, numRouters))  {
                mustPresent.add(routerNumber);
            }

        }
        return mustPresent;

    }

    private boolean isMandatoryInNetwork(ArrayList<ArrayList<Integer>> newLinkNodes, int numRouters) {
        Set<Integer> uniqueRouter = new HashSet<>();
        newLinkNodes.stream().forEach(list -> list.stream().forEach(element -> uniqueRouter.add(element)));
        return uniqueRouter.size()==(numRouters-1) ? true : false;
    }

    private ArrayList<ArrayList<Integer>> removeRouter(int index, ArrayList<ArrayList<Integer>> links) {
        ArrayList<ArrayList<Integer>> linksAfterOneDeletion = new ArrayList<>();
        for (ArrayList<Integer> link : links) {
            long count = link.stream().filter(element -> element == index).count();
            if(count==0) {
                linksAfterOneDeletion.add(link);
            }
        }

        return linksAfterOneDeletion;
    }
    // METHOD SIGNATURE ENDS
}