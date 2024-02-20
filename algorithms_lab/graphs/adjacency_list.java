package algorithms_lab.graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class adjacency_list
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the type of graph [Directed/undirected](0/1) : ");
        int type = sc.nextInt();
        System.out.print("Enter the number of vertices : ");
        int vertices = sc.nextInt();
        ArrayList<ArrayList<Integer>> vertex_list = new ArrayList<>();
        for(int i = 0;i<vertices;i++)
        vertex_list.add(new ArrayList<>());
        System.out.print("Enter the number of edges : ");
        int edges = sc.nextInt();
        for(int i = 0 ;i<edges;i++)
        {
            System.out.print("Enter the source vertex for edge "+(i+1)+" : ");
            int source = sc.nextInt();
            System.out.print("Enter the Destination vertex for edge "+(i+1)+" : ");
            int destination = sc.nextInt();
            make_edge(vertex_list, source, destination,type);
        }
        System.out.println("The matrix representation is : ");
        for(int i =0;i<vertices;i++)
        {
            System.out.print(i+1+"->");
            for(int j = 0 ;j<vertex_list.get(i).size();j++)
            {
                System.out.print(vertex_list.get(i).get(j)+"->");
            }
            System.out.println("nil");
            System.out.println();
        }
        sc.close();
    }
}
