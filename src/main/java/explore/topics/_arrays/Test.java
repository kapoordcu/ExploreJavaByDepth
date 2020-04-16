//package explore.topics._arrays;
//
//
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Test {
//    int[] addOne(int[] digits) {
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < digits.length; i++) {
//            builder.append(digits[i] + "");
//        }
//        Integer addedWithOne = Integer.valueOf(builder.toString()) + 1;
//        builder.setLength(0);
//
//        while(addedWithOne!=0) {
//            int remainder = addedWithOne%10;
//            addedWithOne /= 10;
//            builder.append(remainder);
//        }
//        int[] result = new int[builder.length()];
//        String resultString = builder.reverse().toString();
//        for (int i = 0; i < resultString.length(); i++) {
//            result[i] = Integer.parseInt(resultString.substring(i, i+1));
//        }
//        return result;
//    }
//
//    String[] splitNumber(String number, int k) {
//        List<String> pairs = new ArrayList<>();
//        for (int i = 0; i < number.length();) {
//            String pair = number.substring(i, Math.min(i+k, number.length()));
//            if(!pair.contains("0")) {
//                pairs.add(pair);
//                i = i + k;
//            } else {
//                int leadingZeros = findLeadingZerosCount(pair, k);
//                i += leadingZeros;
//            }
//        }
//        String[] result = new String[pairs.size()];
//        for (int i = 0; i < pairs.size(); i++) {
//            result[i] = pairs.get(i);
//        }
//        new Runnable() {
//
//            @Override
//            public void run() {
//
//            }
//        }
//        return result;
//    }
//
//    private int findLeadingZerosCount(String pair, int k) {
//        int zeroCount = 0;
//        for (int i = 0; i < k; i++) {
//            if(pair.charAt(i)=='0') {
//                zeroCount++;
//            } else {
//                return zeroCount;
//            }
//        }
//        return zeroCount;
//    }
//
//
//    public static void main(String[] args) {
//        //byte[] content = Files.readAllBytes(Paths.get("shidjid"));
//
//    }
//
//
//}
