package leetcode;

class ListNode
{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class reverse {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)
        return null;
        else if (head.next==null)
        return head;
        ListNode temp = head,prev =null;
        while(temp!=null)
        {
            int count = 1;
            ListNode end = temp;
            while(count<k)
            {
                if(end==null)
                {
                    if(prev!=null)
                    prev.next = temp;
                    return head;
                }
                count++;
                end = end.next;
            }
            if(end==null)
            {
                if(prev!=null)
                prev.next = temp;
                return head;
            }
            ListNode temp1 = end.next;
            end.next = null;
            if(temp==head)
            head = reverseList(head);
            else
                prev.next = reverseList(temp);
            prev = temp;
            temp = temp1;
        }
        return head;
    }
    static ListNode reverseList(ListNode curr)
    {
        ListNode prev = null,next=null;
        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static void main(String[] args) {
        ListNode obj1 = new ListNode();
        ListNode obj2 = new ListNode();
        ListNode obj3 = new ListNode();
        ListNode obj4 = new ListNode();
        ListNode obj5 = new ListNode();
        obj1.val = 1;
        obj1.next = obj2;
        obj2.val = 2;
        obj2.next = obj3;
        obj3.val = 3;
        obj3.next = obj4;
        obj4.val = 4;
        obj4.next = obj5;
        obj5.val = 5;
        obj5.next = null;
        ListNode head = obj1;
        //head = reverseList(head);
        ListNode temp = head;
        while(temp!=null)
        {
            System.out.println(temp.val);
            temp = temp.next;
        }
        System.out.println();
        temp = reverseKGroup(head, 2);
        while(temp!=null)
        {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
