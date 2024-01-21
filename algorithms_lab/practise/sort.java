package algorithms_lab.practise;
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
            // System.out.println("Enter the number of elements : ");
            // int n = sc.nextInt();
            Random rc = new Random();
            System.out.println("INSERTION SORT");
            System.out.println("--------------");
            System.out.println();
            DataOutputStream op = new DataOutputStream(new FileOutputStream("input.txt"));
            // for(int i = 0; i<n ;i++)
            // {
            //     int random = rc.nextInt(100);
            //     op.writeInt(random);
            // }
            int[] arr1 = {58,
                3,
                2,
                30,
                71,
                80,
                57,
                68,
                98,
                55,
                81,
                52,
                69,
                41,
                67,
                61,
                47,
                75,
                5,
                10,
                26,
                85,
                29,
                28,
                90,
                37,
                91,
                49,
                50,
                13,
                93,
                8,
                97,
                36,
                82,
                7,
                17,
                78,
                99,
                96,
                39,
                44,
                70,
                74,
                35,
                46,
                73,
                15,
                63,
                77,
                51,
                60,
                45,
                79,
                18,
                62,
                14,
                31,
                84,
                56,
                92,
                88,
                11,
                34,
                21,
                23,
                66,
                12,
                4,
                48,
                64,
                40,
                42,
                72,
                1,
                59,
                65,
                76,
                20,
                6,
                94,
                43,
                19,
                27,
                25,
                83,
                24,
                86,
                33,
                9,
                87,
                38,
                22,
                54,
                53,
                16,
                32,
                89,
                0,
                95};
            int[] arr2 = new int[arr1.length];
            DataInputStream ip = new DataInputStream(new FileInputStream("input.txt"));
            for(int i = 0;i<arr1.length;i++)
            {
                    // arr1[i] = ip.readInt();
                    arr2[i] = arr1[i];
            }
            long start_time = System.currentTimeMillis();
            insertion_sort(arr1);
           // long in_exec_time = start_time-System.currentTimeMillis();
            System.out.println("The execution time is : "+(System.currentTimeMillis()-start_time));
            System.out.println("The number of swaps : "+count1);
            System.out.println("The elements after swapping is : ");
            for(int i =0;i<arr1.length;i++)
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
            for(int i =0;i<arr1.length;i++)
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




