package explore.topics.optional;

public class MergeStrings {
    public static void main(String[] args) {
        System.out.println(megreStrings("a", "0"));
    }

    private static String megreStrings(String a, String b) {
        String shortString = a.length() > b.length() ? b : a;
        String longString = a.length() > b.length() ? a : b;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortString.length(); i++) {
            sb.append(shortString.substring(i, i+1));
            sb.append(longString.substring(i, i+1));
        }
        int remainingStringLength = longString.length() - shortString.length();
        if(remainingStringLength > 0) {
            sb.append(longString.substring(longString.length() - remainingStringLength, longString.length()));
        }

        return sb.toString();
    }
}
