package explore.topics.testlive;

public class TrianglePrint2019 {
    public static void main(String[] args) {
        int depth = 4;

        for (int i = 1; i <= depth; i++) {
            System.out.println(printLTraingle('*', i));
        }
        for (int i = 1; i <= depth; i++) {
            printRevertLTraingle('*', i, depth);
        }
    }

    public static String printLTraingle(char ch, int depth) {
//        *
//        **
//        ***
//        ****
        return printCharNTimes(ch, depth);
    }

    public static void printRevertLTraingle(char ch, int i, int depth) {
//              *
//             **
//            ***
//           ****
        StringBuilder builder = new StringBuilder();
        builder.append(printCharNTimes(' ', (depth-i)));
        builder.append(printCharNTimes(ch, i));
        System.out.println(builder.toString());
        builder.setLength(0);
    }

    public static String printCharNTimes(char c, int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(c);
        }
        return builder.toString();
    }
}
