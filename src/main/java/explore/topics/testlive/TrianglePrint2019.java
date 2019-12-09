package explore.topics.testlive;

public class TrianglePrint2019 {
    public static void main(String[] args) {
        int depth = 4;

//        for (int i = 1; i <= depth; i++) {
//            System.out.println(printLTraingle('*', i));
//        }
//        for (int i = 1; i <= depth; i++) {
//            printRevertLTraingle('*', i, depth);
//        }

//        printChristmasTree('*', depth);
        int a[] = { 0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 18, 20, 21, 23 };
        findMissingNumbers(a);
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

//              *
//             ***
//            *****
//           *******
    public static void printChristmasTree(char ch, int depth) {
        for (int i = 0; i < depth; i++) {
            String space = printCharNTimes(' ', (depth - i));
            String pattern = printCharNTimes(ch, (2*i+1));
            System.out.println(space+pattern);
        }
    }

    public static String printCharNTimes(char c, int n) {
        for (int i = 0; i < n; i=i*2) {

        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(c);
        }
        return builder.toString();
    }

    private static void findMissingNumbers(int values[], int position, int count) {
        boolean foundMissingNumber = false;
        if (position == values.length - 1)
            return;

        for (; position < values[values.length - 1]; position++) {

            if ((values[position] - count) != position) {
                System.out.println("Missing Number: " + (position + count));
                foundMissingNumber = true;
                count++;
                break;
            }
        }

        if (foundMissingNumber) {
            findMissingNumbers(values, position, count);
        }
    }

    public static void findMissingNumbers(int values[]) {
        findMissingNumbers(values, 0, 0);
    }



}
