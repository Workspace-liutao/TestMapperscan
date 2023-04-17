package mapperscan.Tree;

import java.util.HashMap;

public class CountLineClass {
    public static void main(String[] args) {
        CountLineClass countLineClass = new CountLineClass();
        int[][] points = new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        countLineClass.maxPoints(points);
        HashMap  map = new HashMap();
        map.getOrDefault("","");
    }

    public int maxPoints(int[][] ps) {
        int n = ps.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int[] x = ps[i];
            for (int j = i + 1; j < n; j++) {
                int[] y = ps[j];
                int cnt = 2;
                for (int k = j + 1; k < n; k++) {
                    int[] p = ps[k];
                    int s1 = (y[1] - x[1]) * (p[0] - y[0]);
                    int s2 = (p[1] - y[1]) * (y[0] - x[0]);
                    if (s1 == s2) cnt++;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}
