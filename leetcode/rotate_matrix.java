package leetcode;

public class rotate_matrix {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i =0;i<(n+1)/2;i++)
        {
            for(int j = i ; j<n-(i+1);j++)
            {
                int temp = matrix[n-(j+1)][i];
                matrix[n-(j+1)][i] = matrix[n-(i+1)][n-(j+1)];
                matrix[n-(i+1)][n-(j+1)] = matrix[j][n-(i+1)];
                matrix[j][n-(i+1)] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(arr);
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
