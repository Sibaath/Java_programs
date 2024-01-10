package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cat_questions.arraylist;

public class permutation {
    static List<List<Integer>> permute(int[] arr)
    {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,new ArrayList<>(),arr);
        return res;
    }
    static void backtrack(List<List<Integer>> res,List<Integer> temp ,int[] arr)
    {
        if(temp.size()==arr.length)
        {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i : arr)
        {
            if(temp.contains(i))
            continue;

            temp.add(i);
            backtrack(res, temp, arr);

            temp.remove(temp.size()-1);
        }
    }
    public static void main(String[] args) {
     //   int[] arr = {1,2,3};
        // List<List<Integer>> val = permute(arr);
        // for(List<Integer> j : val)
        // {
        //     for(int i =0;i<j.size();i++)
        //     {
        //         System.out.println(j.get(i));
        //     }
        //     System.out.println();
        // }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i : list)
        {
            System.out.println(i);
        }
        System.out.println(1+'0');
        StringBuilder n = new StringBuilder();
        int[] arr = { 1,2,3,4};
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));



    }
}
