class count_all_path
{
    static int odd = 0 ,cc = 0 ;
    static int[] indeg;
    static int[] visited;
    static public int isPossible(int[][] paths) {
    indeg = new int[paths.length];
    visited = new int[paths.length];

    for (int i = 0; i < paths.length; i++) {
        for (int j = 0; j < paths[0].length; j++) {
            if (paths[i][j] == 1)
                indeg[j]++;
        }
    }

    dfs(paths, 0);

    int n = paths.length;

    if (n == cc && odd == 0)
        return 1;
    else
        return 0;
}

static void dfs(int[][] paths, int v) {
    visited[v] = 1;
    //  odd = (indeg[v] % 2 == 1) ? 1 : odd;
    if( indeg[v]%2==1)
    odd = 1;
    cc++;

    for (int i = 0; i < paths[v].length; i++) {
        if (paths[v][i] == 1 && visited[i] == 0)
            dfs(paths, i);
    }
}  
public static void main(String[] args) {
    int[][] arr =
    {
       { 0 ,1 ,1},
{1 ,0 ,1},
{1, 1 ,0}
    };
    System.out.println(isPossible(arr));
}
}
