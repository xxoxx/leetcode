/**
 * Created by szhu on 2/10/2014.
 */


public class LinkedListCycle {
    public static void main(String args[]){
        ListNode listNode = new ListNode(1);
        listNode.next = listNode;

        LinkedListCycle linkedListCycle = new LinkedListCycle();
        //linkedListCycle.hasCycle(listNode);
        System.out.println(linkedListCycle.hasCycle(listNode));
    }
    public boolean hasCycle(ListNode head) {
        ListNode p1, p2;
        p1 = p2 = head;
        while(p2 != null){
            p1 = p1.next;
            if(p2.next != null)
                p2 = (p2.next).next;
            else
                p2 = p2.next;
            if(p1 == p2)
                break;
        }
        if(p2 == null)
            return false;
        else
            return true;
    }
}
