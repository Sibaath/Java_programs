package leetcode;

public class leetcode_remove_nth_node {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
        return null;
        ListNode dummy = new ListNode(0,head);
        ListNode ptr1=dummy,ptr2=dummy;
        int count = 0;
        while(count<n+1)
        {
            count++;
            ptr2= ptr2.next;
        }
        while(ptr2!=null)
        {
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        if(ptr1!=null &&ptr1.next!=null)
        ptr1.next=ptr1.next.next;
        return dummy.next;
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
        head = removeNthFromEnd(head, 2);
        ListNode temp = head;
        while(temp!=null)
        {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
