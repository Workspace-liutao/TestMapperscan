package mapperscan.bean;

public class LinkedNode {
    int key;
    int value;
    LinkedNode pre;
    LinkedNode next;

    public LinkedNode(int value) {
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LinkedNode getPre() {
        return pre;
    }

    public void setPre(LinkedNode pre) {
        this.pre = pre;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }
}
