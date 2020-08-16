package explore.topics.testlive.toptal;

import org.junit.Test;

public class Qyestion1 {

    public int solution(String S, int K) {
        int maxLength = 0;
        // write your code in Java SE 8
        for (int i = 0; i < S.length()-K; i++) {
            String substring = S.substring(0, i) + S.substring(i + K);
            String leng = calculateFrequencyByChar(substring);
            System.out.println(substring);
            if(leng.length() > maxLength) {
                maxLength = leng.length();
            }
        }
        return maxLength;
    }

    public String calculateFrequencyByChar(String subseque) {
        int length = subseque.length();
        StringBuilder builder = new StringBuilder();
        int count=1;

        for(int i=0; i<length; i++){
            if(i==length-1){
                builder.append(count +"" + subseque.charAt(i));
                break;
            }
            if(subseque.charAt(i)==subseque.charAt(i+1)){
                count++;
            } else {
                if(count!=1) {
                    builder.append(count+"" + subseque.charAt(i));
                } else {
                    builder.append("" + subseque.charAt(i));
                }
                count=1;
            }
        }
        return builder.toString();
    }

    @Test
    public void getCompressedForm() {
        Qyestion1 q1= new Qyestion1();
        int abbbccddccc = q1.solution("ABBBCCDDCCC", 5);
        q1.calculateFrequencyByChar("ABBBCCDDCCC");

    }
}
