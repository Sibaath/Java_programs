package leetcode;

public class valid_anagram {
    public static boolean isAnagram(String s, String t) {
        // StringBuilder s1= new StringBuilder(s);
        // StringBuilder t1= new StringBuilder(t);
        // for(int i =0;i<s.length();i++)
        // {
        //     if(i<s1.length() && t1.toString().contains(Character.toString(s1.charAt(i))))
        //     {
        //         char ch = s1.charAt(i);
        //         s1.deleteCharAt(i);
        //         t1.deleteCharAt(t1.indexOf(Character.toString(ch)));
        //         i=-1;
        //         if(s1.length()==0 && t1.length()==0)
        //         return true;
        //     }
        // } 
        // return false;
        if(s.length()!=t.length())
        return false;
        // StringBuilder s1= new StringBuilder(s);
        // StringBuilder t1= new StringBuilder(t);
        // for(int i =0;i<s.length();i++)
        // {
        //     if(i<s1.length() && t1.toString().contains(Character.toString(s1.charAt(i))))
        //     {
        //         char ch = s1.charAt(i);
        //         s1.deleteCharAt(i);
        //         t1.deleteCharAt(t1.indexOf(Character.toString(ch)));
        //         i=-1;
        //         if(s1.length()==0 && t1.length()==0)
        //         return true;
        //     }
        // } 
        int[] nums = new int[26];
        int[] num  = new int[26]; 
        for(int i =0;i<s.length();i++)
            {
                nums[s.charAt(i)-'a']++; 
                num[t.charAt(i)-'a']++; 
            }
        for(int i =0;i<26;i++)
        {
            if(nums[i]!=num[i])
            return false;
        }
        return true;
     }
     public static void main(String[] args) {
        System.out.println(isAnagram("anagram","nagaram"));
     }
}
