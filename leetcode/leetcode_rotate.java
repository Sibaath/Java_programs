package leetcode;

public class leetcode_rotate {
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null)
        return head;
        if(k==0)
        return head;
        // if(k==1 && head.next!=null)
        // {
        //     ListNode temp = head.next;
        //     head.next = null;
        //     temp.next = head;
        //     head = temp;
        //     return head;
        // }
        else
        {
            ListNode temp = head;
            int len = 1;
            for(temp=head;temp.next!=null;temp=temp.next)
            len++;                   
            temp.next=head;
            int count = 0;
            while(count!=len-(k%len))
            {
                temp = temp.next;
                count++;
            }
            head = temp.next;
            temp.next = null;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode obj1 = new ListNode();
        ListNode obj2 = new ListNode();
        ListNode obj3 = new ListNode();
        // ListNode obj4 = new ListNode();
        // ListNode obj5 = new ListNode();
        obj1.val = 1;
        obj1.next = obj2;
        obj2.val = 2;
        obj2.next = obj3;
        obj3.val = 3;
        obj3.next = null;
        // obj4.val = 4;
        // obj4.next = obj5;
        // obj5.val = 5;
        // obj5.next = null;
        ListNode head = obj1;
        head = rotateRight(head, 1);
        ListNode temp = head;
        while(temp!=null)
        {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
