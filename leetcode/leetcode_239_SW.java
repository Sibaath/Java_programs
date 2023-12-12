package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode_239_SW {
    public static int[] max_sliding_window(int[] nums, int k) {
        Deque<Integer> l1 = new ArrayDeque<>();
        int j = 0;
        int[] arr = new int[nums.length-k+1];
        if(nums.length==1 && k==1)
        {
            arr[0] = nums[0];
            return arr;
        }

        for(int i = 0 ;i<k;i++)
        {
            while(!(l1.isEmpty()) && nums[l1.peekLast()]<nums[i])
            l1.removeLast();
            l1.addLast(i);
        } 
        arr[j++] = nums[l1.peekFirst()];
        for(int i = k; i<nums.length;i++)
        {
            if(i-k == l1.peekFirst())
            l1.removeFirst();

            while(!(l1.isEmpty()) && nums[l1.peekLast()]<nums[i])
            l1.removeLast();
            l1.addLast(i);

           arr[j++] = nums[l1.peekFirst()];
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int[] l1 =max_sliding_window(arr, 3);
        for(int i =0;i<l1.length;i++)
        {
            System.out.println(l1[i]);
        }
    }
}
