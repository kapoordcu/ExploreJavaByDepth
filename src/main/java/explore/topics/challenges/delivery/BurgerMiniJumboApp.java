package explore.topics.challenges.delivery;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class BurgerMiniJumboApp {
    public static int[] solution(int cheese, int tomatoes) {
        int jumboBurger = 0;
        int miniBurger = 0;
        for (int i = cheese; i > 0; i--) {
            if(tomatoes == cheese*4) {
                jumboBurger += tomatoes/(cheese*4);
                cheese -= 1;
                tomatoes -= 4;
            } else {
                cheese -= 1;
                tomatoes -= 2;
                miniBurger++;
            }
        }
        List<Integer> maker = Arrays.asList(jumboBurger, miniBurger);
        if(tomatoes==0 && cheese==0) {
            return maker.stream().mapToInt(i-> i).toArray();
        }
        return new int[2];
    }

    @Test
    public void getSpolution1() {
        int[] solution = BurgerMiniJumboApp.solution(7, 16);
        assertTrue(solution[0]==1);
        assertTrue(solution[1]==6);
    }

    @Test
    public void getSpolution2() {
        int[] solution = BurgerMiniJumboApp.solution(17, 4);
        assertTrue(solution[0]==0);
        assertTrue(solution[1]==0);
    }

    @Test
    public void getSpolution3() {
        int[] solution = BurgerMiniJumboApp.solution(17, 4);
        assertTrue(solution[0]==0);
        assertTrue(solution[1]==0);
    }

    @Test
    public void getSpolution4() {
        int[] solution = BurgerMiniJumboApp.solution(1, 2);
        assertTrue(solution[0]==0);
        assertTrue(solution[1]==1);
    }
}
