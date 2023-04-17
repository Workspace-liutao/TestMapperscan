package mapperscan.Tree;

import java.lang.reflect.Array;

public class DumpTrees {

    public void upJustDump(int[] arr) {
        int lastIndex = arr.length - 1;
        int temp = arr[lastIndex];
        int parentIndex = (lastIndex - 1) / 2;
        while (lastIndex > 0 && temp > arr[parentIndex]) {
            arr[lastIndex] = arr[parentIndex];
            lastIndex = parentIndex;
            parentIndex = (lastIndex - 1) / 2;
        }
        arr[lastIndex] = temp;
    }

    public void downJustDump(int[] arr, int parent, int length) {
        int childIndex = parent * 2 + 1;
        int temp = arr[parent];
        while (childIndex < length) {
            if (childIndex + 1 <= length && arr[childIndex + 1] < arr[childIndex]) {
                childIndex++;
            }
            if (temp <= arr[childIndex]) {
                break;
            }
            arr[parent] = arr[childIndex];
            parent = childIndex;
            childIndex = parent * 2 + 1;
        }
        arr[parent] = temp;
    }

    public static void main(String[] args) {
        DumpTrees dumpTrees = new DumpTrees();
        int[] arr = new int[]{2, 3, 7, 4, 5, 1, 9};
        dumpTrees.upJustDump(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            dumpTrees.downJustDump(arr, i, arr.length);
        }
        System.out.println("堆下沉后");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


}
