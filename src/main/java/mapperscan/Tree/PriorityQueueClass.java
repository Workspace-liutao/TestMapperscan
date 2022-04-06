package mapperscan.Tree;

import java.util.Arrays;

public class PriorityQueueClass {
    private int[] arr;
    private int size;

    public PriorityQueueClass() {
        this.arr = new int[8];
        this.size = this.arr.length;
    }

    public void addJustQueue(int k) {
        if (this.arr.length >= size) {
            this.resize();
        }
        arr[size++] = k;
        addJust();
    }

    public void addJust() {
        int lastIndex = size - 1;
        int parentIndex = (lastIndex - 1) / 2;
        int temp = arr[lastIndex];
        while (temp > arr[parentIndex] && lastIndex > 0) {
            arr[lastIndex] = arr[parentIndex];
            lastIndex = parentIndex;
            parentIndex = (lastIndex - 1) / 2;
        }
        arr[lastIndex] = temp;
    }

    public void popJust() {
        int parentIndex = 0;
        arr[parentIndex] = arr[size - 1];
        int temp = arr[parentIndex];
        int childIndex = parentIndex * 2 + 1;
        while (childIndex < size) {
            if (childIndex + 1 < size && arr[childIndex] < arr[childIndex + 1]) {
                childIndex++;
            }
            if (temp >= arr[childIndex]) {
                break;
            }
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
        arr[parentIndex] = temp;
    }


    public void resize() {
        int newSize = size * 2;
        this.arr = Arrays.copyOf(this.arr, newSize);
    }

    public static void main(String[] args) {
        PriorityQueueClass priorityQueueClass = new PriorityQueueClass();
        priorityQueueClass.addJustQueue(3);
        priorityQueueClass.addJustQueue(5);
        priorityQueueClass.addJustQueue(10);
        priorityQueueClass.addJustQueue(2);
        priorityQueueClass.addJustQueue(7);
        priorityQueueClass.popJust();
        priorityQueueClass.popJust();
        priorityQueueClass.popJust();
        priorityQueueClass.popJust();

    }

}
