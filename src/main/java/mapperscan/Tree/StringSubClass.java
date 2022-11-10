package mapperscan.Tree;

import java.util.ArrayList;
import java.util.List;

public class StringSubClass {
    public static void main(String[] args) {
        StringSubClass stringSubClass = new StringSubClass();
        String s = "aab";
        stringSubClass.partition(s);
        String  str="  hello world  ";
        stringSubClass.reverseWords(str);
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList();
        int n = s.length();
        boolean[][] depth = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            depth[i][i] = true;
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    depth[i][j] = false;
                } else {
                    if (j - i < 3) {
                        depth[i][j] = true;
                    } else {
                        depth[i][j] = depth[i + 1][j - 1];
                    }
                }
            }
        }
        dfs(s, 0, result, new ArrayList(), depth);
        return result;
    }

    public void dfs(String s, int i, List<List<String>> result, List<String> list, boolean[][] depth) {
        if (s.length() == i) {
            result.add(new ArrayList(list));
            return;
        }
        for (int j = i; j < s.length() - 1; j++) {
            if (depth[i][j]) {
                list.add(s.substring(i, j + 1));
                dfs(s, j + 1, result, list, depth);
                list.remove(list.size() - 1);
            }
        }

    }

    public String reverseWords(String s) {
        String  str="";
        int i=0;
        int  index =s.length();
        while(s.charAt(index-1)==' '){
            index--;
        }
        while(index>0){
            while(index >0 && s.charAt(index-1)==' '){
                index--;
                i=0;
            }
            while(index >0 && s.charAt(index-1)!=' '){
                i++;
                index--;
            }
            // if(index==0 && i==0){
            //     break;
            // }
            String str1=s.substring(index,index+i);
            str=str+str1+" ";
        }
        return str.substring(0,str.length()-1);
    }
}
