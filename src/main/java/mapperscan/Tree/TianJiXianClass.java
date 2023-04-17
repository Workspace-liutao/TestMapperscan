package mapperscan.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TianJiXianClass {
    public static void main(String[] args) {
        TianJiXianClass tianJiXianClass = new TianJiXianClass();
        int[][] bs = new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        tianJiXianClass.getSkyline(bs);
    }

    public List<List<Integer>> getSkyline(int[][] bs) {
        List<List<Integer>> ans = new ArrayList<>();
        List<int[]> ps = new ArrayList<>();
        for (int[] b : bs) {                      //区分分类
            int l = b[0];
            int r = b[1];
            int h = b[2];
            ps.add(new int[]{l, -h});
            ps.add(new int[]{r, h});
        }
        Collections.sort(ps, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];   //按端点大小排序
            return a[1] - b[1];                  //横坐标同，按照高度排序，且左端点优先
        });
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int prev = 0;
        q.add(prev);
        for (int[] p : ps) {
            int point = p[0];
            int height = p[1];
            if (height < 0) {
                q.add(-height);                //左端点加入高度，右端点结束高度
            } else {
                q.remove(height);
            }
            int cur = q.peek();                  //看此时的最高高度与之前的是否发生变化
            if (cur != prev) {                    //上坡/下坡，高度必然变化，变化则记录
                List<Integer> list = new ArrayList<>();
                list.add(point);
                list.add(cur);
                ans.add(list);
                prev = cur;
            }
        }
        return ans;
    }
}
