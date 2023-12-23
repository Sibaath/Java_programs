package leetcode;

public class leetcode_reverse_list {
    public static int maxRotateFunction(int[] nums) {
        int max = Integer.MIN_VALUE,sum=0,val=0;
        for(int i = 0;i<nums.length;i++)
        {
            val+=(i*nums[i]);
            sum+=nums[i];
        }
        for(int i = 0;i<nums.length;i++)
        {
            if(val>max)
            max=val;
            val = val+sum-(nums.length*nums[nums.length-(i+1)]);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {4,3,2,6};
        System.out.println(maxRotateFunction(arr));
    }
}
