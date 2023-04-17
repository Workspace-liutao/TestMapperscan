package mapperscan.Tree;

import java.time.LocalDateTime;
import java.util.Arrays;

public class JiShuSortClass {
    public static void main(String[] args) {
        JiShuSortClass jiShuSortClass = new JiShuSortClass();
//        int[] nums = new int[]{1, 10000000};
//        jiShuSortClass.maximumGap(nums);
        String  str="1.08";
        String [] strs = str.split("\\.");
//        int i =Integer.parseInt(str);
        int j=str.charAt(3)-'0';
//        String.format();
        System.out.println(str);
        LocalDateTime   start =LocalDateTime.now().minusDays(1L);
        LocalDateTime   end =LocalDateTime.now().minusHours(4L);
        LocalDateTime  nextDate=LocalDateTime.now().minusMinutes(10L);
        if(nextDate.compareTo(LocalDateTime.now())<=0){
            System.out.println("");
        }

    }

    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int[] cnt = new int[10];
        int[] copyNums = new int[n];
        int max = Arrays.stream(nums).max().getAsInt();
        int exp = 1;
        while (max >= exp) {
            for (int i = 0; i < n; i++) {
                int index = (nums[i] / (int) exp) % 10;
                cnt[index]++;
            }
            for (int i = 1; i < 10; i++) {
                cnt[i] = cnt[i] + cnt[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                int index = (nums[i] / (int) exp) % 10;
                copyNums[cnt[index] - 1] = nums[i];
                cnt[index]--;
            }
            System.arraycopy(copyNums, 0, nums, 0, n);
            exp = exp * 10;
        }
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            result = Math.max(result, nums[i] - nums[i - 1]);
        }
        return result;
    }

    public int getIndex(int num, int i) {
        return num / i % 10;
    }
}
