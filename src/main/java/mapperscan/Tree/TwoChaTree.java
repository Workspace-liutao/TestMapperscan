package mapperscan.Tree;

import java.util.*;

public class TwoChaTree {
    public class Node {
        public Node(Integer data) {
            this.data = data;
        }

        public Integer data;
        Node left;
        Node right;

        public Integer getData() {
            return data;
        }
    }

    public Node createBinaryTree(LinkedList<Integer> inputList) {
        Node node = null;
        if (inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (null != data) {
            node = new Node(data);
            node.left = createBinaryTree(inputList);
            node.right = createBinaryTree(inputList);
        }
        return node;
    }

    public void preBinary(Node node) {
        if (node != null) {
            System.out.println(node.getData());
            preBinary(node.left);
            preBinary(node.right);
        } else {
            return;
        }
    }

    public void mindBinary(Node node) {
        if (node != null) {
            mindBinary(node.left);
            System.out.println(node.getData());
            mindBinary(node.right);
        } else {
            return;
        }
    }

    public void afterBinary(Node node) {
        if (node != null) {
            afterBinary(node.left);
            afterBinary(node.right);
            System.out.println(node.getData());
        } else {
            return;
        }
    }

    public void preBinaryUseStack(Node node) {
        Stack<Node> stack = new Stack<>();
        while (null != node || !stack.isEmpty()) {
            while (null != node) {
                System.out.println(node.getData());
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    /**
     * 先将左子树全部压入栈中
     *
     * @param node
     */
    public void mindBinaryUseStack(Node node) {
        Stack<Node> stack = new Stack<>();
        while (null != node || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.println(node.getData());
                node = node.right;
            }
        }
    }

    public void postBinary(Node node) {
        Stack<Node> stack = new Stack<>();
        Node prev = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                if (node.right == null || node.right == prev) {
                    System.out.println(node.getData());
                    prev = node;
                    node = null;
                } else {
                    stack.push(node);
                    node = node.right;
                }
            }
        }
    }

    public List<String> bBinaryTreePath(Node node) {
        List<String> paths = new ArrayList<>();
        if (node == null) {
            return paths;
        }
        Queue<Node> nodes = new LinkedList<>();
        Queue<String> nodePaths = new LinkedList<>();
        nodes.offer(node);
        nodePaths.offer(String.valueOf(node.getData()));
        while (!nodes.isEmpty()) {
            node = nodes.poll();
            String nodePath = nodePaths.poll();
            if (node.left == null && node.right == null) {
                paths.add(nodePath);
            }
            if (node.left != null) {
                nodes.offer(node.left);
                nodePaths.offer(nodePath + "->" + String.valueOf(node.left.getData()));
            }
            if (node.right != null) {
                nodes.offer(node.right);
                nodePaths.offer(nodePath + "->" + String.valueOf(node.right.getData()));
            }
        }
        return paths;
    }

    public List<String> dBinaryTreePath(Node node) {
        List<String> paths = new ArrayList<>();
        constructPaths(node, "", paths);
        return paths;
    }

    public void constructPaths(Node node, String path, List paths) {
        if (node != null) {
            StringBuilder stb = new StringBuilder(path);
            stb.append(String.valueOf(node.getData()));
            if (node.left == null && node.right == null) {
                paths.add(stb.toString());
            } else {
                stb.append("->");
                constructPaths(node.left, stb.toString(), paths);
                constructPaths(node.right, stb.toString(), paths);
            }
        }
    }

    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) > height(node.right) ? height(node.left) + 1 : height(node.right) + 1;
    }


        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList();
            for (int i = 0; i < nums.length; i++) {
                int total = 0 - nums[i];
                if(i>0 && nums[i]==nums[i-1]){
                    continue;
                }
                List<Integer> list = new ArrayList();
                list.add(nums[i]);
                for (int m = i + 1, n = nums.length - 1; m < nums.length; m++) {
                    if(m>0 && nums[m]==nums[m-1]){
                        continue;
                    }
                    while (nums[m] + nums[n] > total) {
                        n--;
                    }
                    if (m == n) {
                        break;
                    }
                    if (total == nums[m] + nums[n]) {
                        list.add(nums[m]);
                        list.add(nums[m]);
                        result.add(list);
                    }
                }
            }
            return result;
        }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>  maps= new HashMap();
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            int temp =target-nums[i];
            if(maps.containsKey(temp)){
                result[0]=i;
                result[1]=maps.get(temp);
                break;
            }
            maps.put((nums[i]),i);
        }
        return  result;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TwoChaTree twoChaTree = new TwoChaTree();
        Node node = twoChaTree.createBinaryTree(linkedList);
        System.out.println("前序遍历");
        twoChaTree.preBinary(node);
        System.out.println("前序遍历1");
        twoChaTree.preBinaryUseStack(node);
        System.out.println("中序遍历");
        twoChaTree.mindBinary(node);
        System.out.println("中序遍历1");
        twoChaTree.mindBinaryUseStack(node);
        System.out.println("后遍历");
        twoChaTree.afterBinary(node);
        System.out.println("后遍历1");
        twoChaTree.postBinary(node);
        twoChaTree.bBinaryTreePath(node);
        twoChaTree.dBinaryTreePath(node);
        System.out.println(twoChaTree.height(node));
        System.out.println(0 - 1);
        int [] nums=new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> list = twoChaTree.threeSum(nums);
    }
}
