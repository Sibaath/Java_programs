package leetcode;

public class valid_palindrome {
    static int count = 1;
    public static boolean valid(String s)
    {
        StringBuilder s1 = new StringBuilder(s);
        int left = 0,right = s1.length()-1;
        while(left<=right)
        {
            if(s1.charAt(left)!=s1.charAt(right))
            {
                if(count==1)
                {
                    count = 0;
                    StringBuilder s2 = new StringBuilder(s);
                    return valid(s1.deleteCharAt(right).toString())||valid(s2.deleteCharAt(left).toString());
                }
                else
                return false;
            }
            left++;
            right--;
        }
        return true;
        }
    public static void main(String[] args) {
        System.out.println(valid("abc"));
    }
}
