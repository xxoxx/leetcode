/**
 * Created by szhu on 2014-03-03.
 */
public class InsertSort {
    public static void main(String []args){
        ListNode [] listNodes = {new ListNode(2), new ListNode(1), new ListNode(0)};
        listNodes[0].next = listNodes[1];
        listNodes[1].next = listNodes[2];
        InsertSort insertSort = new InsertSort();
        insertSort.insertionSortList(listNodes[0]);
    }
    public ListNode insertionSortList(ListNode  head) {
        ListNode p = head, q, r;
        if(head == null)
            return head;
        q = p.next;
        while(q != null){
            if(q.val < p.val){
                p.next = q.next;
                if(head.val >= q.val){
                    q.next = head;
                    head = q;
                }else{
                    r = head;
                    while(r.val < q.val && r.next.val < q.val)
                        r = r.next;
                    q.next = r.next;
                    r.next = q;
                }
            }else{
                p = q;
            }
            q = p.next;
        }
        return head;
    }
}
