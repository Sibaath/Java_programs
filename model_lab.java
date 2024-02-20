import java.util.ArrayList;
import java.util.Scanner;

import algorithms_lab.graphs.adjacency_list;



public class model_lab {
    static int inDegree(ArrayList<ArrayList<Integer>> adjList,int vertex)
    {
        int count = 0;
        for(ArrayList<Integer> list : adjList)
        {
            for(int i : list)
            {
                if(i==vertex)
                count++;
            }
        }
        return count;
    } 

    static int outDegree(ArrayList<ArrayList<Integer>> adjList,int vertex)
    {
        return adjList.get(vertex).size();
    }

    static void printAdj(ArrayList<ArrayList<Integer>> adjList)
    {
        System.out.println("The Adjacency List is : ");
        for(int i = 0; i<adjList.size() ; i++)
        {
            System.out.print(i+"->");
            for(int n : adjList.get(i))
            {
                System.out.print(n+"->");
            }
            System.out.println();
        }
    }

    static void printDegree(ArrayList<ArrayList<Integer>> adjList)
    {
        for(int i = 0 ; i<adjList.size() ;i++)
        {
            System.out.println("The indegree of "+i+" is  : "+inDegree(adjList, i));
            System.out.println("The outdegree of "+i+" is : "+outDegree(adjList, i));
            System.out.println();
        }
    }

    static void universalSink(ArrayList<ArrayList<Integer>> adjList)
    {
        for(int i = 0 ; i<adjList.size() ; i++)
        {
            if(inDegree(adjList,i)==adjList.size()-1 && outDegree(adjList, i)==0)
            System.out.println(i+" is a universal sink");
        }
    }

    static void incidentMatrix(ArrayList<ArrayList<Integer>> edgesList,ArrayList<ArrayList<Integer>> adjList)
    {
        System.out.println(edgesList);
        int[][] incidentMatrix = new int[adjList.size()][edgesList.size()];
        for(int i = 0 ; i<adjList.size() ;i++)
        {
            for(int j = 0 ; j<edgesList.size() ; j++)
            {
                ArrayList<Integer> edge = edgesList.get(j);
                if(edge.contains(i))
                {
                    if(edge.indexOf(i)==0)
                    incidentMatrix[i][j] = -1;
                    else
                    incidentMatrix[i][j] = 1;
                }
            }
        }
        System.out.println("The incident matrix is b transpose : ");
        for(int i = 0 ; i<incidentMatrix.length ; i++)
        {
            for(int j = 0 ; j<incidentMatrix[0].length ;j++)
            {
                System.out.print(incidentMatrix[i][j]+" ");
            }
            System.out.println();
        }

        int[][] bt = new int[edgesList.size()][adjList.size()];
        for(int i = 0 ;i<incidentMatrix[0].length;i++)
        {
            for(int j =0;j<incidentMatrix.length ;j++)
            {
                // if(j<incidentMatrix.length)
                    bt[i][j] = incidentMatrix[j][i];
            }
        }

        System.out.println("The bt is : ");
        for(int i = 0 ; i<bt.length ; i++)
        {
            for(int j = 0 ; j<bt[0].length ;j++)
            {
                System.out.print(bt[i][j]+" ");
            }
            System.out.println();
        }
        int[][] mat = new int[8][8];
        for(int i = 0 ;i<5 ;i++)
        {
            for(int j =0;j<5;j++)
            {
                mat[i][j] = 0;
                for(int k = 0 ;k<8;k++)
                {
                    mat[i][j]+=incidentMatrix[i][k]*bt[k][j];
                }
            }
        }

        System.out.println("The result matrix is : ");
        for(int i = 0 ; i< 5 ;i++)
        {
            for(int j = 0 ;j<5;j++)
            {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges    = sc.nextInt();
        ArrayList<ArrayList<Integer>> edgesList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i < vertices ; i++)
            adjList.add(new ArrayList<>());
        for(int i = 0 ; i < edges ; i++)
        {
            int source = sc.nextInt();
            int dest   = sc.nextInt();
            adjList.get(source).add(dest);
            ArrayList<Integer> list = new ArrayList<>(); 
            list.add(source);
            list.add(dest);
            edgesList.add(list);
        }
        printAdj(adjList);
        System.out.println();
        printDegree(adjList);
        System.out.println();
        universalSink(adjList);
        System.out.println();
        System.out.println(edgesList);
       incidentMatrix(edgesList,adjList);
        sc.close();
    }
}
