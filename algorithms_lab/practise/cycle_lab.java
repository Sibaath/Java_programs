package practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class cycle_lab_java {
    static int time = 0;
    static int[] visited;
    static int[][] visited_edges;
    public static void make_edge(ArrayList<ArrayList<Integer>> vertex_list,int src,int destination)
    {
        vertex_list.get(src-1).add(destination);
    }
    public static void depth_first_search(int sourceNode,ArrayList<ArrayList<Integer>> adjArrayList,HashMap<Integer,int[]> all_vertices)
    {
        time+=1;
        visited[sourceNode] = 1;
        all_vertices.get(sourceNode+1)[0] = time;
        System.out.print(sourceNode+1+" ");
        for(int n : adjArrayList.get(sourceNode))
        {
            if(visited[n-1]==0)
            {
                visited_edges[sourceNode][n-1] = 1;
                depth_first_search(n-1,adjArrayList,all_vertices);
            }
        }
        time+=1;
        all_vertices.get(sourceNode+1)[1] =time;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices : ");
        int vertices = sc.nextInt();
        visited = new int[vertices];
        HashMap<Integer,int[]> all_vertices = new HashMap<>();
        ArrayList<ArrayList<Integer>> adjacency_list = new ArrayList<>();
        for(int i = 0;i<vertices;i++)
        {
            adjacency_list.add(new ArrayList<>());
            all_vertices.put(i+1,new int[2]);
        }
        System.out.print("Enter the number of edges : ");
        int edges = sc.nextInt();
        visited_edges = new int[vertices][vertices];
        for(int i = 0 ;i<edges;i++)
        {
            System.out.print("Enter the source vertex for edge "+(i+1)+" : ");
            int src = sc.nextInt();
            System.out.print("Enter the Destination vertex for edge "+(i+1)+" : ");
            int destination = sc.nextInt();
            make_edge(adjacency_list,src, destination);
        }
        for(int i =0;i<vertices;i++)
        {
            if(visited[i]==0)
            {
                depth_first_search(i, adjacency_list,all_vertices);
                System.out.println();
            }
        }
        System.out.println("\nTheAdjacency List representation is : ");
        for(int i =0;i<vertices;i++)
        {
            System.out.print(i+1+"->");
            for(int j = 0 ;j<adjacency_list.get(i).size();j++)
            {
                System.out.print("("+all_vertices.get(adjacency_list.get(i).get(j))[0]+","+all_vertices.get(adjacency_list.get(i).get(j))[1]+")"+adjacency_list.get(i).get(j)+"->");
            }
            System.out.println("nil");
            System.out.println();
        }
        for(int i = 0;i<vertices;i++)
        {
            for(int j =0;j<vertices;j++)
            {
                System.out.print(visited_edges[i][j]+" ");
            }
            System.out.println();
        }

        for(int i = 0;i<vertices;i++)
        {
            for(int j =0;j<vertices;j++)
            {
                if(visited_edges[i][j] == 1)
                {
                    if(i==j)
                        System.out.println("There is a cycle");
                    else if(all_vertices.get(i+1)[0]<=all_vertices.get(j+1)[0] && all_vertices.get(i+1)[1]<=all_vertices.get(j+1)[1])
                        System.out.println("There is a cycle");
                    else
                        System.out.println("There is no cycle");
                }
            }
        }
        sc.close();
    }
}

