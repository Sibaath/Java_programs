package lab_6_01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

class kruskal
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> edges_list = new ArrayList<Integer>();
        System.out.print("Enter the number of vertices : ");
        int vertices = sc.nextInt();
        System.out.print("Enter the number of edges : ");
        int edges = sc.nextInt();
        for(int i =0;i<edges;i++)
        {
            System.out.print("Enter the source of edge "+(i+1)+" :");
            int a = sc.nextInt();
            System.out.print("Enter the enter of edge "+(i+1)+" :");
            int b = sc.nextInt();
            int weight = sc.nextInt();
            edges_list.add(a,b,weight);      
        }
        Collections.sort(edges_list,Comparator.comparingInt(edge -> edge.get(2)));
    }
}

























































//  {

//     public static void make_edge(ArrayList<ArrayList<Integer>> vertex_list,int src,int destination)
//     {
//         vertex_list.get(src-1).add(destination);
//     }
   
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter the number of vertices : ");
//         int vertices = sc.nextInt();
//         ArrayList<ArrayList<Integer>> adjacency_list = new ArrayList<>();
//         for(int i = 0;i<vertices;i++)
//         {
//             adjacency_list.add(new ArrayList<>());
//             all_vertices.put(i+1,new int[2]);
//         }
//         System.out.print("Enter the number of edges : ");
//         int edges = sc.nextInt();
//         visited_edges = new int[vertices][vertices];
//         for(int i = 0 ;i<edges;i++)
//         {
//             System.out.print("Enter the source vertex for edge "+(i+1)+" : ");
//             int src = sc.nextInt();
//             System.out.print("Enter the Destination vertex for edge "+(i+1)+" : ");
//             int destination = sc.nextInt();
//             make_edge(adjacency_list,src, destination);
//         }
//         for(int i =0;i<vertices;i++)
//         {
//             if(visited[i]==0)
//             {
//                 depth_first_search(i, adjacency_list,all_vertices);
//                 System.out.println();
//             }
//         }

//         for(int i = 0;i<vertices;i++)
//         {
//             for(int j =0;j<vertices;j++)
//             {
//                 if(visited_edges[i][j] == 1)
//                 {
//                     if(i==j)
//                     {
//                         System.out.println("There is a cycle");
//                         System.exit(0);
//                     }
//                     else if(all_vertices.get(i+1)[0]<=all_vertices.get(j+1)[0] && all_vertices.get(i+1)[1]<=all_vertices.get(j+1)[1])
//                     {
//                         System.out.println("There is a cycle");
//                         System.exit(0);
//                     }
//                 }
//             }
//         }
//         System.out.println("There is no cycle");
//         sc.close();
//     }
// }
