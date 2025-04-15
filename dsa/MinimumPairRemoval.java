package dsa2;

import java.util.Scanner;

public class MinimumPairRemoval {

    public static int minimumOperations(int[] nums) {
        int operations = 0;
        while (!isNonDecreasing(nums)) {
            int minSum = Integer.MAX_VALUE;
            int index = -1;

            // Find the leftmost minimum sum pair
            for (int i = 0; i < nums.length - 1; i++) {
                int sum = nums[i] + nums[i + 1];
                if (sum < minSum) {
                    minSum = sum;
                    index = i;
                }
            }

            // Merge the pair
            int[] newNums = new int[nums.length - 1];
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i == index) {
                    newNums[j++] = nums[i] + nums[i + 1];
                    i++; // skip next
                } else {
                    newNums[j++] = nums[i];
                }
            }
            nums = newNums;
            operations++;
        }
        return operations;
    }

    private static boolean isNonDecreasing(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int result = minimumOperations(nums);
        System.out.println("Minimum operations to make the array non-decreasing: " + result);

        scanner.close();
    }
}
