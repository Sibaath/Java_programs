public class matrix {
    
        public static void setZeroes(int[][] matrix) {
            int[][] copy = new int[matrix.length][matrix[1].length];
            for(int i=0;i<matrix.length;i++)
            {
                for(int j=0;j<matrix[1].length;j++)
                {
                    copy[i][j] = matrix[i][j];
                }
            }
            for(int i =0;i<matrix.length;i++)
            {
                for(int j=0;j<matrix[1].length;j++)
                {
                    if(matrix[i][j]==0)
                    {
                             for(int m =0 ;m<matrix.length;m++)
                             {
                             for(int n = 0 ; n < matrix[1].length;n++)
                                    {
                    if(m==i || n == j)
                    copy[m][n]=0;
                }
            }   
                            
                    }
                 
                }
               
            }
            for (int i = 0; i < copy.length; i++) {
                {
                    for (int j = 0; j < copy[1].length; j++) {
                        System.out.println(copy[i][j]);
                    }
                }
            }
        }
    
    
    public static void main(String[] args) {
        int[][] matrix1= {{1,1,1,},{1,0,1},{1,1,1}};
        matrix.setZeroes(matrix1);
    }
}
