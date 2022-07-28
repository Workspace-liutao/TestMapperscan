package mapperscan.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberAddClass {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = ThreeNumberAddClass.threeSum(nums);
         List list = new ArrayList(new ArrayList());
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> results = new ArrayList();
        results = spiralOrder(matrix);
        System.out.println(results.toString());

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList();
        for (int i = 0; i < n; i++) {
            int target = 0 - nums[i];
            if (i < n - 1 && nums[i] == nums[i + 1]) {
                continue;
            }
            int begin = i + 1;
            int end = n - 1;
            for (int j = begin; j < n; j++) {
                if (j < n - 1 && nums[j] == nums[j + 1]) {
                    continue;
                }
                while (end > j && nums[j] + nums[end] > target) {
                    end--;
                }
                if (j == end) {
                    break;
                }
                if (nums[j] + nums[end] == target) {
                    List<Integer> list = new ArrayList();
                    list.add(i);
                    list.add(j);
                    list.add(end);
                    result.add(list);
                }
            }
        }
        return result;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList();
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int boottom = matrix.length - 1;
        while (left <= right && top <= boottom) {
            //从左到右遍历
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            //从上至下遍历
            for (int i = top + 1; i <= boottom; i++) {
                result.add(matrix[i][right]);
            }
            if (left < right && top < boottom) {
                //从右至左遍历
                for (int i = right - 1; i >= left; i--) {
                    result.add(matrix[boottom][i]);
                }
                //从下至上遍历
                for (int i = boottom - 1; i >= top + 1; i--) {
                    result.add(matrix[i][left]);
                }
            }


            top++;
            left++;
            right--;
            boottom--;
        }
        return result;
    }


}
