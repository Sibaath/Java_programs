package algorithms_lab.practise.searching_and_sorting;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class graph_search
{
    static int count1,count2;
    static float linear_avg,binary_avg;

    public static void Binary_Search(ArrayList<Integer> list, int target)
    {
        int left = 0 , right = list.size()-1;
        while(left<=right)
        {
            int mid = (left+right)/2;
            if(list.get(mid)==target)
                return;
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
    }

    public static boolean linear_search(ArrayList<Integer> list , int target)
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

    public static void create_arr_and_execute(int index,int count_arr1[],int count_arr2[],boolean[] status,int n)
    {
        try
        {
            count1    = 0;
            count2    = 0;
            ArrayList<Integer> list = new ArrayList<>();
            Random rc = new Random();
            DataOutputStream op = new DataOutputStream(new FileOutputStream("input.txt"));
            for(int i = 0; i<n ;i++)
            {
                int random = rc.nextInt(100);
                op.writeInt(random);
            }
            DataInputStream ip = new DataInputStream(new FileInputStream("input.txt"));
            for(int i = 0 ; i<n ;i++)
                list.add(ip.readInt());
            status[index] = linear_search(list,rc.nextInt(100));
            Collections.sort(list);
            Binary_Search(list, rc.nextInt(n));
            linear_avg+=count1;
            binary_avg+=count2;
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
    public static void create_table(ArrayList<Integer> list,int[] linear_count,int[] binary_count,boolean[] status,float[] avg1,float[] avg2)
    {
        System.out.printf("%s%10s%10s%10s%10s\n\n","SIZE" , "NO "," LINEAR" ,"BINARY"," STATUS");
        for(int i = 0 ; i<4 ; i++)
        {
            System.out.printf("%d",list.get(i));
            for(int j = 0; j<5 ; j++)
            {
                if(j!=0)
                    System.out.printf("     %7d%10d%10d%10s\n",j+1,linear_count[(5*i)+j],binary_count[(5*i)+j],status[(5*i)+j]);
                else
                {
                    if(i==0||i==1)
                        System.out.printf("  %7d%10d%10d%10s\n",j+1,linear_count[(5*i)+j],binary_count[(5*i)+j],status[(5*i)+j]);
                    else if(i==2)
                        System.out.printf(" %7d%10d%10d%10s\n",j+1,linear_count[(5*i)+j],binary_count[(5*i)+j],status[(5*i)+j]);
                    else if(i==3)
                        System.out.printf("%7d%10d%10d%10s\n",j+1,linear_count[(5*i)+j],binary_count[(5*i)+j],status[(5*i)+j]);
                }
            }
            System.out.println();
            System.out.println("Average counts : ");
            System.out.println("Linear search : "+avg1[i]);
            System.out.println("Binary search : "+avg2[i]);
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(100);
        list1.add(500);
        list1.add(1000);
        list1.add(10000);
        int[] count_arr_linear  = new int[20];
        int[] count_arr_binary  = new int[20];
        float[] avg_linear      = new float[4];
        float[] avg_binary      = new float[4];
        boolean[] status        = new boolean[20];
        linear_avg   = 0.0f;
        binary_avg = 0.0f;
        for(int i = 0; i<20;i++)
        {
            int n = i/5;
            if(i!=0 && i%5==0)
            {
                avg_linear[n-1] = linear_avg/5;
                avg_binary[n-1]  = binary_avg/5;
                linear_avg   = 0.0f;
                binary_avg = 0.0f;
            }
            create_arr_and_execute(i,count_arr_linear,count_arr_binary,status,list1.get(n));
        }
        avg_linear[3] = linear_avg/5;
        avg_binary[3]  = binary_avg/5;
        create_table(list1,count_arr_linear,count_arr_binary,status,avg_linear,avg_binary);
        SwingUtilities.invokeLater(() -> new Search_Performance_Graph("Search Algorithm Performance", list1, avg_linear, avg_binary).setVisible(true));
    }
}
class Search_Performance_Graph extends JFrame {

    public Search_Performance_Graph(String title,ArrayList<Integer> list,float[] avgLinear, float[] avgBinary) {
        super(title);

        XYSeries linearSeries = new XYSeries("Linear Search");
        XYSeries binarySeries = new XYSeries("Binary Search");

        for (int i = 0; i < list.size(); i++) {
            linearSeries.add((double) list.get(i), avgLinear[i]);
            binarySeries.add((double) list.get(i), avgBinary[i]);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(linearSeries);
        dataset.addSeries(binarySeries);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Search Algorithm Performance",
                "Array Size",
                "Average Count",
                dataset
        );

        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true, true);
        plot.setRenderer(renderer);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
}
