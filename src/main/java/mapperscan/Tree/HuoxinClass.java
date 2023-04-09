package mapperscan.Tree;

import java.util.*;

public class HuoxinClass {
    Map<Character, List<Character>> edges = new HashMap<>();
    Map<Character, Integer> status = new HashMap<>();
    boolean vaild = true;
    char[] order;
    Integer index;

    public static void main(String[] args) {
        HuoxinClass huoxinClass = new HuoxinClass();
        String[] words = new String[]{"wrt", "wrf", "er", "ett", "rftt"};
        String srt = huoxinClass.alienOrder(words);
        String  s=Character.toString((char)257);
        String  s1=Character.toString((char)258);
    }

    //使用拓扑排序（广度优先搜索）
    public String alienOrder(String[] words) {
        //1.先统计所有的字符集合
        for (String str : words) {
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                edges.putIfAbsent(ch, new ArrayList<Character>());
            }
        }
        //2. 构造有向图
        for (int i = 1; i < words.length && vaild; i++) {
            createGraph(words[i - 1], words[i]);
        }
        //3.使用拓扑排序求解
        order = new char[edges.size()];
        Set<Character> sets = edges.keySet();
        index = edges.size() - 1;
        for (char u : sets) {
            if (!status.containsKey(u)) {
                dfs(u);
            }
        }
        if (!vaild) {
            return "";
        }
        return new String(order);
    }

    public void createGraph(String before, String after) {
        int blen = before.length(), alen = after.length(), min = Math.min(blen, alen);
        int index = 0;
        while (index < min) {
            char c1 = before.charAt(index), c2 = after.charAt(index);
            if (c1 != c2) {
                edges.get(c1).add(c2);
                break;
            }
            index++;
        }
        if (index == min && blen > alen) {
            vaild = false;
        }
    }

    public void dfs(char u) {
        status.put(u, 1);
        List<Character> adjacent = edges.get(u);
        for (char v : adjacent) {
            if (!status.containsKey(v)) {
                dfs(v);
                if (!vaild) {
                    return;
                }
            } else if (status.get(v) == 1) {
                vaild = false;
                return;
            }
        }
        status.put(u, 2);
        order[index] = u;
        index--;
    }
}
