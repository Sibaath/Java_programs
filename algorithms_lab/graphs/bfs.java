package algorithms_lab.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfs {
    public static void make_edge(ArrayList<ArrayList<Node>> vertex_list,HashMap<Integer,Node> all_vertices,int src,int destination,int type)
    {
        if(type==1)
            vertex_list.get(destination-1).add(all_vertices.get(src));
        vertex_list.get(src-1).add(all_vertices.get(destination));
    }
    public static void breadth_first_search(Node sourceNode,ArrayList<ArrayList<Node>> adjArrayList)
    {
        Queue<Node> queue = new LinkedList<>();
        queue.add(sourceNode);
        System.out.println("The BFS traversal is : ");
        while(!(queue.isEmpty()))
        {
            Node u = queue.poll();
            for(Node n : adjArrayList.get(u.vertex-1))
            {
                if(n.color=='w')
                {
                    n.color = 'g';
                    n.distance = u.distance+1;
                    n.predecessor = u.vertex;
                    queue.add(n);
                }
            }
            u.color = 'b';
            System.out.print(u.vertex);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the type of graph [Directed/undirected](0/1) : ");
        int type = sc.nextInt();
        System.out.print("Enter the number of vertices : ");
        int vertices = sc.nextInt();
        System.out.print("Enter the source node : ");
        int source = sc.nextInt();
        HashMap<Integer,Node> all_vertices = new HashMap<>();
        ArrayList<ArrayList<Node>> adjacency_list = new ArrayList<>();
        for(int i = 0;i<vertices;i++)
        {
            adjacency_list.add(new ArrayList<>());
            Node node;
            if(i+1==source)
                node = new Node(i+1, Integer.MAX_VALUE,0, 'g');
            else
                node = new Node(i+1, Integer.MAX_VALUE,Integer.MAX_VALUE, 'w');
            all_vertices.put(i+1,node);
        }
        System.out.print("Enter the number of edges : ");
        int edges = sc.nextInt();
        for(int i = 0 ;i<edges;i++)
        {
            System.out.print("Enter the source vertex for edge "+(i+1)+" : ");
            int src = sc.nextInt();
            System.out.print("Enter the Destination vertex for edge "+(i+1)+" : ");
            int destination = sc.nextInt();
            make_edge(adjacency_list,all_vertices, src, destination,type);
        }
        Node sourceNode = all_vertices.get(source);
        breadth_first_search(sourceNode,adjacency_list);
        System.out.println("\nTheAdjacency List representation is : ");
        for(int i =0;i<vertices;i++)
        {
            System.out.print(i+1+"->");
            for(int j = 0 ;j<adjacency_list.get(i).size();j++)
            {
                System.out.print(adjacency_list.get(i).get(j).vertex+"->");
            }
            System.out.println("nil");
            System.out.println();
        }
        sc.close();
    }
}
class Node
{
    int vertex,predecessor,distance;
    char color;
    public Node(int vertex,int predecessor,int distance,char color)
    {
        this.vertex = vertex;
        this.predecessor = predecessor;
        this.distance = distance;
        this.color = color;
    }

}
