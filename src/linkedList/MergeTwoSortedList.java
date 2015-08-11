package linkedList;

/**
 * Created by shuailu on 8/10/15.
 */
public class MergeTwoSortedList {

    public static LinkedListNode merge(LinkedListNode list1, LinkedListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        LinkedListNode head = null;
        LinkedListNode point = null;
        while (list1 != null && list2 != null) {
            LinkedListNode smallerNode;
            boolean list1Smaller;
            list1Smaller = list1.val <= list2.val;
            smallerNode = list1Smaller ? list1 : list2;
            if (head == null) {
                head = new LinkedListNode(smallerNode.val);
                point = head;
            } else {
                point.next = new LinkedListNode(smallerNode.val);
                point = point.next;
            }
            if (list1Smaller) {
                list1 = list1.next;
            } else {
                list2 = list2.next;
            }
        }
        while (list1 != null) {
            if (head == null) {
                head = new LinkedListNode(list1.val);
                point = head;
            } else {
                point.next = new LinkedListNode(list1.val);
                point = point.next;
            }
            list1 = list1.next;
        }

        while (list2 != null) {
            if (head == null) {
                head = new LinkedListNode(list1.val);
                point = head;
            } else {
                point.next = new LinkedListNode(list2.val);
                point = point.next;
            }
            list2 = list2.next;
        }

        return head;
    }

    //appendList right list to left one
    //assert left list is not null
    public static void appendList(LinkedListNode left, LinkedListNode right) {
        while (right != null) {
            left.next = new LinkedListNode(right.val);
            left = left.next;
            right = right.next;
        }
    }


    public static void main (String[] args) {
        LinkedListNode list1 = new LinkedListNode(1);
        list1.next = new LinkedListNode(3);
        list1.next.next = new LinkedListNode(5);
        list1.next.next.next = new LinkedListNode(7);

        LinkedListNode list2 = new LinkedListNode(2);
        list2.next = new LinkedListNode(100);

        LinkedListNode.print(merge(list1, null));
    }
}
