package mapperscan.Tree;

public class StringKmpClass {
    public static void main(String[] args) {
        StringKmpClass  stringKmpClass  = new StringKmpClass();
        String  temp="aacecaaa";
        String  result =stringKmpClass.shortestPalindrome(temp);
    }
        public String shortestPalindrome(String s) {
            int []  next =getNext(s);
            int n=s.length();
            int j=0;
            for(int i=n-1;i>=0;i--){
                while(s.charAt(i)!=s.charAt(j) && j>0){
                    j=next[j-1];
                }
                if(s.charAt(i)==s.charAt(j)){
                    j++;
                }
            }
            String add=j==n? "":s.substring(j,s.length());
            StringBuilder  stb =new StringBuilder();
            stb.append(add).reverse();
            stb.append(s);
            return stb.toString();
        }


        public   int[]   getNext(String s){
            int n =s.length();
            int []  next = new int [n];
            int j=0;
            for(int i=1;i<n;i++){
                while(s.charAt(i)!=s.charAt(j) && j!=0){
                    j=next[j-1];
                }
                if(s.charAt(i)==s.charAt(j)){
                    j++;
                    next[i]=j;
                }
            }
            return next;
        }
    }
