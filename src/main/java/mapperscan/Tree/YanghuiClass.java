package mapperscan.Tree;

import java.util.ArrayList;
import java.util.List;

public class YanghuiClass {
    public static void main(String[] args) {
        YanghuiClass yanghuiClass = new YanghuiClass();
        yanghuiClass.getRow(3);

        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list1=new ArrayList<>();
        list1.add(2);
        List<Integer> list2=new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3=new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4=new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);
        yanghuiClass.minimumTotal(triangle);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList(rowIndex + 1);
        list.add(1);
        for (int i = 0; i <= rowIndex; i++) {
            list.add(0);
            for (int j = i; j > 0; j--) {
                list.set(j, list.get(j - 1) + list.get(j));
            }
        }
        return list;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int temp = triangle.get(0).get(0);
        int p = 1, q = 0;
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i > 0 && j < triangle.get(i).size() - 1) {
                    if (i == p && j == q && q < triangle.get(i).size() - 1) {
                        temp = temp + Math.min(triangle.get(p).get(q), triangle.get(p).get(q + 1));
                        q = triangle.get(p).get(q) <= triangle.get(p).get(q + 1) ? q : q + 1;
                        p = p + 1;
                    }
                }
            }
        }
        // return result[triangle.size()-1][triangle.get(triangle.size()-1).size()-1];
        return temp;
    }
}
