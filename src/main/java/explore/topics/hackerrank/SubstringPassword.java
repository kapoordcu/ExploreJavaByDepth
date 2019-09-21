package explore.topics.hackerrank;

import java.util.ArrayList;

public class SubstringPassword {
    // Function to print all substring
    public static ArrayList<String> returnSubString(String str, int n) {
        ArrayList<String> SubStrings = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                SubStrings.add(str.substring(i, j));
            }
        }
        return SubStrings;
    }

    public int solution(String str) {
        int maxLength = -1;
        ArrayList<String> SubStrings = new ArrayList<String>();
        SubStrings = returnSubString(str, str.length());
        for (int i = 0; i < SubStrings.size(); i++) {
            String value = SubStrings.get(i);
            if (value.matches(".*[A-Z].*") && value.matches("^([^0-9]*)$")) {
                if(value.length() > maxLength) {
                    maxLength = value.length();
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        SubstringPassword substringPassword = new SubstringPassword();
        int count;
        String str = "a0Ba";
        count = substringPassword.solution(str);
        System.out.print(count);
    }
}