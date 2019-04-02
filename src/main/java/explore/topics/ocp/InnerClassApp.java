package explore.topics.ocp;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InnerClassApp {
    public static void main(String[] args) {
        iDetailed iDetailed = (n1, n2) -> { return n1>n2; };
    }

//    enum Color {
//        BLACK(0), WHITE(1);
//        private final int code;
//
//        Color(int code) {
//            this.code = code;
//        }
//
//
//        @Override
//        public String toString() {
//            return String.valueOf(code);
//        }
//    }
}


interface iDetailed {
    boolean compareInts(int n1, int n2);


}

