package mapperscan.Tree;

import java.util.Arrays;

public class BucketSortClass {
    public static void main(String[] args) {
        BucketSortClass  bucketSortClass= new BucketSortClass();
        int []  nums= new int[]{1,1,1,1,1,5,5,5,5,5};
//        Arrays.sort(nums);
        bucketSortClass.maximumGap(nums);
    }
    public int maximumGap(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int d = (max - min) / n - 1;
        int bucketNums = (max - min) / d + 1;
        int[][] bucketMax = new int[bucketNums][2];
        for (int i = 0; i < bucketNums; i++) {
            bucketMax[i][0] = Integer.MAX_VALUE;
            bucketMax[i][1] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < n; i++) {
            int id = (nums[i] - min) / d;
            bucketMax[id][0] = Math.min(bucketMax[id][0], nums[i]);
            bucketMax[id][1] = Math.max(bucketMax[id][1], nums[i]);
        }
        int result = 0, previous = min;
        for (int i = 0; i < bucketNums; i++) {
            if (bucketMax[i][0] == Integer.MAX_VALUE) {
                continue;
            }
            result = Math.max(result, bucketMax[i][0] - previous);
            previous = bucketMax[i][1];
        }
        return result;
    }
}
