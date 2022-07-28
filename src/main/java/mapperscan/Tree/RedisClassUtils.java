package mapperscan.Tree;

import org.redisson.Redisson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RedisClassUtils {
    public static void main(String[] args) {
        RedisClassUtils redisClassUtils = new RedisClassUtils();
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        Arrays.sort(candidates);
        int target = 8;
        List<List<Integer>> result = redisClassUtils.combinationSum2(candidates, target);
       System.out.println(result.toString());
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] visted = new boolean[candidates.length];
        List<List<Integer>> result = new ArrayList();
        List<Integer> list = new ArrayList();
        dfs(candidates, 0, target, result, list, visted);
        return result;
    }

    public void dfs(int[] candidates, int index, int target, List<List<Integer>> result, List<Integer> list, boolean[] visted) {
        if (target == 0) {
            result.add(list);
            return;

        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                continue;
            }
            if (visted[i]) {
                continue;
            }
            list.add(candidates[i]);
            visted[i] = true;
            dfs(candidates, i + 1, target - candidates[i], result, list, visted);
            visted[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
