package leetcode;

import java.util.*;

public class destination {
        public static String destCity(List<List<String>> paths) {
            String source = paths.get(0).get(1);
            String destination = source;
            for(int i = 1 ; i<paths.size();i++)
            {
                List<String> list = paths.get(i);
                if(list.get(0).equals(source))
                    source = destination= list.get(1);
                else
                    continue;
            }
            return destination;
    }
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l1.add("qMTSlfgZlC");
        l1.add("ePvzZaqLXj");
        List<String> l2 = new ArrayList<>();
        l2.add("xKhZXfuBeC");
        l2.add("TtnllZpKKg");
        List<String> l3 = new ArrayList<>();
        l3.add("ePvzZaqLXj");
        l3.add("sxrvXFcqgG");
        List<String> l4 = new ArrayList<>();
        l4.add("sxrvXFcqgG");
        l4.add("xKhZXfuBeC");
        List<String> l5 = new ArrayList<>();
        l5.add("TtnllZpKKg");
        l5.add("OAxMijOZgW");
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        list.add(l5);
        System.out.println(destCity(list));
    }
}
