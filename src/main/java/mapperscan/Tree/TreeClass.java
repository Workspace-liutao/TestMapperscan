package mapperscan.Tree;

import mapperscan.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeClass {
    public static void main(String[] args) {
        TreeClass treeClass = new TreeClass();
        treeClass.generateTrees(3);
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
}
