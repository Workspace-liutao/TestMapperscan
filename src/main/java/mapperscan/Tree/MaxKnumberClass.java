package mapperscan.Tree;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaxKnumberClass {
    PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] != o2[0] ? o2[0] - o1[0] : o1[0] - o2[0];
        }
    });

    public static void main(String[] args) {
        MaxKnumberClass maxKnumberClass = new MaxKnumberClass();
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] temp = maxKnumberClass.getMax(nums, k);
        int[] temp1=maxKnumberClass.getMaxUseMonotQueue(nums,k);
    }

    public int[] getMax(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        result[0] = queue.peek()[0];
        for (int j = k; j < nums.length; j++) {
            queue.offer(new int[]{nums[j], j});
            while (queue.peek()[1] <= j - k) {
                queue.poll();
            }
            result[j - k + 1] = queue.peek()[0];
        }
        return result;
    }

    public int[] getMaxUseMonotQueue(int[] nums, int k) {
        //创建单调队列
        Deque<Integer> deque = new LinkedList<Integer>();
        int n = nums.length;
        int[] result = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        result[0] = nums[deque.peekFirst()];
        for (int j = k; j < n; j++) {
            while (!deque.isEmpty() && nums[j] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(j);
            while (!deque.isEmpty() && deque.peekFirst() <= j - k) {
                deque.pollFirst();
            }
            result[j - k + 1] = nums[deque.peekFirst()];
        }
        return result;
    }
}