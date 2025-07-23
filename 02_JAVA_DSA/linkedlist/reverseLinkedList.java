package linkedlist;

public class reverseLinkedList {
    public linkedList.ListNode reverseList(linkedList.ListNode head) {
        linkedList.ListNode prev = null;
        while (head != null) {
            linkedList.ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

}
