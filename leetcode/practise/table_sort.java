package leetcode.practise;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class table_sort
{
    static int count1,count2;
    static float ins_avg,merge_avg;
    public static void swap(int[] arr,int a,int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void insertion_sort(int[] arr)
    {
            for(int i = 1; i<arr.length;i++)
            {
                int insert = i ;
                int j = i-1;
                while(j>=0)
                {
                    if(arr[i]<arr[j])
                    {
                        swap(arr,i,j);
                        i--;
                        count1++;
                    }
                    j--;
                }
                i = insert;
            }
    }
    public static void merge(int[] arr,int l,int r)
    {
        if(r>l)
        {
                int mid = (l+r)/2;
                merge(arr,l,mid);
                merge(arr,mid+1,r);
                merge_sort(arr,l,r,mid);
        }
    }

    public static void merge_sort(int[] arr,int l,int r,int mid)
    {
        int n1 = mid+1-l;
        int n2 = r-mid;
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        for(int i = 0 ; i < n1 ; i++)
            arr1[i] = arr[l+i];
        for(int i = 0 ; i < n2 ; i++)
            arr2[i] = arr[mid+1+i];
        int i = 0 ,j = 0, k = l;
        while(i<n1 && j<n2)
        {
            if(arr1[i] <= arr2[j])
                arr[k++] = arr1[i++];
            else
            {
                ++count2;
                arr[k++] = arr2 [j++];
            }
        }
        while(i<n1)
            arr[k++] = arr1[i++];
        while(j<n2)
           arr[k++] = arr2[j++];
    }    
    public static void create_arr_and_execute(int index,int count_arr1[],int count_arr2[],int n)
    {
        try
        {
            count1    = 0;
            count2    = 0;
            Random rc = new Random();
            DataOutputStream op = new DataOutputStream(new FileOutputStream("input.txt"));
            for(int i = 0; i<n ;i++)
            {
                int random = rc.nextInt(100);
                op.writeInt(random);
            }
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];
            DataInputStream ip = new DataInputStream(new FileInputStream("input.txt"));
            for(int i = 0;i<n;i++)
            {
                arr1[i] = ip.readInt();
                arr2[i] = arr1[i];
            }
            insertion_sort(arr1);
            merge(arr2, 0, n-1);
            ins_avg+=count1;
            merge_avg+=count2;
            count_arr1[index] = count1;
            count_arr2[index] = count2;
            ip.close();
            op.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static void create_table(ArrayList<Integer> list,int[] ins_count,int[] merge_count,float[] avg1,float[] avg2)
    {
        System.out.printf("%s%10s%10s%10s\n\n","SIZE" , "NO "," INSERTIONSORT" ,"MERGESORT");
        for(int i = 0 ; i<4 ; i++)
        {
            System.out.printf("%d",list.get(i));
            for(int j = 0; j<5 ; j++)
            {
                if(j!=0)
                System.out.printf("     %10d%10d%10d\n",j+1,ins_count[(5*i)+j],merge_count[(5*i)+j]);
                else
                {
                    if(i==0||i==1)
                    System.out.printf("  %10d%10d%10d\n",j+1,ins_count[(5*i)+j],merge_count[(5*i)+j]);
                    else if(i==2)
                    System.out.printf(" %10d%10d%10d\n",j+1,ins_count[(5*i)+j],merge_count[(5*i)+j]);
                    else if(i==3)
                    System.out.printf("%10d%10d%10d\n",j+1,ins_count[(5*i)+j],merge_count[(5*i)+j]);
                }
            }
            System.out.println();
            System.out.println("Average counts : ");
            System.out.println("Insertion sort : "+avg1[i]);
            System.out.println("Merge sort     : "+avg2[i]);
            System.out.println();
        }
    }
    public static void main(String[] args) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(500);
        list.add(1000);
        list.add(10000);
        int[] count_arr_ins   = new int[20];
        int[] count_arr_merge = new int[20];
        float[] avg_insert      = new float[4];
        float[] avg_merge       = new float[4];
        ins_avg   = 0.0f;
        merge_avg = 0.0f;
        for(int i = 0; i<20;i++)
        {
            int n = i/5;
            if(i!=0 && i%5==0)
            {
                avg_insert[n-1] = ins_avg/5;
                avg_merge[n-1]  = merge_avg/5;
                ins_avg   = 0.0f;
                merge_avg = 0.0f;
            }
            create_arr_and_execute(i,count_arr_ins,count_arr_merge,list.get(n));
        }
        avg_insert[3] = ins_avg/5;
        avg_merge[3]  = merge_avg/5;
        // for(int i = 0 ; i < 20 ; i++)
        // {
        //     System.out.println("Insertion sort : "+count_arr_ins[i]);
        //     System.out.println("Merge sort     : "+count_arr_merge[i]);
        // }
        // for(int i = 0 ; i<4 ;i++)
        // {
        //     System.out.println("Insertion_sort : "+avg_insert[i]);
        //     System.out.println("Merge sort     : "+avg_merge[i]);
        // }   
        create_table(list,count_arr_ins,count_arr_merge,avg_insert,avg_merge);   
    }
}

