package mapperscan.Tree;

public class CountSortClass {

    public void countSort(int arr[], int step) {
        //找出arr数组中的最大值
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] <= min) {
                min = arr[i];
            }
        }
        int length = max - min;
        //初始化数组
        int[] b = new int[length + 1];
        for (int i = 0; i < arr.length; i++) {
            b[arr[i] - step] = b[arr[i] - step] + 1;
        }
        //遍历数组b
        for (int i = 0; i < b.length; i++) {
            int temp = b[i];
            while (temp >= 1) {
                System.out.println(i+step);
                temp--;
            }
        }
    }

    public static void main(String[] args) {
        CountSortClass countSortClass = new CountSortClass();
        int[] arr = new int[]{30, 39, 32, 38, 30, 38, 39, 33, 36, 37, 35, 34, 31};
        int step = 30;
        countSortClass.countSort(arr, step);
    }

}
