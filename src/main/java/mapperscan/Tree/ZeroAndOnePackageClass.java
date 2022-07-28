package mapperscan.Tree;

public class ZeroAndOnePackageClass {
    public static void main(String[] args) {
        ZeroAndOnePackageClass zeroAndOnePackageClass = new ZeroAndOnePackageClass();
        int packages = 10;
        int[] v = new int[]{2, 2, 6, 5, 4};
        int[] w = new int[]{6, 3, 5, 4, 6};
        int[][] enumResult = new int[v.length][packages + 1];
        //使用自顶向底向顶方法求解
        int[][] endResults = zeroAndOnePackageClass.getResultByEnd(v, w, packages);
        int[] endResult = zeroAndOnePackageClass.getEndByEnd(endResults, v);
        //使用自底向顶方法求解
        int[][] frontResults = zeroAndOnePackageClass.getResultByFront(v, w, packages);
        int[] frontResult = zeroAndOnePackageClass.getEndByFront(frontResults, v);
        //使用递归方法求解问题
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j <= packages; j++) {
                enumResult[i][j] = -1;
            }
        }
        int result = zeroAndOnePackageClass.Load_Bag(v, w, v.length, packages);
        zeroAndOnePackageClass.getBestValue(v, w, v.length, packages, enumResult);
        System.out.println(frontResult.toString());
    }

    /**
     * 自底向顶计算结果
     *
     * @param v
     * @param w
     * @param packages
     * @return
     */
    public int[][] getResultByEnd(int[] v, int[] w, int packages) {
        int length = v.length;
        int[][] result = new int[length][packages + 1];
        //先计算背包只装最后一件物品时的最大价值。
        for (int i = 0; i <= packages; i++) {
            if (i < v[length - 1]) {
                //当背包容量小于当前物品重量时，最大价值为0。
                result[length - 1][i] = 0;
            } else {
                //当背包容量大于等于当前物品重量时，背包最大价值为当前物品的最大价值。
                result[length - 1][i] = w[length - 1];
            }
        }
        //从后向前递推计算背包依次装入其他物品时的最大价值
        for (int i = length - 2; i >= 0; i--) {
            for (int j = 0; j <= packages; j++) {
                //当背包容量大于当前物品所需要重量时，当前背包的最大价值为：Math.max（背包选择装该物品，背包选择不装该物品）
                //当背包选择装该物品时，当前最大价值=result[i+1][j-v[i]]+ w[i];
                //当背包不选择装该物品时，当前最大价值=result[i+1][j];
                if (j >= v[i]) {
                    result[i][j] = Math.max(result[i + 1][j], result[i + 1][j - v[i]] + w[i]);
                } else {
                    //当背包容量小于当前物品重量时，背包的最大价值=result[i+1][j];
                    result[i][j] = result[i + 1][j];
                }
            }
        }
        return result;
    }

    /**
     * 根据自底向顶计算方式计算最终背包中的装那些物品
     *
     * @param results
     * @param v
     * @return
     */
    public int[] getEndByEnd(int[][] results, int[] v) {
        int n = v.length;
        int[] end = new int[n];
        int l = results[0].length;
        //若result[i][j]==result[i+1][j]时，说明第i个物品未装入背包中，设置数组下标位置为0；
        //当result[i][j]！=result[i+1][j]时，说明第i个物品装入背包中，设置数组下标位置为1；当装入第i物品以后，需要寻找i物品的后继节点即第i+个节点，
        //第i+1个节点的背包容量为j-w[i];
        //当i=n-1时检查最大价值是否=0，等于0则未装入物品，不等于0则装入物品。
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && results[i][l - 1] != results[i + 1][l - 1]) {
                end[i] = 1;
                l = l - v[i];
            } else if (i == n - 1 && results[i][l] > 0) {
                end[i] = 1;
            }
        }
        return end;
    }

    /**
     * 自顶向底计算结果
     *
     * @param v
     * @param w
     * @param packages
     * @return
     */
    public int[][] getResultByFront(int[] v, int[] w, int packages) {
        int length = v.length;
        int[][] result = new int[length][packages + 1];
        //先计算背包只装第一件物品时的最大价值。
        for (int i = 0; i <= packages; i++) {
            if (i < v[0]) {
                //当背包容量小于当前物品重量时，最大价值为0。
                result[0][i] = 0;
            } else {
                //当背包容量大于等于当前物品重量时，背包最大价值为当前物品的最大价值。
                result[0][i] = w[0];
            }
        }
        //从前向后递推计算背包依次装入其他物品时的最大价值
        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= packages; j++) {
                //当背包容量大于当前物品所需要重量时，当前背包的最大价值为：Math.max（背包选择装该物品，背包选择不装该物品）
                //当背包选择装该物品时，当前最大价值=result[i-1][j-v[i]]+ w[i];
                //当背包不选择装该物品时，当前最大价值=result[i-1][j];
                if (j >= v[i]) {
                    result[i][j] = Math.max(result[i - 1][j], result[i - 1][j - v[i]] + w[i]);
                } else {
                    //当背包容量小于当前物品重量时，背包的最大价值=result[i-1][j];
                    result[i][j] = result[i - 1][j];
                }
            }
        }
        return result;
    }

    /**
     * 根据自顶向底计算方式计算最终背包中的装那些物品
     *
     * @param results
     * @param w
     * @return
     */
    public int[] getEndByFront(int[][] results, int[] w) {
        int n = w.length;
        int[] end = new int[n];
        int l = results[0].length;
        for (int i = n - 1; i >= 0; i--) {
            if (i > 0 && results[i][l - 1] != results[i - 1][l - 1]) {
                end[i] = 1;
                l = l - w[i];
            } else if (i == 0 && results[i][l] > 0) {
                end[i] = 1;
            }
        }
        return end;
    }

    /**
     * 使用暴力枚举解法求解
     *
     * @param v
     * @param w
     * @param index
     * @param packages
     * @param result
     * @return
     */
    public int getBestValue(int[] v, int[] w, int index, int packages, int[][] result) {
        if (index == 0 || packages <= 0) {
            return 0;
        }
        if (result[index - 1][packages] != -1) {
            return result[index - 1][packages];
        }
        //当前背包不装该物品时的最大价值。
        int res = getBestValue(v, w, index - 1, packages, result);
        if (packages >= v[index - 1]) {
            res = Math.max(res, getBestValue(v, w, index - 1, packages - v[index - 1], result) + w[index - 1]);
        }
        result[index - 1][packages] = res;
        return res;
    }

    public int Load_Bag(int[] v, int[] w, int i, int capacity) {
        if (i == 0 || capacity == 0) {
            return 0;//如果考虑装用容量为capacity的背包装0个物品或者用0容量的背包装i个物品，所得价值为0
        }
        if (capacity < v[i - 1]) {
            return Load_Bag(v, w, i - 1, capacity);//如果容积为capacity得背包装不下w[i]的物体，则其情况和用
            //capacity的背包装i-1的情况相同
        } else {
            return Math.max(Load_Bag(v, w, i - 1, capacity), (Load_Bag(v, w, i - 1, capacity - v[i - 1]) + w[i - 1]));//分两种情况，考虑装第i个物品，或不装
        }
    }
}
