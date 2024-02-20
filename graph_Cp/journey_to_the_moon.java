class Result {

    /*
     * Complete the 'journeyToMoon' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY astronaut
     */
    static void dfs(int v,ArrayList<ArrayList<Integer>> adj)
    {
        count++;
        visited[v] = 1;
        for(int i : adj.get(v))
        {
            if(visited[i]==0)
            dfs(i, adj);
        }
    }
    static int[] visited ;
    static int count = 0 ;
    public static int journeyToMoon(int n, List<List<Integer>> astronaut) {
    visited = new int[n];
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    for(int i =0;i<n;i++)
    {
        adj.add(new ArrayList<Integer>());
    }
    for(List<Integer> list : astronaut)
    {
        adj.get(list.get(0)).add(list.get(1));
        adj.get(list.get(1)).add(list.get(0));
    }
    ArrayList<Integer> arr = new ArrayList<>();
    for(int i = 0 ; i<n ; i++)
    {
        if(visited[i]==0)
        {
            count = 0;
            dfs(i,adj);
            arr.add(count);
        }
    }
            int val = (n*(n-1))/2;
        for(int a : arr)
        {
            
            val-=((a*(a-1))/2);
        }
        return val;
    }

}