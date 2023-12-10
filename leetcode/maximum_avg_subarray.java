package leetcode;
public class maximum_avg_subarray {
    public static void calculate(int[] nums,int k)
        {
            double currAvg = 0.0d;
        for (int i=0;i<k;i++)
        {
            currAvg+=(nums[i]/(double)k);
        }
        double maxAvg = currAvg;

        for(int i = k ; i < nums.length ; i++)
        {
            currAvg = currAvg-(nums[i-k]/(double)k)+(nums[i]/(double)k);
            if(currAvg > maxAvg)
            maxAvg = currAvg;
        }
        System.out.println(maxAvg);
        }
    public static void main(String[] args) {
        int[] arr = {1,12,-5,-6,50,3};
        calculate(arr,4);
    }
}
