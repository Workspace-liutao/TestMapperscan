package mapperscan.Tree;

public class SortClassUtils {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 0};
        sort1(numbers, 0, numbers.length - 1);
        System.out.println(numbers.toString());
    }

    public static void sort(int nums[], int begin, int end) {
        if (begin >= end) {
            return;
        }
        int index = getIndex1(nums, begin, end);
        sort(nums, index + 1, end);
        sort(nums, begin, index - 1);
    }

    public static int getIndex(int nums[], int begin, int end) {
        int index = begin;
        int temp = nums[begin];
        while (begin != end) {
            while (begin < end && nums[end] > temp) {
                end--;
            }
            while (begin < end && nums[begin] <= temp) {
                begin++;
            }
            if (begin < end) {
                int temps = nums[end];
                nums[end] = nums[begin];
                nums[begin] = temps;
            }
        }
        nums[index] = nums[begin];
        nums[begin] = temp;
        return begin;
    }

    public static void sort1(int[] nums, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int index = getIndex(nums, begin, end);
        sort1(nums, index + 1, end);
        sort1(nums, begin, index - 1);

    }

    public static int getIndex1(int[] nums, int begin, int end) {
        int index = begin;
        int temp = nums[begin];
        while (begin != end) {
            while (begin < end && nums[end] > temp) {
                end--;
            }
            while (begin < end && nums[begin] <= temp) {
                begin++;
            }
            if (end < begin) {
                int temps = nums[end];
                nums[begin] = nums[end];
                nums[begin] = temps;
            }
        }
        nums[index] = nums[begin];
        nums[begin] = temp;
        return begin;
    }

}
