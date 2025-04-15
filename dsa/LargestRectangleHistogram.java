package dsa2;

import java.util.Scanner;
import java.util.Stack;

public class LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LargestRectangleHistogram solution = new LargestRectangleHistogram();

        System.out.println("Enter the number of bars:");
        int n = scanner.nextInt();

        int[] heights = new int[n];
        System.out.println("Enter the heights of the bars:");
        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }

        int maxArea = solution.largestRectangleArea(heights);
        System.out.println("Largest Rectangle Area: " + maxArea);

        scanner.close();
    }
}
