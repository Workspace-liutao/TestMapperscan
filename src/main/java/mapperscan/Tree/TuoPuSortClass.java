package mapperscan.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TuoPuSortClass {
    public static void main(String[] args) {
        TuoPuSortClass tuoPuSortClass = new TuoPuSortClass();
        tuoPuSortClass.findOrder(2, new int[][]{{1, 0}});
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 使用广度遍历求解
        int[] indegree = new int[numCourses];
        List<List<Integer>> allList = new ArrayList();
        //初始化图边集合
        for (int i = 0; i < numCourses; i++) {
            allList.add(new ArrayList());
        }
        //初始化图中各节点入度和边集合
        for (int[] temp : prerequisites) {
            indegree[temp[0]]++;
            allList.get(temp[1]).add(temp[0]);
        }
        Queue<Integer> queue = new LinkedList();
        int index = 0;
        int result[] = new int[numCourses];
        //寻找入度为0的顶点，加入到队列中
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
            while (!queue.isEmpty()) {
                int i1 = queue.poll();
                result[index++] = i1;
                for (int j : allList.get(i1)) {
                    --indegree[j];
                    if (indegree[j] == 0) {
                        queue.offer(j);
                    }
                }
            }
        }
        if (index != numCourses) {
            return new int[0];
        }
        return result;
    }
}
