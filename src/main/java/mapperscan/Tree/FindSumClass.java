package mapperscan.Tree;

import java.util.*;

public class FindSumClass {

    public static List<List<Integer>> getThreeSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            int total = target - num[i];
            for (int j = i + 1; j < num.length; j++) {
                int one = total - num[j];
                if (map.containsKey(one)) {
                    result.add(Arrays.asList(num[i], one, num[j]));
                }
                map.put(num[j], j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] num = new int[]{1, 2, 3, 5, 6, 7, 9, 12};
//        List<List<Integer>> result = FindSumClass.getThreeSum(num, 13);
        int[] num = new int[]{1, 2, 3, 5, 6, 7, 9, 12};
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> result = FindSumClass.getThreeSumByPoint(nums, 0);
        System.out.println(result.toString());
    }

    public static List<List<Integer>> getThreeSumByPoint(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            if(i< num.length-1 && num[i]==num[i+1]){
                continue;
            }
            int total = target - num[i];
            for (int m = i + 1, n = num.length - 1; m < num.length; m++) {
                while (m < n && (num[m] + num[n]) > total) {
                    n--;
                }
                if (m == n) {
                    break;
                }
                if (num[m] + num[n] == total) {

                    result.add(Arrays.asList(num[i], num[m], num[n]));
                }

            }
        }
        return result;
    }
}
