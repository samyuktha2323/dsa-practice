package dsa2;

import java.util.Scanner;

public class FinalPricesWithDiscount {

    public static int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int discount = 0;
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    discount = prices[j];
                    break;
                }
            }
            result[i] = prices[i] - discount;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        int[] prices = new int[n];
        System.out.println("Enter the prices of the items:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        int[] discountedPrices = finalPrices(prices);
        System.out.print("Final prices after discount: ");
        for (int price : discountedPrices) {
            System.out.print(price + " ");
        }

        scanner.close();
    }
}
