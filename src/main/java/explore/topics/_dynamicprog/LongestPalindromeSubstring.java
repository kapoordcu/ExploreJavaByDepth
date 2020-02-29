package explore.topics._dynamicprog;

public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        LongestPalindromeSubstring substring = new LongestPalindromeSubstring();
        String str = "abaabc";
        String str2 = "jingolnkiddikng";

        substring.findPalidromeSubstring(str);
        System.out.println();
        substring.findPalidromeSubstring(str2);
    }

    private void findPalidromeSubstring(String str) {
        int len = str.length();
        boolean[][] tempDP = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            tempDP[i][i] = true;
        }

        int maxLength = 1;
        int start = 0;
        for (int i = 0; i < len - 1; i++) {
            if(str.charAt(i)==str.charAt(i+1)) {
                tempDP[i][i+1] = true;
                maxLength = 2;
                start = i;
            }
        }

        for (int k = 3; k < len; ++k) {
            for (int i = 0; i < len - k + 1; ++i) {
                int j = i + k - 1;
                if (tempDP[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
                    tempDP[i][j] = true;
                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        System.out.print("Longest palindrome substring is of length " +
                maxLength + " and is " + str.substring(start, start + maxLength));
    }
}
