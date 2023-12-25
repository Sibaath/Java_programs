package leetcode;
class max_water {
    public static int maxArea(int[] height) {
        if(height.length == 2)
        return height[0]>height[1]?height[0]:height[1];
 
        int max1 = height[0];
        int max2 = height[0];
        int ind1 = 0 ;
        int ind2 = 0;

        for(int i = 1 ;i<height.length;i++)
        {
            if(height[i]>max2)
            {
                max1 = max2;
                ind1 = ind2;
                max2 = height[i];
                ind2 = i;
            }
            else if(height[i]!=max2 && height[i]>max1)
            {
                max1 = height[i];
                ind1 = i;
            }

        }

        return max1*(Math.abs(ind1-ind2));
        
    }
    public static void main(String[] args) {
        int[] height = {4,3,2,1,4};
        System.out.println(maxArea(height));
    }
}