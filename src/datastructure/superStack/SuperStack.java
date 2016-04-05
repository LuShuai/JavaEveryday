package datastructure.superStack;

/**
 * Created by shuailu on 2/16/16.
 */
public class SuperStack {

    private int size;
    private Node head;
    private Node tail;

//    public SuperStack() {
//        size = 0;
//    }

    public void push(int val) {
        Node nodeToAdd = new Node(val);
        if (head == null) {
            head = nodeToAdd;
            tail = head;
        } else {
            nodeToAdd.next = head;
            head.pre = nodeToAdd;
            head = nodeToAdd;
        }
        ++size;
    }

    public int pop() {
        if (size < 0) {
            throw new RuntimeException();
        }
        Node nodeToReturn = head;
        if (size == 1) {
            head = tail = null;
        } else {
            head = nodeToReturn.next;
            nodeToReturn.next.pre = null;
        }
        --size;
        return nodeToReturn.val;
    }

    public void increase(int bottomOffset, int inc) {
        int count = 0;
        Node runner = tail;
        while (count < bottomOffset && runner != null) {
            runner.val += inc;
            runner = runner.pre;
            count++;
        }
    }

}
