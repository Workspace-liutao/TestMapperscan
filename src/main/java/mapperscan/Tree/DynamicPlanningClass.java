package mapperscan.Tree;

public class DynamicPlanningClass {
    /**
     * 递归算法实现
     *
     * @param g 数组表示的每座金矿的黄金储存量
     * @param p 代表挖掘每座金矿需要多少人
     * @param w 总的员工数
     * @param n 总的金矿数量
     * @return
     */
    public int getBestGood(int[] g, int[] p, int w, int n) {
        if (n == 0 || w == 0) {
            return 0;
        }
        if (w < p[n - 1]) {
            return getBestGood(g, p, w, n - 1);
        } else {
            return Math.max(getBestGood(g, p, w, n - 1), getBestGood(g, p, w - p[n - 1], n - 1) + g[n - 1]);
        }
    }

    public static void main(String[] args) {
        int[] g = new int[]{500, 300, 400, 200, 400};
        int[] p = new int[]{5, 3, 5, 4, 5};
        DynamicPlanningClass dynamicPlanningClass = new DynamicPlanningClass();
        System.out.println(dynamicPlanningClass.getBestGood(g, p, 10, g.length));
        System.out.println(dynamicPlanningClass.getMaxValue(g, p, 10, g.length));
    }


    public int getMaxValue(int[] g, int[] p, int w, int n) {
        int[][] value = new int[n + 1][g.length + 1];
        for (int i = 1; i <= g.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (j < p[i - 1]) {
                    value[i][j] = value[i - 1][j];
                } else {
                    value[i][j] = Math.max(value[i - 1][j], value[i - 1][j - 1] + g[i - 1]);
                }

            }
        }
        return value[g.length][n];
    }


}
