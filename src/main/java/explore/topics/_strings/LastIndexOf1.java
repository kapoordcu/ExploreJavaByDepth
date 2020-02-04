package explore.topics._strings;

public class LastIndexOf1 {
    public static void main(String[] args) {
        String s = "0001000010010101000";

        System.out.println(lastIndexOf(s));
    }

    private static int lastIndexOf(String s) {
        for (int i = s.length(); i >0 ; i--) {
            if(s.charAt(i - 1)=='1') {
                return i;
            }
        }
        return -1;
    }
}
