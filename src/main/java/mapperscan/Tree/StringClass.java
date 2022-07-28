package mapperscan.Tree;

public class StringClass {
    public static void main(String[] args) {
        String str1 = "aabaaabaaac";
        String str2 = "aabaaac";
        System.out.println(returnResult(str1, str2));
    }

    public static int returnResult(String str1, String str2) {
        int[] next = getNext(str2);
        int j = 0;
        for (int i = 0; i < str1.length(); i++) {
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i + 1 - j;
            }
        }
        return -1;
    }

    public static int[] getNext(String moudle) {
        int[] next = new int[moudle.length()];
        int j = 0;
        for (int i = 1; i < moudle.length(); i++) {
            while (j < i && j > 0 && moudle.charAt(i) != moudle.charAt(j)) {
                j = next[j - 1];
            }
            if (moudle.charAt(i) == moudle.charAt(j)) {
                next[i] = j;
                j++;
            }

        }
        return next;
    }
}
