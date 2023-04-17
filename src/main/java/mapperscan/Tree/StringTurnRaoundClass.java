package mapperscan.Tree;

public class StringTurnRaoundClass {
    public static void main(String[] args) {
        StringTurnRaoundClass stringTurnRaoundClass = new StringTurnRaoundClass();
        char[] s = new char[]{'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        char[] result = stringTurnRaoundClass.reverseWords(s);
        System.out.println(result.toString());
    }

    public char[] reverseWords(char[] s) {
        int n = s.length;
        while (s[n - 1] == ' ') {
            n--;
        }
        int k = 0;
        int l = 0;
        char[] result = new char[n];
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] == ' ' || i == 0) {
                int j = i + 1;
                while (j <= i + l) {
                    result[k++] = s[j];
                    j++;
                }
                if (k != n - 1) {
                    result[k++] = ' ';
                    l = 0;
                }
            } else {
                l++;
            }
        }
        return result;
    }
}
