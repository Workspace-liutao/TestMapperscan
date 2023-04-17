package mapperscan.Tree;

public class MissNumberClass {
    public static void main(String[] args) {
        MissNumberClass missNumberClass = new MissNumberClass();
        int[] nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        missNumberClass.missingNumber(nums);
    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i && nums[i] < n) swap(nums, nums[i], i--);
        }
        for (int j = 0; j < n; j++) {
            if (j != nums[j]) return j;
        }
        return n;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
