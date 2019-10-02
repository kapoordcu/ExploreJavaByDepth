package explore.topics.hackerrank;

public class TrianglePrint2019 {
    public static void main(String[] args) {
        int depth = 4;
        for (int i = 0; i < depth; i++) {
            System.out.print(printChar(' ', depth-i+1) );
            System.out.print(printChar('*', 2*i+1) );
            System.out.println();
        }
    }

    public static String printChar(Character c, int times) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            builder.append(c);
        }
        return builder.toString();
    }
}
