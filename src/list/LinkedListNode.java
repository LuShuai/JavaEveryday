package list;

public class LinkedListNode {

    int val;
    LinkedListNode next;

    public LinkedListNode(int i) {
        val = i;
    }


    public static void print(LinkedListNode n) {
        while (n != null) {
            System.out.print("-->" + n.val);
            n = n.next;
        }
        System.out.println();
    }

    public static LinkedListNode gen() {
        LinkedListNode n = new LinkedListNode(3);
        n.next = new LinkedListNode(45);
        n.next.next = new LinkedListNode(2);
        n.next.next.next = new LinkedListNode(8);
        n.next.next.next = new LinkedListNode(4);
        n.next.next.next.next = new LinkedListNode(2);
        n.next.next.next.next.next = new LinkedListNode(-10);
        return n;
    }

}
