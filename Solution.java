class Solution {
    public int removeDuplicates(int[] nums) {
        int  j =0,count=0;
        if(nums.length > 1)
        {
        for(int i =0 ; i<nums.length ; i++)
        {
            j = i+1;
            while(nums[i] == nums[j])    
            {
                j++;
                count++;
            }        
            nums[i+1] = nums[j];
            i = j-1;            
        }
        }
        return nums.length-count;
    }
    public static void main(String[] args) {
        int[] a = {1,1,2,2,3,3,4,5};
    }
    
}