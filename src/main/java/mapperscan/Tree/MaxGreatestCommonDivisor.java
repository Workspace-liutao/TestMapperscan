package mapperscan.Tree;

public class MaxGreatestCommonDivisor {

    public int getGreatestCommonDivisor(int a, int b) {
        int max = a > b ? a : b;
        int min = a < b ? a : b;
        int c = max % min;
        if (c == 0) {
            return min;
        }
        return getGreatestCommonDivisor(c, min);
    }

    public static  boolean isDavid2(int n) {
        if (n == 1) {
            return true;
        }
        if (n % 2 != 0) {
            return false;
        }
        return isDavid2(n / 2);
    }

    public static void main(String[] args) {
        System.out.println(MaxGreatestCommonDivisor.isDavid2(8));
    }

}
