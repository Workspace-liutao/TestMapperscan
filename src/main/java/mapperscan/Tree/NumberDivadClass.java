package mapperscan.Tree;

import java.util.*;

public class NumberDivadClass {
    public static void main(String[] args) {
        NumberDivadClass numberDivadClass = new NumberDivadClass();
//        numberDivadClass.fractionToDecimal(4, 333);
//        char ch = (char) (0 + 'A');
//        char ch1 = (char) (1 + 'A');
//        char ch2 = (char) (2 + 'A');
        int[] nums = new int[]{2, 3, 3};
        int target = 7;
        numberDivadClass.minSubArrayLen1(target, nums);
        int j = 0;
        for (int i = 1; i <= 4; i++) {
            j = j ^ i;
        }
        List<Integer> list = new ArrayList<>(15);
        for (int i = 0; i <= 15; i++) {
            list.add(i);
        }
        int start = 0;
        int end = 10;
        List<Integer> tempi = new ArrayList<>(15);
        tempi.add(1);
        tempi.size();
        List<Integer> temp = list.subList(start, end);
        Collections.copy(tempi, list);
        System.out.println(tempi.size());
    }

    public String fractionToDecimal(int numerator, int denominator) {
        long a = numerator, b = denominator;
        if (a % b == 0) {
            return String.valueOf(a / b);
        }
        Map<Long, Integer> maps = new HashMap();
        StringBuilder stb = new StringBuilder();
        if (a * b < 0) {
            a = Math.abs(a);
            b = Math.abs(b);
            stb.append('-');
        }
        stb.append(a / b).append('.');
        a = a % b;
        while (a != 0) {
            maps.put(a, stb.length());
            a = a * 10;
            stb.append(a / b);
            a = a % b;
            if (maps.containsKey(a)) {
                int u = maps.get(a);
                return String.format("%s(%s)", stb.substring(0, u), stb.substring(u));
            }
        }
        return stb.toString();
    }

    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public int minSubArrayLen1(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
