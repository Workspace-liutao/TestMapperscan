package mapperscan.Tree;

import java.util.Stack;

public class QueueCreateByStackClass {
    Stack stackIn = new Stack<Integer>();
    Stack stackOut = new Stack<Integer>();

    public void add(int m) {
        stackIn.add(m);
    }

    public int get() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.add(stackIn.pop());
            }
        }
        return (int) stackOut.pop();
    }

    public static void main(String[] args) {
        QueueCreateByStackClass queueCreateByStackClass = new QueueCreateByStackClass();
        queueCreateByStackClass.add(1);
        queueCreateByStackClass.add(3);
        System.out.println(queueCreateByStackClass.get());
        queueCreateByStackClass.add(2);
        System.out.println(queueCreateByStackClass.get());
        System.out.println(queueCreateByStackClass.get());
    }
}
