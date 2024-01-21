package algorithms_lab.graphs;
import java.util.*;
public class matrix_rep {
    public static void make_edge(int[][] matrix,int source,int destination,int type)
    {
        if(type==1)
            matrix[destination-1][source-1] = 1;
        matrix[source-1][destination-1] = 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the type of graph [Directed/undirected](0/1) : ");
        int type = sc.nextInt();
        System.out.print("Enter the number of vertices : ");
        int vertices = sc.nextInt();
        int[][] matrix = new int[vertices][vertices];
        System.out.print("Enter the number of edges : ");
        int edges = sc.nextInt();
        for(int i = 0 ;i<edges;i++)
        {
            System.out.print("Enter the source vertex for edge "+(i+1)+" : ");
            int source = sc.nextInt();
            System.out.print("Enter the Destination vertex for edge "+(i+1)+" : ");
            int destination = sc.nextInt();
            make_edge(matrix,source,destination,type);
        }
        System.out.println("The matrix representation is : ");
        for(int i = 0;i<vertices;i++)
        {
            for(int j =0;j<vertices ;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}
