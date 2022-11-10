package mapperscan.Tree;

import java.util.Arrays;

public class DumpSortClass {

    //下称构建二叉堆
    public void upDumpJust(int[] arr, int parent, int length) {
        int child = parent * 2 + 1;
        int temp = arr[parent];
        while (child < length) {
            if (child + 1 < length && arr[child] <= arr[child + 1]) {
                child++;
            }
            if (temp >= arr[child]) {
                break;
            }
            //交换父子节点
            arr[parent] = arr[child];
            parent = child;
            child = parent * 2 + 1;
        }
        arr[parent] = temp;
    }

    //下称构建二叉堆
    public void upMinDumpJust(int[] arr, int parent, int length) {
        int child = parent * 2 + 1;
        int temp = arr[parent];
        while (child < length) {
            if (child + 1 < length && arr[child] > arr[child + 1]) {
                child++;
            }
            if (temp <= arr[child]) {
                break;
            }
            //交换父子节点
            arr[parent] = arr[child];
            parent = child;
            child = parent * 2 + 1;
        }
        arr[parent] = temp;
    }


    public void deleteMax(int[] arr, int index) {


    }

    public static void main(String[] args) {
        DumpSortClass dumpSortClass = new DumpSortClass();
        int[] arr = new int[]{15252, 16764, 27963, 7817, 26155, 20757, 3478, 22602, 20404, 6739, 16790, 10588, 16521, 6644, 20880, 15632, 27078, 25463, 20124, 15728, 30042, 16604, 17223, 4388, 23646, 32683, 23688, 12439, 30630, 3895, 7926, 22101, 32406, 21540, 31799, 3768, 26679, 21799, 23740};
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            dumpSortClass.upMinDumpJust(arr, i, arr.length);
        }
        System.out.println("堆调整后的结果=" + Arrays.toString(arr));
        boolean flag = false;
        int max = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            //交换第一个值和最后一个值
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            dumpSortClass.upMinDumpJust(arr, 0, i);
            if (flag) {
                max = Math.max(max, arr[i + 1] - arr[i]);
            }
            if (i == arr.length - 1) {
                flag = true;
            }
        }
        System.out.println("堆排序结果=" + Arrays.toString(arr));
        System.out.println("max=" + max);
    }

}
