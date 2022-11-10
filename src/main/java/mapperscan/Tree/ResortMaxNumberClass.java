package mapperscan.Tree;

import java.util.Arrays;

public class ResortMaxNumberClass {
    public static void main(String[] args) {
        ResortMaxNumberClass  resortMaxNumberClass  = new ResortMaxNumberClass();
        int []  nums = new int[]{4,300};
        resortMaxNumberClass.largestNumber(nums);
    }

        public String largestNumber(int[] nums) {
            int n = nums.length;
            String[] ss = new String[n];
            for (int i = 0; i < n; i++) ss[i] = "" + nums[i];
            Arrays.sort(ss, (a, b) -> {
                String sa = a + b, sb = b + a ;
                return sb.compareTo(sa);
            });

            StringBuilder sb = new StringBuilder();
            for (String s : ss) sb.append(s);
            int len = sb.length();
            int k = 0;
            while (k < len - 1 && sb.charAt(k) == '0') k++;
            return sb.substring(k);
        }
}
