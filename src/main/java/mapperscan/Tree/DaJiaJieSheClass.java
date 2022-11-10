package mapperscan.Tree;

import java.util.Arrays;

public class DaJiaJieSheClass {
    public static void main(String[] args) {
        DaJiaJieSheClass daJiaJieSheClass = new DaJiaJieSheClass();
        int[] nums = new int[]{2, 3, 2};
        int result = daJiaJieSheClass.rob(nums);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        return Math.max(dfs(nums, 0, n - 1), dfs(nums, 1, n));
    }

    public int dfs(int[] nums, int index, int len) {
        //如果从0开始，不能选择最后一件房子
        if (index >= len) {
            return 0;
        }
        int i1 = nums[index] + dfs(nums, index + 1, len);
        int i2 = dfs(nums, index + 1, len);
        return Math.max(i1, i2);
    }
}
