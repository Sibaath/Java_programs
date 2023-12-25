package leetcode;

public class binary {
 static int ans(String s)
 {
        int count = 0;
    for(int i =0;i<s.length();i++)
        count=i%2==0?(s.charAt(i)=='0'?++count:count):(s.charAt(i)=='1'?++count:count);
    return Math.min(s.length()-count,count);
 }
 public static void main(String[] args) {
    System.out.println(ans("0100"));
 }
}
