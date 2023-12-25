package leetcode;

public class smooth {
    public static int[][] imageSmoother(int[][] img) {
       // int f1 = 0 , f2 = 0 , f3 = 0 , f4 = 0;
        int[][] arr = new int[img.length][img[0].length];
        for(int i =0;i<img.length;i++)
        {
            // if(i+1>=img.length)
            // f1 = 1;
            // if(i-1<0)
            // f2 = 1;
            for(int j =0;j<img[0].length;j++)
            {
                int sum = 0,count =9;
                // if(j+1>=img[0].length)
                // f3 = 1;
                // if(j-1<0)
                // f4 = 1;
                sum+=img[i][j];
                try
                {
                    sum+=img[i][j+1];
                }
                catch(Exception e)
                {
                    count--;
                }
                try
                {
                    sum+=img[i][j-1];
                }
                catch(Exception e)
                {
                    count--;
                }
                try
                {
                    sum+=img[i+1][j];
                }
                catch(Exception e)
                {
                    count--;
                }
                try
                {
                    sum+=img[i-1][j];
                }
                catch(Exception e)
                {
                    count--;
                }
                try
                {
                    sum+=img[i+1][j+1];
                }
                catch(Exception e)
                {
                    count--;
                }
                try
                {
                    sum+=img[i+1][j-1];
                }
                catch(Exception e)
                {
                    count--;
                }
                try
                {
                    sum+=img[i-1][j+1];
                }
                catch(Exception e)
                {
                    count--;
                }
                try
                {
                    sum+=img[i-1][j-1];
                }
                catch(Exception e)
                {
                    count--;
                }
                arr[i][j] = sum/count;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[][] arr = {
            {1,1,1},{1,0,1},{1,1,1}
        };
        arr = imageSmoother(arr);
        for(int i =0;i>arr.length;i++)
        {
            for(int j =0;j<arr[0].length;i++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
