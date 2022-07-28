package mapperscan.Tree;

import mapperscan.bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class InTreeAndPostTreeClass {
    public static void main(String[] args) {
        InTreeAndPostTreeClass inTreeAndPostTreeClass = new InTreeAndPostTreeClass();
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        inTreeAndPostTreeClass.buildTree(inorder, postorder);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> hashMap = new HashMap();
        int in = 0;
        int inlen = inorder.length;
        int post = 0;
        int postLen = postorder.length;
        for (int i = 0; i < inlen; i++) {
            hashMap.put(inorder[i], i);
        }
        return dfs(inorder, in, inlen - 1, postorder, post, postLen - 1, hashMap);
    }

    public TreeNode dfs(int[] inorder, int in, int inlen, int[] postorder, int post, int postLen, Map<Integer, Integer> hashMap) {
        if (in > inlen || post > postLen) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postLen]);
        int index = hashMap.get(postorder[postLen]);
        int left_len = index - in;
        root.setLeft(dfs(inorder, in, index - 1, postorder, post, post + left_len - 1, hashMap));
        root.setRight(dfs(inorder, index + 1, inlen, postorder, post + left_len, postLen - 1, hashMap));
        return root;
    }
}
