package mapperscan.Tree;

public class LinkIsCycleClass {
    public static boolean isCycle(Node root) {
        Node p1 = root;
        Node p2 = root;
        while (p2 != null && p2.getNext() != null) {
           p1 = p1.getNext();
           p2= p2.getNext().getNext();
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(5);
        Node node4 = new Node(4);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node3);
        System.out.println(LinkIsCycleClass.isCycle(node1));
    }
}
