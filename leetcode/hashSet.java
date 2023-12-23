package leetcode;
import java.util.*;

public class hashSet {
        public static int firstMissingPositive(int[] nums) {
            int res = Integer.MAX_VALUE;
            HashSet<Integer> list = new HashSet<>();
            HashSet<Integer> list2 = new HashSet<Integer>();
            for(int i =0;i<nums.length;i++)
            list2.add(nums[i]);
            if(!(list2.contains(1)))
            return 1;
            for(int i =0;i<nums.length;i++)
            {
                if(nums[i]-1>0 && !(list2.contains(nums[i]-1)))
                list.add(nums[i]-1);
                if(nums[i]+1>0 && !(list2.contains(nums[i]+1)))
                list.add(nums[i]+1);
            }
            Iterator<Integer> it = list.iterator();
            while(it.hasNext())
            {
                int temp = it.next();
                if(temp<res)
                res=temp;
            }
            return res;
    }
    public static void main(String[] args) {
        int[] arr = {7,8,9,11,12};
        System.out.println(firstMissingPositive(arr));
    }

}
