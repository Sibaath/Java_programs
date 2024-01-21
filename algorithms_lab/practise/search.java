package algorithms_lab.practise;
import java.util.*;
import java.io.*;
import org.jfree.chart.chartFactory;

public class search {
    static int count1 = 0,count2 = 0;
    public static boolean linear_search(List<Integer> list , int target)
    {
        for(int i = 0 ; i<list.size() ; i++)
        {
            if(list.get(i)==target)
            return true;
            else
            count1++;
        }
        return false;
    }
    public static boolean Binary_Search(List<Integer> list,int target)
    {
     //   System.out.println(list);
        int left = 0 , right = list.size()-1;
        while(left<=right)
        {
            int mid = (left+right)/2;
            if(list.get(mid)==target)
            return true;
            else if(list.get(mid)<target)
            {
                count2++;
                left = mid+1;
            }
            else if(list.get(mid)>target)
            {
                count2++;
                right = mid-1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        try
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the numbers : ");
            int n = sc.nextInt();
            DataOutputStream op = new DataOutputStream(new FileOutputStream("input.txt"));
            Random rc = new Random();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0 ; i<n ; i++)
            {
                int random = rc.nextInt(1000);
                op.writeInt(Math.abs(random));
            }
            DataInputStream ip = new DataInputStream(new FileInputStream("input.txt"));
            for(int i = 0 ; i<n ;i++)
            list.add(ip.readInt());
            System.out.println("Enter the targer element to be searched : ");
            int target = sc.nextInt();
            System.out.println("LINEAR SEARCH");
            System.out.println("---------------");
            long start = System.currentTimeMillis();
            if(linear_search(list,target))
                System.out.println("Element found");
            else
                System.out.println("Element not found");
            long end = (System.currentTimeMillis()-start);
            System.out.println("Execution time : "+end+"ms");
            System.out.println("No of counts(failures before finding the element) : "+count1);
            System.out.println();
            Collections.sort(list);
            System.out.println("BINARY SEARCH");
            System.out.println("---------------");
            start = System.currentTimeMillis();
            if(Binary_Search(list,target))
                System.out.println("Element found");
            else
                System.out.println("Element not found");
            System.out.println("Execution time : "+(System.currentTimeMillis()-start)+"ms");
            System.out.println("No of counts(failures before finding the element) : "+count2);
            ip.close();
            op.close();
            sc.close();
        }
        catch(Exception e)
        {

        }
    }
}
