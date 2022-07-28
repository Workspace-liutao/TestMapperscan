package mapperscan.Tree;

import java.util.Arrays;
import java.util.Stack;

public class TurnArrayClass {
    public static void main(String[] args) {
//        int[][] nums = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < i; j++) {
//                int temp = nums[i][j];
//                nums[i][j] = nums[j][i];
//                nums[j][i] = temp;
//            }
//        }
//        int n = nums.length;
//        for (int j = 0; j < n / 2; j++) {
//            for (int i = 0; i < n; i++) {
//                int temp = nums[i][j];
//                nums[i][j] = nums[i][n - j - 1];
//                nums[i][n - j - 1] = temp;
//            }
//        }
//        int[][] interval = new int[][]{{1, 4}, {2, 3}};
//        merge(interval);
        int[] numbers = new int[]{1, 2, 3};
        plusOne(numbers);
        climbStairs(2);
        int[][] matrix = new int[][]{{1}};
        searchMatrix(matrix,0);
    }

    public static int[][] merge(int[][] intervals) {
        int m = intervals.length;
        int l = intervals[0].length;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < m; i++) {
            if (!stack.isEmpty() && intervals[i][0] < stack.peek()[0]) {
                int[] temp = stack.pop();
                temp[0] = intervals[i][0];
                temp[1] = Math.max(temp[1], intervals[i][l - 1]);
                stack.push(temp);
            } else if (!stack.isEmpty() && intervals[i][0] > stack.peek()[0]
                    && intervals[i][0] <= stack.peek()[1]) {
                int[] temp = stack.pop();
                temp[1] = intervals[i][l - 1];
                stack.push(temp);
            } else {
                stack.push(intervals[i]);
            }
        }
        int size = stack.size();
        int[][] result = new int[][]{};
        while (!stack.isEmpty()) {
            result[size - 1] = stack.pop();
            size--;
        }
        return result;
    }

    public class pair {
        int i;
        int j;

        public pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }


    public static int[] plusOne(int[] digits) {
        int n = digits.length - 1;
        for (int i = n; i >= 0; i--) {
            int temp = digits[i]++;
            digits[i] = temp % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static int climbStairs(int n) {
        int[] f = new int[n + 1];
        Arrays.fill(f, 1);
        for (int i = 2; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid][0] <= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int left1 = 0;
        int right1 = n - 1;
        while (left1 <= right1) {
            int mid = (left1 + right1) / 2;
            if (matrix[ans][mid] == target) {
                return true;
            }
            if (matrix[ans][mid] > target) {
                right1= mid - 1;
            } else {
                left1 = mid + 1;
            }
        }
        return false;
    }

}