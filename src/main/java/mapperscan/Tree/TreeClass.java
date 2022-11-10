package mapperscan.Tree;

import mapperscan.bean.TreeNode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TreeClass {
    public static void main(String[] args) {
        TreeClass treeClass = new TreeClass();
        treeClass.generateTrees(3);
        TreeNode root =new TreeNode(1);
        TreeNode left =new TreeNode(2);
        TreeNode right =new TreeNode(3);
        root.setLeft(left);
        root.setRight(right);
        treeClass.sumNumbers(root);
        try {
            String time = "2022/07/15 08:57:44:572";
            Date date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS").parse(time);
            long unixTimestamp = date.getTime();
            System.out.println(unixTimestamp);
            String leaveTime = "2022/07/15 08:57:44:847";
            Date leaveDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS").parse(leaveTime);
            long leaveUnixTimestamp = leaveDate.getTime();
            System.out.println(leaveUnixTimestamp);

        } catch (ParseException e) {
        }
        TreeNode root1 =new TreeNode(1);
        TreeNode left2 =new TreeNode(2);
        root1.setLeft(left2);
        treeClass.rightSideView(root1);



    }
    public int sumNumbers(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        Queue<String>  path = new LinkedList();
        int result=0;
        queue.offer(root);
        String  str =String.valueOf(root.getVal());
        path.offer(str);

        while(!queue.isEmpty()){
            TreeNode  node =queue.poll();
            String  pathNode =path.poll();
            if(node.getRight()==null && node.getLeft()==null){
                int temp=Integer.parseInt(pathNode);
                result=result+temp;
            }
            if(node.getLeft()!=null){
                queue.offer(node.getLeft());
                StringBuilder  stbLeft = new StringBuilder(pathNode);
                stbLeft.append(node.getLeft().getVal());
                path.offer(stbLeft.toString());
            }
            if(node.getRight()!=null){
                queue.offer(node.getRight());
                StringBuilder  stbRight = new StringBuilder(pathNode);
                stbRight.append(node.getRight().getVal());
                path.offer(stbRight.toString());
            }
        }
        return result;
    }



    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = getTreeNode(1,n);
        return result;
    }

    public List<TreeNode>  getTreeNode(int begin,int end){
        List<TreeNode>  result = new ArrayList();
        if(begin>end){
            result.add(null);
            return result;
        }
        for(int i=begin;i<=end;i++){
            List<TreeNode>  leftNodes =getTreeNode(begin,i-1);
            List<TreeNode>  rightNodes =getTreeNode(i+1,end);
            for(TreeNode  left: leftNodes){
                for(TreeNode  right: rightNodes){
                    TreeNode  node = new TreeNode(i);
                    node.setLeft(left);
                    node.setRight(right);
                    result.add(node);
                }
            }
        }
        return result;
    }

    public List<Integer> rightSideView(TreeNode root) {
        Stack<TreeNode>  deque = new Stack();
        Stack<Integer>  depths = new Stack();
        List<Integer>   result = new ArrayList();
        int depth=0;
        while(root!=null || !deque.isEmpty()){
            while(root!=null){
                if(depth==result.size()){
                    result.add(root.getVal());
                }
                deque.push(root);
                root=root.getRight();
                depths.push(depth++);
            }
            if(!deque.isEmpty()){
                root=deque.pop();
                depth=depths.pop();
                root=root.getLeft();
            }
        }
        return result;
    }
}
