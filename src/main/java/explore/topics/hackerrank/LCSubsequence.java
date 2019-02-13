package explore.topics.hackerrank;

import java.util.Arrays;

public class LCSubsequence {
    public static void main(String[] args) {
        String a1 = "ABCDEFGHIJ";
        String a2 = "GAURABABC";
        String a3 = "YZXRGABJKOCTHD";

        System.out.println("LCString for input Sequences '" +  a1 + "' and '" + a2 + "' is of length " + longestCommonString(a1, a2));
        System.out.println("LCSequence for input Sequences '" +  a1 + "' and '" + a2 + "' is of length " + longestCommonSubsequence(a1, a2));
        System.out.println("LCSequence for input Sequences '" +  a1 + "' and '" + a3 + "' is of length " + longestCommonSubsequence(a1, a3));
    }

    private static int longestCommonString(String first, String second) {
        int xString = first.length();
        int yString = second.length();
        
        int[][] commonScore = new int[xString+1][yString+1];
        int maxLength = 0;

        for (int i = 1; i <= xString; i++) {
            for (int j = 1; j <= yString; j++) {
                if(first.charAt(i-1) == second.charAt(j-1)) {
                    commonScore[i][j] += commonScore[i-1][j-1] + 1;
                    maxLength = maxLength > commonScore[i][j] ? maxLength : commonScore[i][j];
                }
            }
        }
        Arrays.stream(commonScore).forEach( x -> x.toString());
        return maxLength;
    }

    private static int longestCommonSubsequence(String first, String second) {
        int xString = first.length();
        int yString = second.length();

        int[][] commonScore = new int[xString+1][yString+1];
        int maxLength = 0;

        for (int i = 1; i <= xString; i++) {
            for (int j = 1; j <= yString; j++) {
                if(first.charAt(i-1) == second.charAt(j-1)) {
                    commonScore[i][j] += commonScore[i-1][j-1] + 1;
                    maxLength = maxLength > commonScore[i][j] ? maxLength : commonScore[i][j];
                } else {
                    commonScore[i][j] = Math.max(commonScore[i-1][j], commonScore[i][j-1]);
                }
            }
        }
        return commonScore[xString][yString];
    }
}
