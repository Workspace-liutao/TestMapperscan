package mapperscan.Tree;

public class WindowsBuildingClass {
    public static void main(String[] args) {
     String  str = "ADOBECODEBANC", t = "ABC";
    String  strs= minWindow(str,t);
    System.out.println(strs);
    }
    public static  String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        char[] sch = s.toCharArray();
        char[] tch = t.toCharArray();
        int[] sInt = new int[128];
        int[] tInt = new int[128];
        for (char ch : tch) {
            tInt[ch]++;
        }
        int begin = 0;
        int max = sLen + 1;
        int distance = 0;
        int left = 0;
        int right = 0;
        while (right < sLen) {
            if (tInt[s.charAt(right)] == 0) {
                right++;
                continue;
            }
            if (sInt[s.charAt(right)] < tInt[s.charAt(right)]) {
                distance++;
            }
            sInt[s.charAt(right)]++;
            right++;
            while (distance == tLen) {
                if (right - left < max) {
                    begin = left;
                    max = right - left;
                }
                if (tInt[s.charAt(left)] == 0) {
                    left++;
                    continue;
                }
                if (sInt[s.charAt(left)] == tInt[s.charAt(left)]) {
                    distance--;
                }
                sInt[s.charAt(left)]--;
                left++;

            }
        }
        if (max == sLen + 1) {
            return "";
        }
        return s.substring(begin, begin + max);
    }
}
