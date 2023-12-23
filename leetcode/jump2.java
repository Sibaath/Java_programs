package leetcode;

public class jump2{
    public static int jump(int[] nums) {
        if(nums.length==1)
        return 0;
        int a=0,b=1,count = 0,farthest=0;
        if(nums.length==2)
        return 1;
        while(a<nums.length)
        {
            farthest = a+nums[a];
            if(b!=1)
            b+=1;
            for(int j = a+1 ;j<b;j++)
            {
                if(farthest<j+nums[j])
                farthest = j+nums[j];
            }
            count++;
            if(farthest >= nums.length-1)
            return count;
            if(a==0)
            a+=1;
            else
            a = b+1;
            b=farthest;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        System.out.println(jump(arr));
    }
}
