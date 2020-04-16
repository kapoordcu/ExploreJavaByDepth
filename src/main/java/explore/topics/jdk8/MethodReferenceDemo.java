package explore.topics.jdk8;

import java.util.Arrays;
import java.util.List;

interface Parser {
    String parse(String str);
}

class StringParser {
    public static String convert(String s) {
        if(s.length()<=3) {
            return s.toUpperCase();
        }
        return s.toLowerCase();
    }
}

class MyPrinter {
    public void print(String str, Parser parser) {
        str = parser.parse(str);
        System.out.println(str);
    }
}

public class MethodReferenceDemo {
    public static void main(String[] args) {
//        List<String> names =
//                Arrays.asList("AnitHarami", "BihariPrabhat", "ChutiaRaka", "DickKislay");
//
//        names.forEach(s-> System.out.println(s));
//        // Call by method (Pass function to a function)
//        names.forEach(System.out::println);

        MyPrinter printer = new MyPrinter();
        String str = "My Name";
        printer.print(str, StringParser::convert); // May be I want to print out somewhere else
    }
}
