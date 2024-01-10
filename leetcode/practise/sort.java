package leetcode.practise;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;
import java.util.Scanner;

public class sort {
    static int count1 = 0, count2= 0;
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
    public static void main(String[] args)
    {
        try
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number of elements : ");
            int n = sc.nextInt();
            Random rc = new Random();
            System.out.println("INSERTION SORT");
            System.out.println("--------------");
            System.out.println();
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
            long start_time = System.currentTimeMillis();
            insertion_sort(arr1);
           // long in_exec_time = start_time-System.currentTimeMillis();
            System.out.println("The execution time is : "+(System.currentTimeMillis()-start_time));
            System.out.println("The number of swaps : "+count1);
            System.out.println("The elements after swapping is : ");
            for(int i =0;i<n;i++)
            {
                System.out.println(arr1[i]);
            }
            System.out.println();
            System.out.println("MERGE SORT");
            System.out.println("--------------");
            System.out.println();
            start_time = System.currentTimeMillis();
            merge(arr2,0,arr2.length-1);
            //long merge_exec_time = start_time-System.currentTimeMillis();
            System.out.println("The execution time is : "+(System.currentTimeMillis()-start_time));
            System.out.println("The number of swaps : "+count2);
            System.out.println("The elements after swapping is : ");
            for(int i =0;i<n;i++)
            {
                System.out.println(arr1[i]);
            }
            sc.close();
            op.close();
            ip.close();
        }      
        catch (Exception e)
        {
            System.out.println(e);
       
        }
    }
}




