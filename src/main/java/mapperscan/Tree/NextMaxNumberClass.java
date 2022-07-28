package mapperscan.Tree;

public class NextMaxNumberClass {
    public static void main(String[] args) {
        NextMaxNumberClass  nextMaxNumberClass = new NextMaxNumberClass();
        int [] nums = new int[]{3,2,1};
        nextMaxNumberClass.getNextMaxNumber(nums);
        System.out.println(nums.toString());
    }


    public int[] getNextMaxNumber(int nums[]) {
        int i = nums.length - 2;
        while (i > 0 && nums[i] > nums[i + 1]) {
            i--;
        }
        if (i > 0) {
            int j = nums.length - 1;
            while (j > 0 && nums[j] <nums[i]) {
                j--;
            }
            swip(i, j, nums);
        }
        reorder(nums, i+1, nums.length-1);
        return nums;
    }

    public void swip(int i, int j, int[] nums) {
        int temp = 0;
        temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public void reorder(int[] nums, int begin, int end) {
        while (begin < end) {
            swip(begin, end, nums);
            begin++;
            end--;
        }
    }

}
