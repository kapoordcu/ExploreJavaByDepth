package explore.topics.hackerrank;

public class Occurance {
    public static void main(String[] args) {
        String pattern = "aaBBcccDDDeeaaaeFGHH";
        System.out.println(printPattern(pattern));
    }

    private static String printPattern(String pattern) {
        StringBuilder builder = new StringBuilder();
        Character prev = pattern.charAt(0);
        Integer count = 0;
        for(Character c: pattern.toCharArray()) {
            if(c.equals(prev)) {
                ++count;
            } else {
                builder.append(prev + "" + count);
                count = 1;
            }
            prev = c;
        }
        return builder.toString();
    }
}

