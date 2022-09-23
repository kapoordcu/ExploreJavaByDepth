package dp;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class S1ToS2 {

    @Test
    public void testConvert(){
        int min = findMinOps("DIG", "DOG");
        int min2 = findMinOpsDP("DIG", "DOG");
        assertTrue(min==1);
        assertTrue(min2==1);
    }

    @Test
    public void testConvert2(){
        int min = findMinOps("CREATE", "CATS");
        int min2 = findMinOpsDP("CREATE", "CATS");
        assertTrue(min==3);
        assertTrue(min2==3);
    }

    private int findMinOpsDP(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1+1][l2+1];
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= l2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2 ; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        return dp[l1][l2];
    }

    private int findMinOps(String s1, String s2) {
        if(s1.length()==0 || s2.length()==0) {
            return Math.max(s1.length() , s2.length());
        }
        if(s1.charAt(s1.length()-1)==s2.charAt(s2.length()-1)) {
            return findMinOps(s1.substring(0, s1.length()-1), s2.substring(0, s2.length()-1)) ;
        } else {
            return 1 + Math.min(
                    findMinOps(insertElement(s1, s2), s2),
                    Math.min(
                            findMinOps(replaceElement(s1, s2), s2),
                            findMinOps(deleteElement(s1), s2)
                    )
            );
        }
    }

    private String deleteElement(String s1) {
        return s1.substring(0, s1.length()-1);
    }

    private String replaceElement(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        sb.append(s1.substring(0, s1.length()-1));
        sb.append(s2.charAt(s2.length()-1));
        return sb.toString();
    }

    private String insertElement(String s1, String s2) {
        StringBuilder sb = new StringBuilder(s1);
        sb.append(s2.charAt(s2.length()-1));
        return sb.toString();
    }
}
