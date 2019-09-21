package explore.topics.hackerrank;

public class StonesJewels {
    public static void main(String[] args) {
        StonesJewels stonesJewels = new StonesJewels();
        System.out.println(stonesJewels.numJewelsInStones("zZ", "ZZ"));
    }

    public int numJewelsInStones(String jewelS, String stones) {
        int jewelsCount = 0;
        for (int i = 0; i < jewelS.length() ; i++) {
            char jewel = jewelS.charAt(i);
            int count = (int) stones.chars().filter(c -> c == jewel).count();
            jewelsCount += count;
        }
        return jewelsCount;
    }
}
