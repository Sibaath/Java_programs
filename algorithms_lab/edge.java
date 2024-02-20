import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class dfs {
    static int time = 0;
    public static void make_edge(ArrayList<ArrayList<Node>> vertex_list,HashMap<Integer,Node> all_vertices,int src,int destination)
    {
        vertex_list.get(src-1).add(all_vertices.get(destination));
    }
    public static void depth_first_search(Node sourceNode,ArrayList<ArrayList<Node>> adjArrayList)
    {
        time+=1;
        sourceNode.st_time = time;
        sourceNode.color = 'g';
        System.out.print(sourceNode.vertex+" ");
        for(Node n : adjArrayList.get(sourceNode.vertex-1))
        {
            if(n.color=='w')
            {
                n.predecessor = sourceNode.vertex;
                depth_first_search(n,adjArrayList);
            }
        }
        time+=1;
        sourceNode.end_time=time;
        sourceNode.color = 'b';
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices : ");
        int vertices = sc.nextInt();
        HashMap<Integer,Node> all_vertices = new HashMap<>();
        ArrayList<ArrayList<Node>> adjacency_list = new ArrayList<>();
        for(int i = 0;i<vertices;i++)
        {
            adjacency_list.add(new ArrayList<>());
            edge_list.add(new ArrayList<>());
            Node node = new Node(i+1,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,'w');
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
            edge_list.get(src-1).add(0);
            make_edge(adjacency_list,all_vertices, src, destination);
        }
        for(int i =0;i<all_vertices.size();i++)
        {
            Node node = all_vertices.get(i+1);
            if(node.color=='w')
            {
                depth_first_search(node, adjacency_list,edge_list);
                System.out.println();
            }
        }
        System.out.println("\nTheAdjacency List representation is : ");
        for(int i =0;i<vertices;i++)
        {
            System.out.print(i+1+"->");
            for(int j = 0 ;j<adjacency_list.get(i).size();j++)
            {
                System.out.print("("+adjacency_list.get(i).get(j).st_time+","+adjacency_list.get(i).get(j).end_time+")"+adjacency_list.get(i).get(j).vertex+"->");
            }
            System.out.println("nil");
            System.out.println();
        }
        sc.close();
    }
    }
class Node
{
    int vertex,predecessor,st_time,end_time;
    char color;
    public Node(int vertex,int predecessor,int st_time,int end_time,char color)
    {
        this.vertex = vertex;
        this.predecessor = predecessor;
        this.st_time = st_time;
        this.end_time = end_time;
        this.color = color;
    }

}
