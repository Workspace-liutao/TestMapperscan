package mapperscan.Tree;

import java.util.ArrayList;
import java.util.List;

public class CoinClass {
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 5};
        List<Integer> list = new ArrayList<>();
        dfs(numbers,0,11,list);
        System.out.println(min==Integer.MAX_VALUE? -1:min);
    }

    public static  void dfs(int[] numbers, int index, int result, List<Integer> list) {
        if (result < 0) {
            return;
        }
        if (result == 0) {
            min = Math.min(min, list.size());
        }
        for (int i = index; i < numbers.length; i++ ){
            list.add(numbers[i]);
            dfs(numbers,i,result-numbers[i],list);
            list.remove(list.size()-1);
        }
    }
}
