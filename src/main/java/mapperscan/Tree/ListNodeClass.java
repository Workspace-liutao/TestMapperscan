package mapperscan.Tree;
public class ListNodeClass {
    public static void main(String[] args) {
        ListNodeClass  listNodeClass = new ListNodeClass();
        Node  node1= new Node(1);
        Node  node2= new Node(2);
        Node  node3= new Node(3);
        Node  node4= new Node(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        listNodeClass.reorderList(node1);
    }

        public void reorderList(Node head) {
            //1.寻找链表中间位置
            Node  mideNode= findMid(head);
            Node head1 = head;
            //2.反转右边的链表
            Node next =mideNode.getNext();
            mideNode.next=null;
            Node  head2 =reverset(next);
            //3.合并两个链表
            merge(head1,head2);
        }
        public Node  findMid(Node  head){
            Node  p=head;
            Node  q=head;
            while(q!=null && q.next!=null){
                p=p.next;
                q=q.next.next;
            }
            return p;
        }

        public Node  reverset(Node  head){
            Node  cur=null;
//            Node  pre=head;
            while(head!=null){
                Node   temp =head.next;
                head.next=cur;
                cur=head;
                head=temp;
            }
            return cur;
        }

        public void   merge(Node  head1, Node head2){
            Node  p=head1;
            Node  q=head2;
            while(head1!=null && head2!=null){
                p=p.next;
                head1.next=head2;
                head1=p;
                q=q.next;
                head2.next=head1;
                head2=q;
            }
        }


    }

