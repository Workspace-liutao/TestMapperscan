package mapperscan.Tree;

public class RadixSortClass {

    public String[] sortByRadix(String[] arr, int maxLength) {
        String[] sortArray = new String[arr.length];
        for (int k = maxLength; k >= 0; k--) {
            int[] count = new int[128];
            //遍历原数据，按照第k位排序
            for (int i = 0; i < arr.length; i++) {
                count[getIndex(arr[i], k)]++;
            }
            // 统计数组中的各元素位置
            for (int j = 1; j < count.length; j++) {
                count[j] = count[j] + count[j - 1];
            }
            // 将原数据倒叙遍历，按照辅助数组位置输出原数组
            for (int m = arr.length - 1; m >= 0; m--) {
                int sortIndex = getIndex(arr[m], k);
                sortArray[count[sortIndex] - 1] = arr[m];
                count[sortIndex]--;
            }
            arr = sortArray.clone();
        }
        return sortArray;
    }

    public int getIndex(String str, int k) {
        if (str.length() < (k + 1)) {
            return 0;
        } else {
            return str.charAt(k);
        }
    }

    public static void main(String[] args) {
        RadixSortClass radixSortClass = new RadixSortClass();
        String[] arr = new String[]{"bda", "cfd", "qwe", "yui", "abc", "rrr", "uue"};
        arr = radixSortClass.sortByRadix(arr, 3);
        System.out.println(radixSortClass.sortByRadix(arr, 3));
    }

}
