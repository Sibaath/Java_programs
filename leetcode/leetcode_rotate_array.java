package leetcode;

public class leetcode_rotate_array {
    public static void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];
        int j = 0;
        for(int i = nums.length-k ; i<nums.length;i++)
            arr[j++] = nums[i];
        for(int i =0;i<nums.length-k;i++)
            arr[j++] = nums[i];
        nums = arr;
        for(int i = 0 ; i < nums.length ; i++)
        System.out.println(nums[i]);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        rotate(arr, 3);
    }
}
