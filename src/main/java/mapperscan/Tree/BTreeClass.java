package mapperscan.Tree;



import mapperscan.bean.LinkedNode;
import mapperscan.bean.TreeNode;

public class BTreeClass {
    public static void main(String[] args) {
        BTreeClass  bTreeClass  = new BTreeClass();
       // LinkedNode  node0= new LinkedNode(0);
        LinkedNode  node1= new LinkedNode(1);
        LinkedNode  node2= new LinkedNode(2);
        LinkedNode  node3= new LinkedNode(3);
        LinkedNode  node4= new LinkedNode(4);
        LinkedNode  node5= new LinkedNode(5);
        LinkedNode  node6= new LinkedNode(6);
      //  node0.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        TreeNode root= bTreeClass.sortedListToBST(node1);
        System.out.println(root.toString());
    }
    public TreeNode sortedListToBST(LinkedNode head) {
        return dfs(head,null);
    }
    public TreeNode dfs(LinkedNode left,LinkedNode right){
        if(left==right){
            return null;
        }
        LinkedNode mid =getMid(left,right);
        TreeNode  root =new TreeNode(mid.getValue());
        root.setLeft(dfs(left,mid));
        root.setRight(dfs(mid.getNext(),right));
        return root;
    }
    public LinkedNode  getMid(LinkedNode left,LinkedNode right){
        LinkedNode slow =left;
        LinkedNode  fast =left;
        while(fast!=right && fast.getNext()!=right){
            fast=fast.getNext();
            fast=fast.getNext();
            slow=slow.getNext();
        }
        return slow;
    }
}
