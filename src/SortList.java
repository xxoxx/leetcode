import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
    public static void main(String []args){
        ListNode [] listnodes = {new ListNode(6), new ListNode(5),new ListNode(6), new ListNode(9),
                 new ListNode(4),new ListNode(8),new ListNode(7), new ListNode(6), new ListNode(1),
                 new ListNode(3),new ListNode(9),new ListNode(8), new ListNode(4), new ListNode(1),
                new ListNode(12),new ListNode(13),new ListNode(12), new ListNode(14), new ListNode(11),};
//        ListNode [] listnodes = {new ListNode(6), new ListNode(2),new ListNode(8), new ListNode(3)};
        for(int i = 0; i < listnodes.length - 1; i++)
            listnodes[i].next = listnodes[i + 1];
        SortList sortList = new SortList();
        ListNode head = sortList.sortList(listnodes[0]);
        while(head != null){
            System.out.print(head.val);
            System.out.print("  ");
            head = head.next;
        }
        System.out.println("  ");
    }
    public ListNode sortList(ListNode head) {
        ListNode pivot = head;
        head = sortList1(head, null);
        return head;
    }
    public ListNode sortList1(ListNode head, ListNode tail){
        ListNode pivot = head,  forward,pre;
        if(head == tail || head.next == tail)
            return head;
        pre = head;
        forward = head.next;
        while(forward != tail){
            if(forward.val <= pivot.val){
                pre.next = forward.next;
                forward.next = head;
                head = forward;
            }else{
                pre = pre.next;
            }
            forward = pre.next;
        }
        head = sortList1(head, pivot);
        pivot.next = sortList1(pivot.next, tail);
        return head;
    }
}
