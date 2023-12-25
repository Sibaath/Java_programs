package leetcode;

import java.util.ArrayList;


public class valid_mountain {
    public static boolean mountain(int[] arr)
    {
        if(arr.length<=2)
        return false;
        int max = 0;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[max]<arr[i])
            max = i;
        }
        // if(arr.length%2!=0)
        // max = arr.length/2;
        // else
        // {
        //     if(arr[arr.length/2]>arr[(arr.length/2)-1])
        //     max = arr.length/2;
        //     else
        //     max = (arr.length/2)-1;
        // }
        if(max==0|| max == arr.length-1)
        return false;
        int right = max+1;
        int left = max-1;
        int prev = max;
        while(left!=-1)
        {
            if(arr[prev]<=arr[left] || arr[max]<=arr[left])
            return false;
            prev--;     
            left--;                   
        }
        prev = max;
        if(arr[prev]==arr[right])
        return false;
        while(right!=arr.length)
        {
            if(arr[prev]<=arr[right] || arr[max]<=arr[right])
            return false;
            prev++;
            right++;
        }
        return true;
    }
    public static void main(String[] args) {
       int[] arr = {2,1,2,3,5,7,9,10,12,14,15,16,18,14,13};
//        System.out.println(mountain(arr));

    // HashMap<Integer,int[]> list = new HashMap<>();
    // int[] arr = new int[2];
    // arr[0] = 1;
    // arr[1] = 2;
    // list.put(1,arr);
    // arr=list.get(1);
    // System.out.println(arr);
    // System.out.println(list);
    ArrayList<int[]> list = new ArrayList<>();
    list.add(arr);
    System.out.println(list);
    list.remove(list.indexOf(arr));
    System.out.println(list);


    }
}
