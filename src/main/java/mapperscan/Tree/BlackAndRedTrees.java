package mapperscan.Tree;

public class BlackAndRedTrees {

    public Node insert(Node node, int data) {
        if (null == node) {
            node = new Node(data);
        } else {
            if (data > node.getData()) {
                node.left = insert(node.right, data);
                //插入
            } else if (data < node.getData()) {
                node.right = insert(node.right, data);
            } else {
                System.out.println("AVL树中有重复节点");
            }
        }
        return node;
    }

    //左左局面旋转
    public Node leftAndLeftRotation(Node node) {
        Node nodeLeft = node.left;
        node.left = nodeLeft.right;
        nodeLeft.right = node;
        node.setHeight(height(node));
        nodeLeft.setHeight(height(nodeLeft));
        return node;
    }

    // 右右局面旋转
    public Node rightAndRightRotation(Node node) {
        Node nodeRight = node.getRight();
        node.right = nodeRight.left;
        nodeRight.left = node;
        node.setHeight(height(node));
        nodeRight.setHeight(nodeRight.height);
        return node;
    }

    // 右左局面旋转
    public Node rightAndLeftRotation(Node node) {
        node.right = rightAndRightRotation(node.right);
        return leftAndLeftRotation(node);
    }

    // 左右局面反转
    public Node leftAndRight(Node node) {
        node.left = leftAndLeftRotation(node.left);
        return rightAndRightRotation(node);
    }

    public int height(Node node) {
        if (null == node) {
            return 0;
        }
        return height(node.right) > height(node.left) ? height(node.right) + 1 : height(node.left) + 1;
    }

    public class Node {
        int height;
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
