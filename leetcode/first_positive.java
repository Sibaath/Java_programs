package leetcode;

public class first_positive {
    public static int firstMissingPositive(int[] nums) {
        for(int i =0;i<nums.length;i++)
        {
            if(nums[i]<=0 || nums[i]>nums.length)
            nums[i]=nums.length+1;
        }
        for(int i = 0;i<nums.length;i++)
        {
            if(Math.abs(nums[i])<=nums.length && nums[Math.abs(nums[i])-1]>=1)
            nums[Math.abs(nums[i])-1] = -1*nums[Math.abs(nums[i])-1];
        }
        int i = 0;
        while(nums[i]<=-1)
        {
            i++;
        }
        return ++i;
        }
        public static void main(String[] args) {
            int[] arr = {1,1};
            System.out.println(firstMissingPositive(arr));
        }
}
