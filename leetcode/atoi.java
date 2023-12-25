package leetcode;

public class atoi {
    public static int myAtoi(String s) {
        if(s.length()==0)
        return 0;
        long res =0L;
        int ans=0;
        int i =0;
        boolean sign = false;
        if(Character.isAlphabetic(s.charAt(0)))
        return 0;
        while(i<s.length() && s.charAt(i)==' ')
        i++;
        if(i>=s.length())
        return 0;
        if(s.charAt(i)=='-')
        {
            i++;
            sign = true;
        }
        else if(s.charAt(i)=='+')
        i++;
        for(;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(Character.isDigit(ch))
                {
                if(res+(ch-'0')>Integer.MAX_VALUE)
                {
                    if(!(sign))
                    return Integer.MAX_VALUE;
                    else
                    return Integer.MIN_VALUE;
                }
                else
               {
                    res=(res*10)+ch-'0';
                    ans=(ans*10)+ch-'0';
                }
            }   
            else
            break;
        }
        if(res>Integer.MAX_VALUE && !(sign))
        return Integer.MAX_VALUE;
        else if(sign && -1*res<=Integer.MIN_VALUE)
        return Integer.MIN_VALUE;
        else if(sign == true)
        return -1*ans;
        else
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(myAtoi("9223372036854775808"));
    }
}
