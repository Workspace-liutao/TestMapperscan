package mapperscan.Tree;

import java.util.Stack;

public class SearchTrees<T extends Comparable> {

    TreeNode<T> root;

    public SearchTrees() {
        root = null;
    }

    public void insert(T date) {
        if (date == null) {
            return;
        } else {
            root = insert(date, root);
        }
    }

    public TreeNode insert(T date, TreeNode<T> p) {
        if (p == null) {
            p = new TreeNode(null, null, date);
        } else {
            T date1 = p.getDate();
            if (date1.compareTo(date) == 1) {
                p.leftNode = insert(date, p.getLeftNode());
            } else {
                p.rightNode = insert(date, p.getRightNode());
            }
        }
        return p;
    }


    public void PreOrder(TreeNode<T> p) {
        System.out.println(p.getDate());
        if (p.leftNode != null) {
            PreOrder(p.leftNode);
        }
        if (p.rightNode != null) {
            PreOrder(p.rightNode);
        }
    }

    public void midOrder(TreeNode<T> p) {
        if (p.leftNode != null) {
            midOrder(p.leftNode);
        }
        System.out.println(p.getDate());
        if (p.rightNode != null) {
            midOrder(p.rightNode);
        }
    }

    public void getLength(TreeNode<T> p) {
        int i = length(p);
        System.out.println("二叉树的层数" + i);
    }

    public int length(TreeNode<T> p) {
        if (p == null) {
            return 0;
        } else {
            int m = length(p.rightNode);
            int n = length(p.leftNode);
            return m >= n ? m + 1 : n + 1;
        }
    }

    public int getTotal(TreeNode<T> p) {
        if (p == null) {
            return 0;
        } else {
            return getTotal(p.leftNode) + getTotal(p.rightNode) + 1;
        }
    }


    public void afterOrder(TreeNode<T> p) {
        if (p.leftNode != null) {
            afterOrder(p.leftNode);
        }
        if (p.rightNode != null) {
            afterOrder(p.rightNode);
        }
        System.out.println(p.getDate());
    }

    public void afterOrderByStack(TreeNode<T> p) {

    }

    public void preOrderByStack(TreeNode<T> p) {
        Stack stack = new Stack<TreeNode<T>>();
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                System.out.println(p.getDate());
                stack.add(p);
                p = p.leftNode;
            } else {
                p = (TreeNode<T>) stack.pop();
                p = p.rightNode;
            }
        }
    }

    public void midOrderByStack(TreeNode<T> p) {
        Stack stack = new Stack<TreeNode<T>>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.add(p);
                p = p.leftNode;
            }
            if (!stack.isEmpty()) {
                p = (TreeNode<T>) stack.pop();
                System.out.println(p.getDate());
                p = p.rightNode;
            }
        }
    }

    public static void main(String[] args) {
        SearchTrees searchTrees = new SearchTrees();
        searchTrees.insert(3);
        searchTrees.insert(1);
        searchTrees.insert(2);
        searchTrees.insert(7);
        searchTrees.insert(5);
        System.out.println(searchTrees.toString());
        System.out.println("开始遍历层数");
        searchTrees.getLength(searchTrees.root);
        System.out.println("开始统计节点总数层数" + searchTrees.getTotal(searchTrees.root));
        System.out.println("开始先序遍历");
        searchTrees.PreOrder(searchTrees.root);
        System.out.println("开始非递归先序遍历");
        searchTrees.preOrderByStack(searchTrees.root);
        System.out.println("开始中序遍历");
        searchTrees.midOrder(searchTrees.root);
        System.out.println("开始非递归中序遍历");
        searchTrees.midOrderByStack(searchTrees.root);
        System.out.println("开始后序遍历");
        searchTrees.afterOrder(searchTrees.root);

        System.out.println("遍历结束");
    }

    public class TreeNode<T extends Comparable> {
        TreeNode<T> leftNode;
        TreeNode<T> rightNode;
        T date;

        public TreeNode(TreeNode<T> leftNode, TreeNode<T> rightNode, T date) {
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            this.date = date;
        }

        public TreeNode() {

        }

        public TreeNode<T> getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(TreeNode<T> leftNode) {
            this.leftNode = leftNode;
        }

        public TreeNode<T> getRightNode() {
            return rightNode;
        }

        public void setRightNode(TreeNode<T> rightNode) {
            this.rightNode = rightNode;
        }

        public T getDate() {
            return date;
        }

        public void setDate(T date) {
            this.date = date;
        }
    }
}
