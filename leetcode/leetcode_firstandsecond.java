public class leetcode_firstandsecond {

        public static int[] searchRange(int[] nums, int target) {
            int left = 0,right = nums.length-1;
            int[] res = new int[2];
            res[0] = -1;
            res[1] = -1;
            while(left<=right)
            {
                int mid = (left+right)/2;
                if(nums[mid]==target)
                {
                    res[0] = mid;
                    right = mid - 1;
                }
                else if(nums[mid]>target)
                right = mid-1;
                
                else
                left = mid+1;
            }
            right = 0;
            left=nums.length-1;
             while(left<=right)
            {
                int mid = (left+right)/2;
                if(nums[mid]==target)
                {
                    res[1] = mid;
                    left = mid+1;
                }
                else if(nums[mid]>target)
                right = mid-1;
                
                else
                left = mid+1;
            }
            return res;
        }
        public static void main(String[] args) {
            int[] arr ={5,7,7,8,8,10};
            int[] ar = searchRange(arr, 8);
            System.out.println(ar[0]);
            System.out.println(ar[1]);
        }
        
}
