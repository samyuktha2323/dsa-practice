package dsa;
public class MissingElementFinder {
    public static int findMissing(int[] arr) {
        int n = arr.length + 1;
        int xorExpected = computeXOR(n);
        int xorActual = 0;
        for (int num : arr) {
            xorActual ^= num;
        }
        return xorExpected ^ xorActual;
    }
    
    private static int computeXOR(int n) {
        switch (n % 4) {
            case 0:
                return n;
            case 1:
                return 1;
            case 2:
                return n + 1;
            case 3:
                return 0;
            default:
                return 0;
        }
    }
}