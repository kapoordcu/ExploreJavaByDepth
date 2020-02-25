package explore.topics._geometry;

import java.util.Stack;

public class MaxRectangleAreaFromHistogram {
    public static void main(String[] args) {
        int[] hist = {1,2,1,3,3,4,1};
        int[] histStack = {2, 1,2, 3, 1};
        System.out.println(MaxRectangleAreaFromHistogram.calculateMaxArea(hist));
        System.out.println(MaxRectangleAreaFromHistogram.calculateMaxArea(histStack));

        System.out.println(MaxRectangleAreaFromHistogram.calculateMaxAreaStack(hist));
        System.out.println(MaxRectangleAreaFromHistogram.calculateMaxAreaStack(histStack));

    }

    /**
     * Time Complexity: Since every bar is pushed and popped only once, the time complexity of this method is O(n).
     */
    private static int calculateMaxAreaStack(int[] input) {
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        int maxArea = 0;
        int i;
        for (i = 0; i < input.length;) {
            if(stack.isEmpty() || input[i] >= input[stack.peek()]) {
                stack.push(i++);
            }  else {
                int top = stack.pop();
                if(stack.isEmpty()) {
                    area = input[top]*i;
                } else {
                    area = input[top]*(i-stack.peek()-1);
                }
                maxArea = Math.max(maxArea, area);
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            if(stack.isEmpty()) {
                area = input[top]*i;
            } else {
                area = input[top]*(i-stack.peek()-1);
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    private static int calculateMaxArea(int[] hist) {
        int max = 0;
        for (int i = 0; i < hist.length; i++) {
            int h = hist[i];
            max = Math.max(h, max);
            for (int j = i-1; j >=0 ; j--) {
                h = Math.min(hist[j], h);
                int width = i - j + 1;
                max = Math.max(width*h, max);
            }
        }
        return max;
    }
}
