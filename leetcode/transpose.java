package leetcode;

public class transpose {
    public static int[][] transpose_(int[][] matrix)
    {
        for(int i =0;i<matrix.length;i++)
    {
        for(int j=i+1;j<matrix[0].length;j++)
        {
            if(i!=j)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    return matrix;
    }
    public static void main(String[] args) {
        int[][] arr = {
            {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}
        };
        arr = transpose_(arr);
        for(int i =0;i<arr.length;i++)
        {
            for(int j =0;j<arr[0].length;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
