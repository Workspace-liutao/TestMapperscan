package mapperscan.Tree;

import java.util.Deque;
import java.util.LinkedList;

public class Calc2Class {
    public static void main(String[] args) {
        Calc2Class  calc2Class = new   Calc2Class();
        String  s=" 3/2 ";
        calc2Class.calculate(s);
    }

        public int calculate(String s) {
            int n =s.length();
            int ret=0;
            int num=0;
            char presign ='+';
            Deque<Integer> stack = new LinkedList();
            for(int i=0;i<n;i++){
                if(Character.isDigit(s.charAt(i))){
                    num=num*10+s.charAt(i)-'0';
                }
                if(!Character.isDigit(s.charAt(i)) && s.charAt(i)!=' ' || i == n - 1){
                    switch(presign){
                        case '+':
                            stack.push(num);
                            break;
                        case '-':
                            stack.push(-num);
                            break;
                        case '*':
                            stack.push(stack.pop()*num);
                            break;
                        default:
                            stack.push(stack.pop() / num);
                            break;
                    }
                    presign=s.charAt(i);
                    num=0;
                }
            }
            while(!stack.isEmpty()){
                ret+=stack.pop();
            }
            return ret;
        }
    }

