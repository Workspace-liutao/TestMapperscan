package mapperscan.Tree;

import org.springframework.util.StringUtils;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class CalcNumberClass {
    public static void main(String[] args) {
        CalcNumberClass calcNumberClass = new CalcNumberClass();
        String s = "(1+(4+5+2)-3)+(6+8)";
        calcNumberClass.calculate(s);
        Queue queue = new LinkedList();

        String str = "-+/()1";
        String newStr = calcNumberClass.getString(str);
        String   str1="0755-12345678";
        String str2=str1.substring(0,3);
        String str3=str1.substring(0,4);
        String  str4= str1.substring(str2.length(),str1.length());
    }


    public String getString(String phone) {
        char[] newChars = new char[phone.length()];
        int index = 0, start = 0;
        while (start < phone.length()) {
            char c = phone.charAt(start);
            if (c == '-' || c == '+' || c == '/' || c == '(' || c == ')') {
                start++;
                continue;
            }
            newChars[index++] = c;
            start++;
        }
        String newStr = String.valueOf(newChars);
        return newStr;
    }

    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }
}
