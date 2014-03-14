/*You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        Output: 7 -> 0 -> 8
        */
/**
 * Created by szhu on 2/28/2014.
 */
public class AddTwoNumbers {

    public static void main(String []args){
        ListNode [] p = new ListNode[4];
        ListNode [] q= new ListNode[6];
        p[0] = new ListNode(0);
        p[1] = new ListNode(1);
        p[2] = new ListNode(2);
        p[3] = new ListNode(3);

        q[0] = new ListNode(9);
        q[1] = new ListNode(9);
        q[2] = new ListNode(2);
        q[3] = new ListNode(7);
        q[4] = new ListNode(9);
        q[5] = new ListNode(9);
        for(int i = 0; i < p.length - 1; i++)
            p[i].next = p[i+1];
        for(int j = 0; j < q.length - 1; j++)
            q[j].next = q[j+1];
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.addTwoNumbers(p[0], q[0]);
        ListNode head = p[0];
        while(head != null){
            System.out.print(head.val);
            System.out.print("  ");
            head = head.next;
        }
        System.out.println("");
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2, p_pre = p, q_pre = q;
        int carry = 0;

        while(p != null || q != null){
            if(p == null){
                p = new ListNode(0);
                p.next = null;
                p_pre.next = p;
            }else if(q == null){
                q = new ListNode(0);
                q.next = null;
                q_pre.next = q;
            }
            p.val = p.val + q.val + carry;
            carry = p.val/10;
            p.val %= 10;
            p_pre = p;
            q_pre = q;
            p = p.next;
            q = q.next;
        }
        if(carry != 0){
            p = new ListNode(carry);
            //easy to forget
            p_pre.next = p;
        }
        return l1;
    }
}
