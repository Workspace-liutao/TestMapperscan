package mapperscan.Tree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HuiYiShiClass {
    public static void main(String[] args) {
        int[][] ints = new int[][]{{5, 10}, {0, 30}, {15, 20}};
        HuiYiShiClass huiYiShiClass = new HuiYiShiClass();
//        huiYiShiClass.canAttendMeetings(ints);
        int temp = huiYiShiClass.minMeetingRooms(ints);
    }

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }

    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(intervals.length,
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                });
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        queue.offer(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > queue.peek()) {
                queue.poll();
            }
            queue.offer(intervals[i][1]);
        }
        return queue.size();
    }

}
