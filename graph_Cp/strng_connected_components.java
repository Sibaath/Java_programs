import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class strng_connected_components {
    static int[] visited;
    static Stack<Integer> s = new Stack<>();
    public static void main(String[] args) {
        int vertice,edges;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter vertices");
        vertice = sc.nextInt();
        System.out.println("enter edges");
        edges = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<vertice;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<edges;i++)
        {
            System.out.println("Enter a,b");
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj.get(a).add(b);
        }
        System.out.println(kosaraju(vertice, adj));

    }
    public static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        visited = new int[V];
        for(int i = 0 ; i<V ;i++)
        {
            if(visited[i]==0)
            {
                dfs(i,0,adj);
            }
        }
        ArrayList<ArrayList<Integer>> adj_new = new ArrayList<ArrayList<Integer>>();
        for(int i = 0 ; i<V; i++)
        {
            visited[i] = 0;
            adj_new.add(new ArrayList<>());
        }
        for(int i =0;i<V;i++)
        {
            for(int n : adj.get(i))
            {
                adj_new.get(n).add(i);
            }
        }
        int count = 0;
        while(!(s.isEmpty()))
        {
            if(visited[s.peek()]==0)
            {
                dfs(s.pop(),1,adj_new);
                count++;
            }
            else
            s.remove(s.indexOf(s.peek()));
        }
        return count;
    }
    static void dfs(int v,int d,ArrayList<ArrayList<Integer>> adj)
    {
        visited[v] = 1;
        for(int i : adj.get(v))
        {
            if(visited[i]==0)
            {
                dfs(i,d,adj);
            }
        }
        if(d==0)
        s.push(v);
    } 
}
