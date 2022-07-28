package mapperscan.Tree;

public class NodeClass {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(8);
//        Node node3 = new Node(3);
//        Node node4 = new Node(6);
//        Node node5 = new Node(5);
//        Node node6 = new Node(4);
//        Node node7 = new Node(7);
//        Node node8 = new Node(2);
        node1.next = node2;
        node2=node1;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = node8;


        order(node1);
        countAndSay(6);

    }

    //奇数位升序，偶数位置降序的链表
    public static Node order(Node node1) {
        //1.先将数组按照奇偶分组，
        Node[] nodes = NodeClass.resort(node1);
        //2.偶数位反转
        nodes[0] = NodeClass.reset(nodes[0]);
        //3.排序
        Node result = NodeClass.reorder(nodes[0], nodes[1]);
        return result;
    }

    public static Node[] resort(Node root) {
        Node[] nodes = new Node[2];
        Node p = root;
        Node q = root.next;
        Node cur = q;
        while (q != null && q.next != null) {
            p.next = q.next;
            p = q.next;
            q.next = p.next;
            q = p.next;
        }
        p.next = null;
        nodes[0] = cur;
        nodes[1] = root;
        return nodes;
    }

    public static Node reset(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHard = null;
        Node temp = null;
        while (head != null) {
            temp = head;
            head = head.next;
            temp.next = newHard;
            newHard = temp;
        }
        return newHard;
    }

    public static Node reorder(Node node1, Node node2) {
        Node cur = new Node(-1);
        Node p = cur;
        while (node1 != null && node2 != null) {
            if (node1.getData() >= node2.getData()) {
                p.next = node2;
                node2 = node2.next;
            } else {
                p.next = node1;
                node1 = node1.next;
            }
            p = p.next;
        }
        p.next = node1 == null ? node2 : node1;
        return cur.next;
    }


    public static String countAndSay(int n) {
        if (n == 1) return "1";
        else {
            String lastStr = countAndSay(n - 1); // 1 2 1 1
            StringBuilder ans = new StringBuilder();
            int i = 0, j = 1, len = lastStr.length();
            while (j < len) {
                if (lastStr.charAt(i) != lastStr.charAt(j)) {
                    ans.append(j - i).append(lastStr.charAt(i));
                    i = j;
                }
                j++;
            }
            ans.append(j - i).append(lastStr.charAt(i));
            return ans.toString();
        }
    }

}
