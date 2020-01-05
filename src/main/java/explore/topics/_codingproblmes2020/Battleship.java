package explore.topics._codingproblmes2020;// you can also use imports, for example:

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class Battleship {
    private static String COMME_DELIMITER = ",";
    private static String SPACE_DELIMITER = " ";
    private static String COLUN_DELIMITER = ":";

    public String solution(int N, String S, String T) {
        AtomicInteger hits = new AtomicInteger();
        AtomicInteger sunk = new AtomicInteger();
        List<String> pairs = Arrays.asList(S.split(COMME_DELIMITER));
        List<String> xxx = Arrays.asList(T.split(SPACE_DELIMITER));
        for (String pair: pairs) {
            calculateBattle(pair, xxx, hits, sunk);
        }
        return sunk + "," + hits;
    }

    private void calculateBattle(String pair, List<String> xxx, AtomicInteger hits, AtomicInteger sunk) {
        List<String> shipAreaList = findAllBoxes(pair);
        List<String> common = new ArrayList<>(shipAreaList);
        common.removeAll(xxx);
        if(common.size()==0) {
            sunk.incrementAndGet();
        } else {
            if(common.size()<shipAreaList.size()) {
                hits.incrementAndGet();
            }
        }

    }

    private List<String> findAllBoxes(String pair) {
        List<String> shipArea = new ArrayList<>();
        String[] bit = pair.split(SPACE_DELIMITER);
        String[] low = extract(bit[0]).split(COLUN_DELIMITER);
        String[] high = extract(bit[1]).split(COLUN_DELIMITER);

        for (int i = Integer.parseInt(low[0]); i <= Integer.parseInt(high[0]); i++) {
            for(char y = low[1].charAt(0); y <= high[1].charAt(0); y++){
                shipArea.add(i + "" + y);
            }
        }
        return shipArea;
    }

    public String extract(String str) {
        String copy = str;
        String intPart = str.replaceAll("([a-zA-Z])", "");
        String charPart = copy.replaceAll("\\d", "");
        return intPart + COLUN_DELIMITER + charPart;
    }
}