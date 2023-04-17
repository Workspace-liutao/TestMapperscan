package mapperscan.Tree;

import java.util.Arrays;

public class NumberDPClass {
    public static int dp[][];
    public static int len;
    public  static char[] nums;

    public static void main(String[] args) {
        NumberDPClass numberDPClass = new NumberDPClass();
        int n=13;
        nums=String.valueOf(n).toCharArray();
        len=nums.length;
        dp=new int[len][len];
        for(int []  temp :dp){
            Arrays.fill(temp,-1);
        }
        int temp =numberDPClass.dfs(0,0,true,true);
    }


    public int dfs(int index, int pre, boolean isLimited, boolean leadZero) {
        if (index >= len) {
            return leadZero ? 0 : pre;
        }
        if (!isLimited && !leadZero && dp[index][pre] != -1) {
            return dp[index][pre];
        }
        int up = isLimited ? nums[index] - '0' : 9;
        int res = 0;
        for (int i = 0; i <= up; i++) {
            res += dfs(index + 1, leadZero && i == 0 ? pre : i == 1 ? pre + 1 : pre, isLimited && i == up,
                    leadZero && i == 0);
        }
        if (!isLimited && !leadZero) {
            dp[index][pre] = res;
        }
        return res;
    }


}
