package mapperscan.Tree;

import java.util.Arrays;
import java.util.Comparator;

public class ThreeNumberClass {
    public static void main(String[] args) {
        ThreeNumberClass threeNumberClass = new ThreeNumberClass();
        Integer[] numsArr = new Integer[]{4,5,7,8,0,3};
        int[] nums = new int[]{-2, 0, 1, 3};
        Arrays.sort(numsArr,new Comparator<Integer>(){
            public int compare(Integer num1,Integer num2){
                return num1-num2;
            }
        });
        threeNumberClass.threeSumSmaller(nums, 2);
    }

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            sum += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return sum;
    }

    private int twoSumSmaller(int[] nums, int startIndex, int target) {
        int sum = 0;
        for (int i = startIndex; i < nums.length - 1; i++) {
            sum += binarySearch(nums, i, target - nums[i]);
            // sum += j - i;
        }
        return sum;
    }

    private int binarySearch(int[] nums, int startIndex, int target) {
        int left = startIndex;
        int right = nums.length ;
        while (left <right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left - startIndex;
    }
}
