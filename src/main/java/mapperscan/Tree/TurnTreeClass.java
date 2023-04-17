package mapperscan.Tree;

import mapperscan.bean.TreeNode;

public class TurnTreeClass {
    public static void main(String[] args) {
        TurnTreeClass treeClass = new TurnTreeClass();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        treeClass.upsideDownBinaryTree(node1);
        treeClass.upsideDownBinaryTree1(node1);
    }

    //记录反转后的头节点
    TreeNode head = null;

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        //对于root来说，父节点为null
        dfs(root, null);
        return head;
    }

    public void dfs(TreeNode root, TreeNode pre) {
        if (root == null) return;
        //前序遍历，先往左走
        dfs(root.getLeft(), root);
        if (head == null) {
            //head置为最左边的节点
            head = root;
        }
        if (pre != null) {
            //父节点的left置为null，不会对遍历过程造成影响，因为左边已经全部遍历完成了
            pre.setLeft(null);
            //当前节点左节点置为父节点的右节点
            root.setLeft(pre.getLeft());
            //父节点的right置为null，不会对遍历过程造成影响，因为右节点已经在上层进行了记录
            pre.setRight(null);
            //当前节点右节点置为父节点
            root.setRight(pre);
        }
    }

    public TreeNode upsideDownBinaryTree1(TreeNode root) {
        TreeNode right = null, father = null;
        while (root != null) {
            //为了继续遍历，先记录下原来的左子节点防止丢失
            TreeNode left = root.getLeft();
            //当前节点的左子节点更新为父节点的右子节点
            root.setLeft(right);
            //记录下当前节点的右子节点
            right = root.getRight();
            //当前节点的右子节点更新为原父节点
            root.setRight(father);
            //记录下当前节点作为下一个待遍历节点的父节点（新右子节点）
            father = root;
            root = left;
        }
        //最终root=null,father指向的是最终的根节点
        return father;
    }
}

