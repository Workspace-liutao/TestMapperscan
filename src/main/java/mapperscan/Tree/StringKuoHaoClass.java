package mapperscan.Tree;

import java.util.Deque;
import java.util.LinkedList;


public class StringKuoHaoClass {
    public static void main(String[] args) {
        StringKuoHaoClass stringKuoHaoClass = new StringKuoHaoClass();
        String str1 = "(1234";
        String str2 = "(12)34";
        String str3 = "(12)(34";
        String str4 = "(12)()34";
        String str5 = ")1234";
        String str6 = ")(1234";
        String str7 = "1234";
        String str8 = "1234";
        boolean flag1 = stringKuoHaoClass.isValidPhoneNumber(str1);
        boolean flag2 = stringKuoHaoClass.isValidPhoneNumber(str2);
        boolean flag3 = stringKuoHaoClass.isValidPhoneNumber(str3);
        boolean flag4 = stringKuoHaoClass.isValidPhoneNumber(str4);
        boolean flag5 = stringKuoHaoClass.isValidPhoneNumber(str5);
        boolean flag6 = stringKuoHaoClass.isValidPhoneNumber(str6);
        boolean flag7 = stringKuoHaoClass.isValidPhoneNumber(str7);
        boolean flag8 = stringKuoHaoClass.isValidPhoneNumber(str8);
    }

    public boolean checkKuoHao(String str) {
        Deque<Character> stack = new LinkedList<>();
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                if (stack.isEmpty()) {
                    stack.push(ch[i]);
                } else {
                    return false;
                }
            }
            if (ch[i] == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return false;
        }
        int openParenthesesCount = 0;
        int closeParenthesesCount = 0;
        for (int i = 0; i < phoneNumber.length(); i++) {
            char c = phoneNumber.charAt(i);
            if (c == '(') {
                openParenthesesCount++;
            } else if (c == ')') {
                closeParenthesesCount++;
            }
            if (closeParenthesesCount > openParenthesesCount) {
                return false;
            }
        }
        if (openParenthesesCount != closeParenthesesCount) {
            return false;
        }
        return true;
    }
}
