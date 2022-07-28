package mapperscan.Tree;

import org.springframework.util.StringUtils;

import java.util.*;

public class SortNumberClass {
    public void maoPaoSort(int[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] >= arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public void maoPaoChangeSort(int[] arr) {
        int sortIndex = 0;
        int end = arr.length - 1;
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < end; j++) {
                if (arr[j] >= arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                    sortIndex = j;
                }
            }
            end = sortIndex;
            if (flag) {
                break;
            }
        }
    }


    public void quicklySort(int arr[], int left, int right) {
        if (left >= right) {
            return;
        }
        int index = getIndex(arr, left, right);
        quicklySort(arr, left, index - 1);
        quicklySort(arr, index + 1, right);
    }

    public int getIndex(int arr[], int left, int right) {
        int index = left;
        int temps = arr[index];
        while (left != right) {
            while (left < right && arr[right] > arr[index]) {
                right--;
            }
            while (left < right && arr[left] <= arr[index]) {
                left++;
            }
            if (left < right) {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
        }
        //交换基准数据位置
        arr[index] = arr[left];
        arr[left] = temps;
        System.out.println("快排返回基准位置坐标=" + left);
        return left;
    }

    public void quiCkyOrderByLinked(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int portion = this.getIndexByLinked(arr, left, right);
        quiCkyOrderByLinked(arr, left, portion - 1);
        quiCkyOrderByLinked(arr, portion + 1, right);
    }

    public int getIndexByLinked(int[] arr, int left, int right) {
        int mark = left;
        int temp = 0;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < arr[left]) {
                mark++;
                temp = arr[i];
                arr[i] = arr[mark];
                arr[mark] = temp;
            }
        }
        temp = arr[left];
        arr[left] = arr[mark];
        arr[mark] = temp;
        System.out.println("快排返回基准位置坐标=" + mark);
        return mark;
    }

    public void quickSortByStack(int[] arr, int left, int right) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("left", left);
        map.put("right", right);
        stack.push(map);
        while (!stack.isEmpty()) {
            map = stack.pop();
            int lefts = map.get("left");
            int rights = map.get("right");
            int position = this.getIndexByLinked(arr, lefts, rights);
            if (lefts < position - 1) {
                map = new HashMap<>();
                map.put("left", left);
                map.put("right", position - 1);
                stack.push(map);
            }
            if (position + 1 < rights) {
                map = new HashMap<>();
                map.put("left", position + 1);
                map.put("right", rights);
                stack.push(map);
            }
        }
    }

    public boolean isValid(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        Map<Character, Character> maps = new HashMap();
        maps.put(')', '(');
        maps.put(']', '[');
        maps.put('}', '{');
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (maps.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != maps.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }

        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        SortNumberClass sortNumberClass = new SortNumberClass();
        String  str2="上海和行卡|哈好的";
        int[] arr = new int[]{2, 3, 5, 1, 7, 6};
//        sortNumberClass.maoPaoChangeSort(arr);
//        sortNumberClass.quicklySort(arr, 0, arr.length - 1);
//        sortNumberClass.quiCkyOrderByLinked(arr, 0, arr.length - 1);
        sortNumberClass.quickSortByStack(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
        String str = "){";
        sortNumberClass.isValid(str);
        int[] nums = new int[]{0, 0, 0, 1000000000, 1000000000, 1000000000, 1000000000};
        int target = 1000000000;
        sortNumberClass.fourSum(nums,target);

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        dfs(nums, target, 0, result, new ArrayList());
        return result;
    }

    public void dfs(int[] nums, int target, int index, List<List<Integer>> result, List<Integer> list) {
        if (list.size() > 4) {
            return;
        }
        if (target == 0 && list.size() == 4) {
            result.add(new ArrayList(list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            if (i < nums.length - 1 && nums[i] + (3 - list.size()) * nums[i + 1] > target) {
                continue;
            }
            int temp =nums[i] + (3 - list.size()) * nums[nums.length - 1];
            if (i < nums.length - 1 && temp< target) {
                continue;
            }
            list.add(nums[i]);
            dfs(nums, target - nums[i], i + 1, result, list);
            list.remove(list.size() - 1);
        }
    }

}
