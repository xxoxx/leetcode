import java.util.ArrayList;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReorderList {

    public static void main(String []args){
        ListNode [] listNodes = {new ListNode(1), new ListNode(2),new ListNode(3),new ListNode(4),new ListNode(5), new ListNode(6)};
        for(int i = 0; i < listNodes.length - 1; i++)
            listNodes[i].next = listNodes[i+1];
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(null);
/*        ArrayList<ListNode> arrayList = new ArrayList<ListNode>();
        ListNode p = listNodes[0];
        while(p != null){
            arrayList.add(p);
            p = p.next;
        }*/
        System.out.println("Over");
    }

    public void reorderList(ListNode head){

        ArrayList arrayList = new ArrayList();
        ListNode p = head, pre_q = head, q = null;
        if(head == null || head.next == null)
            return;
        while(p != null){
            arrayList.add(p);
            p = p.next;
        }
        p = head;
        int movePosition = arrayList.size() - 1;
        q = (ListNode) arrayList.get(movePosition);
        pre_q = (ListNode) arrayList.get(movePosition - 1);
        while(p != q && q != p.next){
            pre_q.next = null;
            q.next = p.next;
            p.next = q;
            p = p.next.next;
            movePosition--;
            q = (ListNode) arrayList.get(movePosition);
            pre_q = (ListNode) arrayList.get(movePosition - 1);
        }
    }
}
