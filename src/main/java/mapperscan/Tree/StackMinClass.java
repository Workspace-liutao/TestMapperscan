package mapperscan.Tree;

import java.security.PublicKey;
import java.util.Stack;

public class StackMinClass {
    Stack stackA = new Stack<Integer>();
    Stack stackB = new Stack<Integer>();

    public void push(int m) {
        if (stackA.isEmpty()) {
            stackB.push(m);
        } else {
            if ((int) stackB.peek() > m) {
                stackB.push(m);
            }
        }
        stackA.push(m);
    }

    public void pop() {
        if ((int) stackB.peek() == (int) stackA.pop()) {
            stackB.pop();
        }
    }

    public void getMin() {
        System.out.println(stackB.peek());
    }

    public static void main(String[] args) {
        StackMinClass stackMinClass = new StackMinClass();
        stackMinClass.push(4);
        stackMinClass.push(2);
        stackMinClass.push(1);
        stackMinClass.push(5);
        stackMinClass.push(3);
        stackMinClass.getMin();
        stackMinClass.pop();
        stackMinClass.pop();
        stackMinClass.pop();
        stackMinClass.getMin();
//        int i=1;
//        while(i<10){
//            int j=0;
//            while(j<5){
//                if(j==3){
//                    System.out.println("j="+j+"跳出内层循环");
//                    break;
//                }
//                j++;
//            }
//            System.out.println("i="+i);
//            i++;
//        }
    }
}
