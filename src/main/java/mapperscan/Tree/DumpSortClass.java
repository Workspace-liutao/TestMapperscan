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

    public void deleteMax(int[] arr, int index) {


    }

    public static void main(String[] args) {
        DumpSortClass dumpSortClass = new DumpSortClass();
        int[] arr = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            dumpSortClass.upDumpJust(arr, i, arr.length);
        }
        System.out.println("堆排序结果="+ Arrays.toString(arr));
        for (int i = arr.length-1; i >= 0; i--) {
            //交换第一个值和最后一个值
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            dumpSortClass.upDumpJust(arr, 0, i);
        }
        System.out.println("堆排序结果="+ Arrays.toString(arr));
    }

}
