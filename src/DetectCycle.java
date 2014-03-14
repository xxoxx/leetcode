/**
 * Created by szhu on 2/10/2014.
 */


/*Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?*/
public class DetectCycle {
    public static void  main(String []args){
        ListNode listNode = new ListNode(1);
        listNode.next = listNode;

        DetectCycle detectCycle = new DetectCycle();
        //linkedListCycle.hasCycle(listNode);
        System.out.println(detectCycle.detectCycleHead(listNode).toString());
    }
    public ListNode detectCycleHead(ListNode head) {
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
            return null;
        else
            p1 = head;
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;

    }

}
