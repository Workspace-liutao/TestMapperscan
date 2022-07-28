package mapperscan.Tree;

import mapperscan.bean.LinkedNode;

import java.util.HashMap;
import java.util.Map;

public class LruCatcheClass {
    int cap;
    LinkedNode  head,tail;
    Map<String,LinkedNode> maps = new HashMap<>();

    public LruCatcheClass() {
        this.cap = cap;
    }

    public  void  addNode(LinkedNode  node){
    }
    public   void deleteNode(LinkedNode node){

    }

    public   void reverse(LinkedNode node){

    }

    public static void main(String[] args) {
        LruCatcheClass  lruCatcheClass= new LruCatcheClass();
        String haystack = "hello", needle = "ll";
        lruCatcheClass.strStr(haystack,needle);
    }

    public int strStr(String haystack, String needle) {
        int []  next =getNext(needle);
        int j=0;
        int begin=-1;
        for(int i=0;i<haystack.length();i++){
            while(j>0 && haystack.charAt(i)!=needle.charAt(j)){
                j=next[j-1];
            }
            if(haystack.charAt(i)==needle.charAt(j)){
                j++;
            }
            if(j==haystack.length()){
                begin=i-j+1;
                break;
            }
        }
        return begin;
    }
    public  int[]  getNext(String needle){
        int n=needle.length();
        int [] next = new int[n];
        int j=0;
        for(int i=1;i<n;i++){
            while(j>0 && needle.charAt(i)!=needle.charAt(j)){
                j=next[j-1];
            }
            if(needle.charAt(i)==needle.charAt(j)){
                j++;
                next[i]=j;
            }
        }
        return next;
    }

}
