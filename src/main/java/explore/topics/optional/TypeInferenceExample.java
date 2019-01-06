package explore.topics.optional;

public class TypeInferenceExample {
    public static void main(String[] args) {
        printLambda(s -> s.length());
    }

    public static void printLambda(StringLengthLambda lambda) {
        System.out.println(lambda.strLen("Hello String"));
    }
    interface StringLengthLambda {
        int strLen(String source);
    }
}
